package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.model.Rate;
import com.jac.travels.model.RatePlan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RatePlanConverter implements Converter<String,RatePlan> {

    @Override
    public RatePlan convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        RatePlan ratePlan= null;
        try {
            ratePlan = mapper.readValue(s, RatePlan.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratePlan;
    }
}
