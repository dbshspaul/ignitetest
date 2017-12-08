package com.jac.travels.model;

import com.jac.travels.idclass.GlobalStopSellPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Map;

@Table("global_stop_sell")
public class GlobalStopSell {
    @PrimaryKey
    private GlobalStopSellPK globalStopSellPK;
    private Boolean property_stop_sell;
    private Boolean contract_stop_sell;
    private Map<Integer, Boolean> rate_plan_stop_sell;
    private Map<Integer, Boolean> room_stop_sell;

    public GlobalStopSellPK getGlobalStopSellPK() {
        return globalStopSellPK;
    }

    public void setGlobalStopSellPK(GlobalStopSellPK globalStopSellPK) {
        this.globalStopSellPK = globalStopSellPK;
    }

    public Boolean getProperty_stop_sell() {
        return property_stop_sell;
    }

    public void setProperty_stop_sell(Boolean property_stop_sell) {
        this.property_stop_sell = property_stop_sell;
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

    @Override
    public String toString() {
        return "GlobalStopSell:{" +
                "globalStopSellPK=" + globalStopSellPK +
                ", property_stop_sell=" + property_stop_sell +
                ", contract_stop_sell=" + contract_stop_sell +
                ", rate_plan_stop_sell=" + rate_plan_stop_sell +
                ", room_stop_sell=" + room_stop_sell +
                '}';
    }
}
