package com.jac.travels.utility;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.jac.travels.cassendra.CassandraConnector;
import com.jac.travels.kafka.ProducerUtil;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QueryBuilder {
    Logger logger = LoggerFactory.getLogger(QueryBuilder.class);
    private static final Long uniqueId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
    private String keyspaceName = "core";

    public <T> List<T> getAllData(Class<T> c) {
        List<T> lst = new ArrayList();
        String query = selectDataQuery(c);
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
            logger.info("Connection to cassandra successful");
            logger.info("Query: " + query);
            ResultSet resultSet = client.getSession().execute(query);
            for (Row row : resultSet) {
                lst.add(createObjectFromRow(c, row));
            }

        } catch (Exception e) {
            logger.error("Error fetching data from Cassandra. " + e);
            e.printStackTrace();
        }
        return lst;
    }

    @NotNull
    private <T> String selectDataQuery(Class<T> c) {
        String query = "select ";
        String tableName = c.getSimpleName();
        for (Field field : c.getDeclaredFields()) {
            query += field.getName() + ", ";
        }
        query = query.substring(0, query.lastIndexOf(","));
        query += " from " + keyspaceName + "." + tableName;
        return query;
    }

    public <T> T getDataById(Class<T> c, String idFieldName, Object idValue) {
        String query = selectDataQuery(c);
        T o = null;
        try (CassandraConnector client = new CassandraConnector()) {
            Field idField = c.getDeclaredField(idFieldName);
            if (idField.getType().equals(String.class)) {
                query += " where " + idFieldName + "='" + idValue + "'";
            } else {
                query += " where " + idFieldName + "=" + idValue;
            }
            client.connect();
            logger.info("Connection to cassandra successful");
            logger.info("Query: " + query);
            ResultSet resultSet = client.getSession().execute(query);
            Row row = resultSet.one();
            if (row != null) {
                o = createObjectFromRow(c, row);
            }

        } catch (Exception e) {
            logger.error("Error fetching data from Cassandra. " + e);
            e.printStackTrace();
        }
        return o;
    }

    private <T> T createObjectFromRow(Class<T> c, Row row) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        T o = (T) Class.forName(c.getName()).newInstance();
        for (Field field : c.getDeclaredFields()) {
            Method method = o.getClass().getMethod("set" + field.getName()
                    .replaceFirst(field.getName().substring(0, 1), field.getName()
                            .substring(0, 1).toUpperCase()), field.getType());
            if (field.getType().equals(long.class) || field.getType().equals(Long.class)) {
                method.invoke(o, row.getLong(field.getName()));
            } else if (field.getType().equals(String.class)) {
                method.invoke(o, row.getString(field.getName()));
            } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                method.invoke(o, row.getInt(field.getName()));
            } else if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
                method.invoke(o, row.getBool(field.getName()));
            }
        }
        return o;
    }

    public <T> void insertData(T o, String idFieldName) {
        try {
            Method getterId = o.getClass().getMethod("get" + idFieldName
                    .replaceFirst(idFieldName.substring(0, 1), idFieldName
                            .substring(0, 1).toUpperCase()));
            if (getDataById(o.getClass(), idFieldName, getterId.invoke(o)) == null) {
                logger.info("Object not found, trying to insert data.");
                updateData(o, idFieldName);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CassandraConnector client = new CassandraConnector()) {
            String query = insertQuery(o);
            client.connect();
            logger.info("Connection to cassandra successful");
            logger.info("Query: " + query);
            client.getSession().execute(query);
            ProducerUtil.sendMessage("kafkaCacheTopic", o.toString());
            logger.info("1 row inserted.");
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", o.toString());
            logger.error("Unable to save data. " + e);
            e.printStackTrace();
        }
    }

    private <T> String insertQuery(T o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = o.getClass();
        String tableName = c.getSimpleName();
        String query = "insert into " + keyspaceName + "." + tableName + "(";
        String value = "";
        for (Field field : c.getDeclaredFields()) {
            query += field.getName() + ", ";
            if (field.getType().equals(String.class)) {
                Method method = c.getMethod("get" + field.getName()
                        .replaceFirst(field.getName().substring(0, 1), field.getName()
                                .substring(0, 1).toUpperCase()));
                value += "'" + method.invoke(o) + "', ";
            } else if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
                Method method = c.getMethod("is" + field.getName()
                        .replaceFirst(field.getName().substring(0, 1), field.getName()
                                .substring(0, 1).toUpperCase()));
                value += method.invoke(o) + ", ";
            } else {
                Method method = c.getMethod("get" + field.getName()
                        .replaceFirst(field.getName().substring(0, 1), field.getName()
                                .substring(0, 1).toUpperCase()));
                value += method.invoke(o) + ", ";
            }
        }
        value = value.substring(0, value.lastIndexOf(","));
        query = query.substring(0, query.lastIndexOf(","));
        query += ") values(" + value + ")";
        return query;
    }

    public <T> void updateData(T o, String idFieldName) {
        try {
            Method getterId = o.getClass().getMethod("get" + idFieldName
                    .replaceFirst(idFieldName.substring(0, 1), idFieldName
                            .substring(0, 1).toUpperCase()));
            if (getDataById(o.getClass(), idFieldName, getterId.invoke(o)) == null) {
                logger.info("Object not found, trying to insert data.");
                insertData(o, idFieldName);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CassandraConnector client = new CassandraConnector()) {
            String query = updateQuery(o, idFieldName);
            client.connect();
            logger.info("Connection to cassandra successful");
            logger.info("Query: " + query);
            client.getSession().execute(query);
            ProducerUtil.sendMessage("kafkaCacheTopic", o.toString());
            logger.info("Data updated successfully.");
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", o.toString());
            logger.error("Unable to save data. " + e);
            e.printStackTrace();
        }
    }

    private <T> String updateQuery(T o, String idFieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class c = o.getClass();
        String query = "update " + keyspaceName + "." + c.getSimpleName() + " set ";
        for (Field field : c.getDeclaredFields()) {
            if (field.getName() != idFieldName) {
                if (field.getType().equals(String.class)) {
                    Method method = c.getMethod("get" + field.getName()
                            .replaceFirst(field.getName().substring(0, 1), field.getName()
                                    .substring(0, 1).toUpperCase()));
                    query += field.getName() + "='" + method.invoke(o) + "', ";
                } else if (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class)) {
                    Method method = c.getMethod("is" + field.getName()
                            .replaceFirst(field.getName().substring(0, 1), field.getName()
                                    .substring(0, 1).toUpperCase()));
                    query += field.getName() + "=" + method.invoke(o) + ", ";
                } else {
                    Method method = c.getMethod("get" + field.getName()
                            .replaceFirst(field.getName().substring(0, 1), field.getName()
                                    .substring(0, 1).toUpperCase()));
                    query += field.getName() + "=" + method.invoke(o) + ", ";
                }
            }
        }
        query = query.substring(0, query.lastIndexOf(","));
        Field idField = c.getDeclaredField(idFieldName);
        Method getterId = c.getMethod("get" + idFieldName
                .replaceFirst(idFieldName.substring(0, 1), idFieldName
                        .substring(0, 1).toUpperCase()));
        if (idField.getType().equals(String.class)) {
            query += " where " + idFieldName + "='" + getterId.invoke(o) + "'";
        } else {
            query += " where " + idFieldName + "=" + getterId.invoke(o);
        }
        return query;
    }

}
