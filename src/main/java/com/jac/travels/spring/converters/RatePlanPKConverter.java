package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.idclass.RatePlanPK;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * created by My System on 21-Dec-17
 **/
@Component
public class RatePlanPKConverter implements Converter<String, RatePlanPK> {

    @Override
    public RatePlanPK convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        RatePlanPK ratePlanPK = null;
        try {
            ratePlanPK = mapper.readValue(s, RatePlanPK.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratePlanPK;
    }
}