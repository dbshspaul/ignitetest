package com.jac.travels.spring.service;

import com.jac.travels.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll();
    Room getRoomById(int id);
}
