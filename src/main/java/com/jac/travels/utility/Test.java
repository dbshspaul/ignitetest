package com.jac.travels.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.model.Property;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * created by My System on 15-Dec-17
 **/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        QueryBuilder queryBuilder = new QueryBuilder();
        ObjectMapper mapper = new ObjectMapper();
        Property property= null;
        try {
            property = mapper.readValue("{\n" +
                    "    \"property_id\": 37,\n" +
                    "    \"cutoff_time\": 14,\n" +
                    "    \"name\": \"Hotel 37\",\n" +
                    "    \"star_rating\": 4,\n" +
                    "    \"status\": true,\n" +
                    "    \"tenant_id\": \"1235p44\",\n" +
                    "    \"timezone_id\": \"UTC\"\n" +
                    "}", Property.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean b = queryBuilder.checkTenantID(property);
        System.out.println(b);
    }
}
