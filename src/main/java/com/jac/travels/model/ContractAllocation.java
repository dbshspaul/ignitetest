package com.jac.travels.model;

import com.jac.travels.idclass.ContractAllocationPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("contract")
public class ContractAllocation {
    @PrimaryKey
    private ContractAllocationPK contractAllocationPK;
    private Integer max_duration;
    private Integer min_duration;
    private Boolean stop_sell;

    public ContractAllocationPK getContractAllocationPK() {
        return contractAllocationPK;
    }

    public void setContractAllocationPK(ContractAllocationPK contractAllocationPK) {
        this.contractAllocationPK = contractAllocationPK;
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

    @Override
    public String toString() {
        return "ContractAllocation:{" +
                "contractAllocationPK=" + contractAllocationPK +
                ", max_duration=" + max_duration +
                ", min_duration=" + min_duration +
                ", stop_sell=" + stop_sell +
                '}';
    }
}
