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
                if (id.getClass().getCanonicalName().startsWith("com.jac.travels.idclass")){
                    method = id.getClass().getMethod("get" + field.getName()
                            .replaceFirst(field.getName().substring(0, 1), field.getName()
                                    .substring(0, 1).toUpperCase()));
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
                }else {
                    if (field.getType().equals(String.class) || field.getType().equals(LocalDate.class)) {
                        clause += field.getName() + " = '" + id + "' AND ";
                    } else {
                        clause += field.getName() + " = " + id + " AND ";
                    }
                }
            } catch (NoSuchMethodException e) {
                logger.info("Error: " + e.getMessage());
                e.printStackTrace();
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
            client.connect();
            if (checkTenantID(o,client)) {
                String query = insertQuery(o);
                logger.info("Connection to cassandra successful");
                logger.info("Query: " + query);
                ResultSet execute = client.getSession().execute(query);
                logger.info("1 row inserted. " + execute.toString());
            }else {
                logger.error("Invalid Tenant ID");
            }
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
        } else if (field.getType().equals(boolean.class)) {
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

    public <T> boolean checkTenantID(T o,CassandraConnector client) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> entityClass = o.getClass();
        String clause = "";
        String query = "select tenant_id from "+ keyspaceName + "." +entityClass.getSimpleName()+" where ";
        boolean isValidTenant = false;
        //todo manage for composit key
        Method getTenantId = entityClass.getMethod("getTenant_id");
        String tenantId = (String) getTenantId.invoke(o);
        List<Field> primaryKeyFields = getPrimaryKeyFields(entityClass);
        for (Field field : primaryKeyFields) {
            Method method = entityClass.getMethod("get" + field.getName()
                    .replaceFirst(field.getName().substring(0, 1), field.getName()
                            .substring(0, 1).toUpperCase()));
            Object data = method.invoke(o);
            if (field.getType().equals(String.class) || field.getType().equals(LocalDate.class)) {
                clause += field.getName() + " = '" + data + "' AND ";
            } else {
                clause += field.getName() + " = " + data + " AND ";
            }
        }
        query += clause.substring(0, clause.lastIndexOf("AND"))+" ALLOW FILTERING";
        logger.info("id field where clause=> " + clause);
            ResultSet resultSet = client.getSession().execute(query);
            if (resultSet.getAvailableWithoutFetching()!=0) {
                for (Row row : resultSet) {
                    if(row.getString("tenant_id").equals(tenantId)){
                        isValidTenant = true;
                        break;
                    }
                }
            }else {
                isValidTenant = true;
            }
        return isValidTenant;
    }

}
