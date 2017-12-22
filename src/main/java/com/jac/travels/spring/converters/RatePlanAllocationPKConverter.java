package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.idclass.RatePlanAllocationPK;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * created by My System on 21-Dec-17
 **/
@Component
public class RatePlanAllocationPKConverter implements Converter<String, RatePlanAllocationPK> {

    @Override
    public RatePlanAllocationPK convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        RatePlanAllocationPK ratePlanAllocationPK = null;
        try {
            ratePlanAllocationPK = mapper.readValue(s, RatePlanAllocationPK.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratePlanAllocationPK;
    }
}