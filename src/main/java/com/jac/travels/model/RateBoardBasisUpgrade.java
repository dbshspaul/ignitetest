package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Set;

@Table("rate_board_basis_upgrade")
public class RateBoardBasisUpgrade {
    @PrimaryKey
    private Integer board_basis_upgrade_id;
    private Integer board_basis_id;
    private Set<Integer> rate_plan_ids;
    @PrimaryKey
    private LocalDate stay_date;
    private Float adult_rate;
    private Float child_rate;
    private Float youth_rate;

    public Integer getBoard_basis_upgrade_id() {
        return board_basis_upgrade_id;
    }

    public void setBoard_basis_upgrade_id(Integer board_basis_upgrade_id) {
        this.board_basis_upgrade_id = board_basis_upgrade_id;
    }

    public Integer getBoard_basis_id() {
        return board_basis_id;
    }

    public void setBoard_basis_id(Integer board_basis_id) {
        this.board_basis_id = board_basis_id;
    }

    public Set<Integer> getRate_plan_ids() {
        return rate_plan_ids;
    }

    public void setRate_plan_ids(Set<Integer> rate_plan_ids) {
        this.rate_plan_ids = rate_plan_ids;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Float getAdult_rate() {
        return adult_rate;
    }

    public void setAdult_rate(Float adult_rate) {
        this.adult_rate = adult_rate;
    }

    public Float getChild_rate() {
        return child_rate;
    }

    public void setChild_rate(Float child_rate) {
        this.child_rate = child_rate;
    }

    public Float getYouth_rate() {
        return youth_rate;
    }

    public void setYouth_rate(Float youth_rate) {
        this.youth_rate = youth_rate;
    }
}
