package com.jac.travels.idclass;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

@PrimaryKeyClass
public class RatePlanPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer room_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer rate_plan_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;


    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatePlanPK)) return false;
        RatePlanPK that = (RatePlanPK) o;
        return Objects.equals(getRoom_id(), that.getRoom_id()) &&
                Objects.equals(getRate_plan_id(), that.getRate_plan_id()) &&
                Objects.equals(getTenant_id(), that.getTenant_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoom_id(), getRate_plan_id(), getTenant_id());
    }

    @Override
    public String toString() {
        return "RatePlanPK:{" +
                "room_id=" + room_id +
                ", rate_plan_id=" + rate_plan_id +
                '}';
    }
}
