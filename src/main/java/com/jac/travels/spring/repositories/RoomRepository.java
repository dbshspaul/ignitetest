package com.jac.travels.spring.repositories;

import com.jac.travels.model.Room;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CassandraRepository<Room> {
}
