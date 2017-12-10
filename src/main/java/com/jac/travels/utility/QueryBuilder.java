package com.jac.travels.utility;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.jac.travels.cassendra.CassandraConnector;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        List<Field> primaryKeyFields = getPrimaryKeyFields(c);
        query += primaryKeyFields.stream().map(item -> item.getName()).collect(Collectors.joining(", ")) + ", ";
        query += Arrays.stream(c.getDeclaredFields()).filter(item -> !(primaryKeyFields.contains(item) || item.getType().getCanonicalName().startsWith("com.jac.travels.idclass"))).map(item -> item.getName()).collect(Collectors.joining(", "));
        query += " from " + keyspaceName + "." + tableName;
        return query;
    }

    public <T> T getDataById(Class<T> c, Object idValue) {
        String query = selectDataQuery(c);
        T o = null;
        try (CassandraConnector client = new CassandraConnector()) {
            query += " where " + getQueryForPK(c, idValue);
            query += " ALLOW FILTERING";
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

    private String getQueryForPK(Class clazz, Object id) {
        String clause = "";
        List<Field> fieldList = getPrimaryKeyFields(clazz);
        for (Field field : fieldList) {
            Method method = null;
            try {
                method = id.getClass().getMethod("get" + field.getName()
                        .replaceFirst(field.getName().substring(0, 1), field.getName()
                                .substring(0, 1).toUpperCase()));
            } catch (NoSuchMethodException e) {
                logger.info("Error: " + e.getMessage());
                e.printStackTrace();
            }
            Object data = null;
            try {
                data = method.invoke(id);
            } catch (Exception e) {
                logger.info("Error: " + e.getMessage());
                e.printStackTrace();
            }
            if (field.getType().equals(String.class) || field.getType().equals(LocalDate.class)) {
                clause += field.getName() + " = '" + data + "' AND ";
            } else {
                clause += field.getName() + " = " + data + " AND ";
            }
        }
        clause = clause.substring(0, clause.lastIndexOf("AND"));
        logger.info("id field where clause=> " + clause);
        return clause;
    }

    private List<Field> getPrimaryKeyFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Annotation annotation = declaredField.getAnnotation(PrimaryKey.class);
            if (annotation instanceof PrimaryKey) {
                if (declaredField.getType().getCanonicalName().startsWith("com.jac.travels.idclass")) {
                    Field[] fields = declaredField.getType().getDeclaredFields();
                    for (Field field : fields) {
                        fieldList.add(field);
                    }
                } else {
                    fieldList.add(declaredField);
                }
                break;
            }
        }
        logger.info("Id field found: " + fieldList.stream().map(item -> item.getName()).collect(Collectors.joining(", ")));
        return fieldList;
    }

    private <T, PK> T createObjectFromRow(Class<T> c, Row row) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        T o = (T) Class.forName(c.getName()).newInstance();
        for (Field field : c.getDeclaredFields()) {
            Method method = o.getClass().getMethod("set" + field.getName()
                    .replaceFirst(field.getName().substring(0, 1), field.getName()
                            .substring(0, 1).toUpperCase()), field.getType());

            if (field.getType().getCanonicalName().startsWith("com.jac.travels.idclass")) {
                PK opk = (PK) Class.forName(field.getType().getName()).newInstance();
                List<Field> primaryKeyFields = getPrimaryKeyFields(c);
                for (Field primaryKeyField : primaryKeyFields) {
                    Method primaryKeyFieldMethod = opk.getClass().getMethod("set" + primaryKeyField.getName()
                            .replaceFirst(primaryKeyField.getName().substring(0, 1), primaryKeyField.getName()
                                    .substring(0, 1).toUpperCase()), primaryKeyField.getType());
                    primaryKeyFieldMethod.invoke(opk, row.get(primaryKeyField.getName(), primaryKeyField.getType()));
                }
                method.invoke(o, opk);
            } else {
                method.invoke(o, row.get(field.getName(), field.getType()));
            }
        }
        return o;
    }

    public <T> void insertData(T o) {
        try (CassandraConnector client = new CassandraConnector()) {
            String query = insertQuery(o);
            client.connect();
            logger.info("Connection to cassandra successful");
            logger.info("Query: " + query);
            ResultSet execute = client.getSession().execute(query);
            logger.info("1 row inserted. " + execute.toString());
        } catch (Exception e) {
            logger.error("Unable to save data. " + e);
            e.printStackTrace();
        }
    }

    private <T, PK> String insertQuery(T o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = o.getClass();
        String tableName = c.getSimpleName();
        String query = "insert into " + keyspaceName + "." + tableName + "(";
        String value = "";
        for (Field field : c.getDeclaredFields()) {
            if (field.getType().getCanonicalName().startsWith("com.jac.travels.idclass")) {
                Method method = c.getMethod("get" + field.getName()
                        .replaceFirst(field.getName().substring(0, 1), field.getName()
                                .substring(0, 1).toUpperCase()));
                PK pk = (PK) method.invoke(o);
                List<Field> primaryKeyFields = getPrimaryKeyFields(c);
                for (Field primaryKeyField : primaryKeyFields) {
                    query += primaryKeyField.getName() + ", ";
                    try {
                        value = getQueryParam(field.getType(), value, primaryKeyField, pk);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                query += field.getName() + ", ";
                try {
                    value = getQueryParam(c, value, field, o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        value = value.substring(0, value.lastIndexOf(","));
        query = query.substring(0, query.lastIndexOf(","));
        query += ") values(" + value + ")";
        return query;
    }

    @NotNull
    private String getQueryParam(Class c, String value, Field field, Object o) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        if (field.getType().equals(String.class) || field.getType().equals(LocalDate.class)) {
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
        return value;
    }

    public <T> void updateData(T o, String idFieldName, String updateByFieldName, String value) {
        try {
            Method getterId = o.getClass().getMethod("get" + idFieldName
                    .replaceFirst(idFieldName.substring(0, 1), idFieldName
                            .substring(0, 1).toUpperCase()));
            if (getDataById(o.getClass(), getterId.invoke(o)) == null) {
                logger.info("Object not found, trying to insert data.");
                insertData(o);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CassandraConnector client = new CassandraConnector()) {
            String query = updateQuery(o, idFieldName, updateByFieldName, value);
            client.connect();
            logger.info("Connection to cassandra successful");
            logger.info("Query: " + query);
            client.getSession().execute(query);
            logger.info("Data updated successfully.");
        } catch (Exception e) {
            logger.error("Unable to save data. " + e);
            e.printStackTrace();
        }
    }

    private <T> String updateQuery(T o, String idFieldName, String updateByFieldName, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class c = o.getClass();
        String query = "update " + keyspaceName + "." + c.getSimpleName() + " set ";
        for (Field field : c.getDeclaredFields()) {
            if (field.getName() != idFieldName) {
                if (field.getType().equals(String.class) || field.getType().equals(LocalDate.class)) {
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


        if (updateByFieldName == null || updateByFieldName.trim() == "") {
            Field idField = c.getDeclaredField(idFieldName);
            Method getterId = c.getMethod("get" + idFieldName
                    .replaceFirst(idFieldName.substring(0, 1), idFieldName
                            .substring(0, 1).toUpperCase()));
            if (idField.getType().equals(String.class) || idField.getType().equals(LocalDate.class)) {
                query += " where " + idFieldName + "='" + getterId.invoke(o) + "'";
            } else {
                query += " where " + idFieldName + "=" + getterId.invoke(o);
            }
        } else {
            Field idField = c.getDeclaredField(updateByFieldName);
            if (idField.getType().equals(String.class) || idField.getType().equals(LocalDate.class)) {
                query += " where " + updateByFieldName + "='" + value + "'";
            } else {
                query += " where " + updateByFieldName + "=" + value;
            }
        }

        return query;
    }

}
