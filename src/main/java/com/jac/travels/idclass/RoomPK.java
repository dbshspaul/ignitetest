package com.jac.travels.idclass;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

@PrimaryKeyClass
public class RoomPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer room_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer contract_id;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomPK)) return false;
        RoomPK roomPK = (RoomPK) o;
        return Objects.equals(getRoom_id(), roomPK.getRoom_id()) &&
                Objects.equals(getContract_id(), roomPK.getContract_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoom_id(), getContract_id());
    }

    @Override
    public String toString() {
        return "RoomPK:{" +
                "room_id=" + room_id +
                ", contract_id=" + contract_id +
                '}';
    }
}
