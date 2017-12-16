package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class RateSupplementPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer supplement_i_d;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;

    public Integer getSupplement_i_d() {
        return supplement_i_d;
    }

    public void setSupplement_i_d(Integer supplement_i_d) {
        this.supplement_i_d = supplement_i_d;
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
        if (!(o instanceof RateSupplementPK)) return false;
        RateSupplementPK that = (RateSupplementPK) o;
        return Objects.equals(getSupplement_i_d(), that.getSupplement_i_d()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getSupplement_i_d(), getStay_date());
    }

    @Override
    public String toString() {
        return "RateSupplementPK:{" +
                "supplement_i_d=" + supplement_i_d +
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
