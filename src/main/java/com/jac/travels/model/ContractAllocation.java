package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("contract")
public class ContractAllocation {
    @PrimaryKey
    private Integer contract_id;
    @PrimaryKey
    private LocalDate stay_date;
    private Integer max_duration;
    private Integer min_duration;
    private Boolean stop_sell;

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Integer getMax_duration() {
        return max_duration;
    }

    public void setMax_duration(Integer max_duration) {
        this.max_duration = max_duration;
    }

    public Integer getMin_duration() {
        return min_duration;
    }

    public void setMin_duration(Integer min_duration) {
        this.min_duration = min_duration;
    }

    public Boolean getStop_sell() {
        return stop_sell;
    }

    public void setStop_sell(Boolean stop_sell) {
        this.stop_sell = stop_sell;
    }
}
