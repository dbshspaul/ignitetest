package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

@PrimaryKeyClass
public class RatePK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer rate_plan_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
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
        if (!(o instanceof RatePK)) return false;
        RatePK ratePK = (RatePK) o;
        return Objects.equals(getStay_date(), ratePK.getStay_date()) &&
                Objects.equals(getRate_plan_id(), ratePK.getRate_plan_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStay_date(), getRate_plan_id());
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "RatePK:{" +
                "stay_date=" + stay_date +
                ", rate_plan_id=" + rate_plan_id +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }
}
