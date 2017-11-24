package com.jac.travels.spring.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.model.Rate;
import com.jac.travels.model.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RoomConverter implements Converter<String,Room> {

    @Override
    public Room convert(String s) {
        ObjectMapper mapper = new ObjectMapper();
        Room room= null;
        try {
            room = mapper.readValue(s, Room.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return room;
    }
}
