package com.jac.travels.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.model.Property;
import com.jac.travels.model.Rate;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * created by My System on 15-Dec-17
 **/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PrimaryKey annotation = Rate.class.getDeclaredAnnotation(PrimaryKey.class);
        for (Field field : Rate.class.getDeclaredFields()) {
            if(field.isAnnotationPresent(PrimaryKey.class))
            System.out.println(field.getName()+" = " + field.getAnnotation(PrimaryKey.class).value());
        }
    }
}
