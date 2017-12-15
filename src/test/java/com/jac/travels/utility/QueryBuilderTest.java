package com.jac.travels.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.cassendra.CassandraConnector;
import com.jac.travels.model.Property;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * created by My System on 14-Dec-17
 **/
public class QueryBuilderTest {

    QueryBuilder queryBuilder = new QueryBuilder();

    @Test
    public void getAllData() {
        assertEquals("as","as");
    }

    @Test
    public void getDataById() {
    }

    @Test
    public void insertData() {
    }

    @Test
    public void updateData() {
    }

    @Test
    public void checkTenantID() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ObjectMapper mapper = new ObjectMapper();
        Property property= null;
        try {
            property = mapper.readValue("{\n" +
                    "    \"property_id\": 88,\n" +
                    "    \"cutoff_time\": 14,\n" +
                    "    \"name\": \"Hotel 37\",\n" +
                    "    \"star_rating\": 4,\n" +
                    "    \"status\": true,\n" +
                    "    \"tenant_id\": \"123pok44\",\n" +
                    "    \"timezone_id\": \"UTC\"\n" +
                    "}", Property.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean b=false;
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
            b = queryBuilder.checkTenantID(property,client);
        }catch (Exception e){

        }
        assertEquals(true,b);
    }
}