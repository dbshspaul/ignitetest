package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("property_allocation")
public class PropertyAllocation {
    @PrimaryKey
    private Integer property_id;
    @PrimaryKey
    private LocalDate stay_date;
    private Boolean stop_sell;

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

    public Boolean getStop_sell() {
        return stop_sell;
    }

    public void setStop_sell(Boolean stop_sell) {
        this.stop_sell = stop_sell;
    }
}
