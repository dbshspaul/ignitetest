package com.jac.travels.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Map;

@Table("global_stop_sell")
public class GlobalStopSell {
    @PrimaryKey
    private	Integer	property_id;
    private	Boolean	property_stop_sell;
    @PrimaryKey
    private	Integer	contract_id;
    private	Boolean	contract_stop_sell;
    private Map<Integer, Boolean> rate_plan_stop_sell;
    private	Map<Integer, Boolean>	room_stop_sell;

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Boolean getProperty_stop_sell() {
        return property_stop_sell;
    }

    public void setProperty_stop_sell(Boolean property_stop_sell) {
        this.property_stop_sell = property_stop_sell;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public Boolean getContract_stop_sell() {
        return contract_stop_sell;
    }

    public void setContract_stop_sell(Boolean contract_stop_sell) {
        this.contract_stop_sell = contract_stop_sell;
    }

    public Map<Integer, Boolean> getRate_plan_stop_sell() {
        return rate_plan_stop_sell;
    }

    public void setRate_plan_stop_sell(Map<Integer, Boolean> rate_plan_stop_sell) {
        this.rate_plan_stop_sell = rate_plan_stop_sell;
    }

    public Map<Integer, Boolean> getRoom_stop_sell() {
        return room_stop_sell;
    }

    public void setRoom_stop_sell(Map<Integer, Boolean> room_stop_sell) {
        this.room_stop_sell = room_stop_sell;
    }
}
