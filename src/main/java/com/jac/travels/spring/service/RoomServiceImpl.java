package com.jac.travels.spring.service;

import com.jac.travels.model.Room;
import com.jac.travels.spring.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Override
    public List<Room> getAll() {
        return (List<Room>) roomRepository.findAll();
    }
}
