package com.jac.travels.idclass;

import java.util.Objects;

public class ContractPK {
    private Integer contract_id;
    private Integer property_id;

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractPK)) return false;
        ContractPK that = (ContractPK) o;
        return Objects.equals(getContract_id(), that.getContract_id()) &&
                Objects.equals(getProperty_id(), that.getProperty_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getContract_id(), getProperty_id());
    }

    @Override
    public String toString() {
        return "ContractPK:{" +
                "contract_id=" + contract_id +
                ", property_id=" + property_id +
                '}';
    }
}
