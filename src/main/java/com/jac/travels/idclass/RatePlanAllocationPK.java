package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;

import java.util.Objects;

public class RatePlanAllocationPK {
    private Integer rate_plan_id;
    private LocalDate stay_date;

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
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
        if (!(o instanceof RatePlanAllocationPK)) return false;
        RatePlanAllocationPK that = (RatePlanAllocationPK) o;
        return Objects.equals(getRate_plan_id(), that.getRate_plan_id()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRate_plan_id(), getStay_date());
    }

    @Override
    public String toString() {
        return "RatePlanAllocationPK:{" +
                "rate_plan_id=" + rate_plan_id +
                ", stay_date=" + stay_date +
                '}';
    }
}
