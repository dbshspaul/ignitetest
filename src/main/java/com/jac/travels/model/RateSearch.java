package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.List;

@Table("rate_search")
public class RateSearch {
    @PrimaryKey
    private Integer rate_plan_id;
    @PrimaryKey
    private Integer board_basis_id;
    @PrimaryKey
    private Byte adults;
    @PrimaryKey
    private Byte infants;
    @PrimaryKey
    private String child_occupancy_key;
    @PrimaryKey
    private String youth_occupancy_key;
    @PrimaryKey
    private LocalDate stay_date;
    private Float base_rate;
    private List<Float> bbu_rates;
    private List<Float> occupant_rates;
    private Float rate;

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
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

    public String getChild_occupancy_key() {
        return child_occupancy_key;
    }

    public void setChild_occupancy_key(String child_occupancy_key) {
        this.child_occupancy_key = child_occupancy_key;
    }

    public String getYouth_occupancy_key() {
        return youth_occupancy_key;
    }

    public void setYouth_occupancy_key(String youth_occupancy_key) {
        this.youth_occupancy_key = youth_occupancy_key;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Float getBase_rate() {
        return base_rate;
    }

    public void setBase_rate(Float base_rate) {
        this.base_rate = base_rate;
    }

    public List<Float> getBbu_rates() {
        return bbu_rates;
    }

    public void setBbu_rates(List<Float> bbu_rates) {
        this.bbu_rates = bbu_rates;
    }

    public List<Float> getOccupant_rates() {
        return occupant_rates;
    }

    public void setOccupant_rates(List<Float> occupant_rates) {
        this.occupant_rates = occupant_rates;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}