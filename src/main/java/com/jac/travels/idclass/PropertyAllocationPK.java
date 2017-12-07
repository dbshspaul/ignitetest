package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;

import java.util.Objects;

public class PropertyAllocationPK {
    private Integer property_id;
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
}
