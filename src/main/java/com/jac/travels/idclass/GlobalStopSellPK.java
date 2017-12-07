package com.jac.travels.idclass;

import java.util.Objects;

public class GlobalStopSellPK {
    private Integer property_id;
    private Integer contract_id;

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GlobalStopSellPK)) return false;
        GlobalStopSellPK that = (GlobalStopSellPK) o;
        return Objects.equals(getProperty_id(), that.getProperty_id()) &&
                Objects.equals(getContract_id(), that.getContract_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getProperty_id(), getContract_id());
    }

    @Override
    public String toString() {
        return "GlobalStopSellPK:{" +
                "property_id=" + property_id +
                ", contract_id=" + contract_id +
                '}';
    }
}
