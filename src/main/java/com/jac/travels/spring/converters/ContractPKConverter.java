package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.idclass.ContractPK;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * created by My System on 19-Dec-17
 **/
@Component
public class ContractPKConverter implements Converter<String,ContractPK>{
    @Override
    public ContractPK convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        ContractPK contractPK= null;
        try {
            contractPK = mapper.readValue(s, ContractPK.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractPK;
    }
}
