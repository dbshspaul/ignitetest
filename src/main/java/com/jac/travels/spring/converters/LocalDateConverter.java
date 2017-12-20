package com.jac.travels.spring.converters;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.ContractPK;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * created by My System on 20-Dec-17
 **/
@Component
public class LocalDateConverter  implements Converter<String,LocalDate> {

    @Override
    public LocalDate convert(String s) {
        return LocalDate.fromDaysSinceEpoch(Integer.parseInt(s));
    }
}
