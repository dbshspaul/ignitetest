package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;

import java.util.Objects;

public class RoomAllocationPK {
    private Integer room_id;
    private LocalDate stay_date;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomAllocationPK)) return false;
        RoomAllocationPK that = (RoomAllocationPK) o;
        return Objects.equals(getRoom_id(), that.getRoom_id()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoom_id(), getStay_date());
    }

    @Override
    public String toString() {
        return "RoomAllocationPK:{" +
                "room_id=" + room_id +
                ", stay_date=" + stay_date +
                '}';
    }
}
