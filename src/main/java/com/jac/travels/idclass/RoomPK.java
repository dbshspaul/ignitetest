package com.jac.travels.idclass;

import java.util.Objects;

public class RoomPK {
    private Integer room_id;
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
