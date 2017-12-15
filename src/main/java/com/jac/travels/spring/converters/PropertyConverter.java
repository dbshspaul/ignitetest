package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.model.Property;
import com.jac.travels.model.Rate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PropertyConverter implements Converter<String,Property> {

    @Override
    public Property convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        Property property= null;
        try {
            property = mapper.readValue(s, Property.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
