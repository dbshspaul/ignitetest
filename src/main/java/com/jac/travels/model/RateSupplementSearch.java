package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("rate_supplement_search")
public class RateSupplementSearch {
    @PrimaryKey
    private Integer rate_plan_id;
    @PrimaryKey
    private Integer supplement_id;
    @PrimaryKey
    private Integer board_basis_id;
    @PrimaryKey
    private Byte adults;
    @PrimaryKey
    private Byte infants;
    @PrimaryKey
    private String youth_occupancy_key;
    @PrimaryKey
    private String child_occupancy_key;
    @PrimaryKey
    private LocalDate stay_date;
    private Boolean close_out;
    private Float supplement;

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
    }

    public Integer getSupplement_id() {
        return supplement_id;
    }

    public void setSupplement_id(Integer supplement_id) {
        this.supplement_id = supplement_id;
    }

    public Integer getBoard_basis_id() {
        return board_basis_id;
    }

    public void setBoard_basis_id(Integer board_basis_id) {
        this.board_basis_id = board_basis_id;
    }

    public Byte getAdults() {
        return adults;
    }

    public void setAdults(Byte adults) {
        this.adults = adults;
    }

    public Byte getInfants() {
        return infants;
    }

    public void setInfants(Byte infants) {
        this.infants = infants;
    }

    public String getYouth_occupancy_key() {
        return youth_occupancy_key;
    }

    public void setYouth_occupancy_key(String youth_occupancy_key) {
        this.youth_occupancy_key = youth_occupancy_key;
    }

    public String getChild_occupancy_key() {
        return child_occupancy_key;
    }

    public void setChild_occupancy_key(String child_occupancy_key) {
        this.child_occupancy_key = child_occupancy_key;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Boolean getClose_out() {
        return close_out;
    }

    public void setClose_out(Boolean close_out) {
        this.close_out = close_out;
    }

    public Float getSupplement() {
        return supplement;
    }

    public void setSupplement(Float supplement) {
        this.supplement = supplement;
    }
}
