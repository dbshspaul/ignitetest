package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class PropertyAllocationPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer property_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
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
        if (!(o instanceof PropertyAllocationPK)) return false;
        PropertyAllocationPK that = (PropertyAllocationPK) o;
        return Objects.equals(getProperty_id(), that.getProperty_id()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProperty_id(), getStay_date());
    }

    @Override
    public String toString() {
        return "PropertyAllocationPK:{" +
                "property_id=" + property_id +
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
