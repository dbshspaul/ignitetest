package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;

import java.util.Objects;

public class ContractAllocationPK {
    private Integer contract_id;
    private LocalDate stay_date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractAllocationPK)) return false;
        ContractAllocationPK that = (ContractAllocationPK) o;
        return Objects.equals(getContract_id(), that.getContract_id()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getContract_id(), getStay_date());
    }

    @Override
    public String toString() {
        return "ContractAllocationPK: {" +
                "contract_id=" + contract_id +
                ", stay_date=" + stay_date +
                '}';
    }
}
