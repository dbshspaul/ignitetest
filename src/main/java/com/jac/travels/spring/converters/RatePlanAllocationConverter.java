package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.model.RatePlan;
import com.jac.travels.model.RatePlanAllocation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * created by My System on 21-Dec-17
 **/
@Component
public class RatePlanAllocationConverter implements Converter<String,RatePlanAllocation> {

    @Override
    public RatePlanAllocation convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        RatePlanAllocation ratePlanAllocation= null;
        try {
            ratePlanAllocation = mapper.readValue(s, RatePlanAllocation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratePlanAllocation;
    }
}