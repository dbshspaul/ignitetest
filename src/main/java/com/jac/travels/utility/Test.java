package com.jac.travels.utility;

import com.jac.travels.model.Rate;
import com.jac.travels.model.RatePlan;
import com.jac.travels.model.Room;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import java.lang.reflect.Field;

/**
 * created by My System on 15-Dec-17
 **/
public class Test {
    public static void main(String[] args) {
        String str = "";
        Field[] declaredFields = Room.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            PrimaryKey declaredAnnotation = declaredField.getAnnotation(PrimaryKey.class);
            if (declaredAnnotation != null) {
                Field[] idFields = declaredField.getType().getDeclaredFields();
                for (Field idField : idFields) {
                    String idFieldName = idField.getName();
                    str +=  getString(idFieldName)
                            +"(room.get"+fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase())+"().get"+idFieldName.replaceFirst(idFieldName.substring(0, 1), idFieldName.substring(0, 1).toUpperCase())+ "())\n";
                }
            } else {
                str += getString(fieldName)
                        +"(room.get"+fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase())+ "())\n";
            }
        }
        System.out.println(str);
    }

    private static String getString(String idFieldName) {
        String str = ".set";
        for (String s : idFieldName.split("_")) {
            str += s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase());
        }
        return str;
    }
}
