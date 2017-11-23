package com.jac.travels.spring.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.jac.travels.model.Room;
import com.jac.travels.spring.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    private CassandraOperations cassandraTemplate;

    @Override
    public List<Room> getAll() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Room getRoomById(int roomId) {
        Select select = QueryBuilder.select().from("room");
        select.where(QueryBuilder.eq("room_id", roomId));
        return cassandraTemplate.selectOne(select, Room.class);
    }
}
