package com.jac.travels.model;

import com.jac.travels.idclass.RateBoardBasisUpgradePK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;
import java.util.Set;

@Table("rate_board_basis_upgrade")
public class RateBoardBasisUpgrade {
    @PrimaryKey
    private RateBoardBasisUpgradePK rateBoardBasisUpgradePK;
    private Integer board_basis_id;
    private Set<Integer> rate_plan_ids;
    private BigDecimal adult_rate;
    private BigDecimal child_rate;
    private BigDecimal youth_rate;

    public RateBoardBasisUpgradePK getRateBoardBasisUpgradePK() {
        return rateBoardBasisUpgradePK;
    }

    public void setRateBoardBasisUpgradePK(RateBoardBasisUpgradePK rateBoardBasisUpgradePK) {
        this.rateBoardBasisUpgradePK = rateBoardBasisUpgradePK;
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

    public BigDecimal getAdult_rate() {
        return adult_rate;
    }

    public void setAdult_rate(BigDecimal adult_rate) {
        this.adult_rate = adult_rate;
    }

    public BigDecimal getChild_rate() {
        return child_rate;
    }

    public void setChild_rate(BigDecimal child_rate) {
        this.child_rate = child_rate;
    }

    public BigDecimal getYouth_rate() {
        return youth_rate;
    }

    public void setYouth_rate(BigDecimal youth_rate) {
        this.youth_rate = youth_rate;
    }

    @Override
    public String toString() {
        return "RateBoardBasisUpgrade:{" +
                "rateBoardBasisUpgradePK=" + rateBoardBasisUpgradePK +
                ", board_basis_id=" + board_basis_id +
                ", rate_plan_ids=" + rate_plan_ids +
                ", adult_rate=" + adult_rate +
                ", child_rate=" + child_rate +
                ", youth_rate=" + youth_rate +
                '}';
    }
}
