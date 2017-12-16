package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class RoomAllocationPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer room_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;

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

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }
}
