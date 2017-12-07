package com.jac.travels.idclass;

import java.util.Objects;

public class RatePlanPK {
    private Integer room_id;
    private Integer rate_plan_id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatePlanPK)) return false;
        RatePlanPK that = (RatePlanPK) o;
        return Objects.equals(getRoom_id(), that.getRoom_id()) &&
                Objects.equals(getRate_plan_id(), that.getRate_plan_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoom_id(), getRate_plan_id());
    }

    @Override
    public String toString() {
        return "RatePlanPK:{" +
                "room_id=" + room_id +
                ", rate_plan_id=" + rate_plan_id +
                '}';
    }
}
