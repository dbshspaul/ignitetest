package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("rate_supplement")
public class RateSupplement {
    @PrimaryKey
    private Integer supplement_i_d;
    private Integer adult2_calculation_type_id;
    private Integer child1_calculation_type_id;
    private boolean child_price_split;
    private Integer child_price_split1_max;
    private Integer child_price_split1_min;
    private Integer child_price_split2_max;
    private Integer child_price_split2_min;
    private Integer child_pricing_type_id;
    private Integer double_calculation_type_id;
    private Integer occupant_type_id;
    private Integer single_calculation_type_id;
    private Integer triple_calculation_type_id;
    private Integer youth1_calculation_type_id;
    private boolean youth_price_split;
    private Integer youth_price_split1_max;
    private Integer youth_price_split1_min;
    private Integer youth_price_split2_max;
    private Integer youth_price_split2_min;
    private Integer youth_pricing_type_id;
    @PrimaryKey
    private LocalDate stay_date;
    private Float adult2_charge;
    private Float base_rate;
    private Float child1_charge;
    private Float child1_split2_charge;
    private Float double_occ_charge;
    private Float single_occ_charge;
    private Float triple_occ_charge;
    private Float youth1_charge;
    private Float youth1_split2_charge;

    public Integer getSupplement_i_d() {
        return supplement_i_d;
    }

    public void setSupplement_i_d(Integer supplement_i_d) {
        this.supplement_i_d = supplement_i_d;
    }

    public Integer getAdult2_calculation_type_id() {
        return adult2_calculation_type_id;
    }

    public void setAdult2_calculation_type_id(Integer adult2_calculation_type_id) {
        this.adult2_calculation_type_id = adult2_calculation_type_id;
    }

    public Integer getChild1_calculation_type_id() {
        return child1_calculation_type_id;
    }

    public void setChild1_calculation_type_id(Integer child1_calculation_type_id) {
        this.child1_calculation_type_id = child1_calculation_type_id;
    }

    public boolean isChild_price_split() {
        return child_price_split;
    }

    public void setChild_price_split(boolean child_price_split) {
        this.child_price_split = child_price_split;
    }

    public Integer getChild_price_split1_max() {
        return child_price_split1_max;
    }

    public void setChild_price_split1_max(Integer child_price_split1_max) {
        this.child_price_split1_max = child_price_split1_max;
    }

    public Integer getChild_price_split1_min() {
        return child_price_split1_min;
    }

    public void setChild_price_split1_min(Integer child_price_split1_min) {
        this.child_price_split1_min = child_price_split1_min;
    }

    public Integer getChild_price_split2_max() {
        return child_price_split2_max;
    }

    public void setChild_price_split2_max(Integer child_price_split2_max) {
        this.child_price_split2_max = child_price_split2_max;
    }

    public Integer getChild_price_split2_min() {
        return child_price_split2_min;
    }

    public void setChild_price_split2_min(Integer child_price_split2_min) {
        this.child_price_split2_min = child_price_split2_min;
    }

    public Integer getChild_pricing_type_id() {
        return child_pricing_type_id;
    }

    public void setChild_pricing_type_id(Integer child_pricing_type_id) {
        this.child_pricing_type_id = child_pricing_type_id;
    }

    public Integer getDouble_calculation_type_id() {
        return double_calculation_type_id;
    }

    public void setDouble_calculation_type_id(Integer double_calculation_type_id) {
        this.double_calculation_type_id = double_calculation_type_id;
    }

    public Integer getOccupant_type_id() {
        return occupant_type_id;
    }

    public void setOccupant_type_id(Integer occupant_type_id) {
        this.occupant_type_id = occupant_type_id;
    }

    public Integer getSingle_calculation_type_id() {
        return single_calculation_type_id;
    }

    public void setSingle_calculation_type_id(Integer single_calculation_type_id) {
        this.single_calculation_type_id = single_calculation_type_id;
    }

    public Integer getTriple_calculation_type_id() {
        return triple_calculation_type_id;
    }

    public void setTriple_calculation_type_id(Integer triple_calculation_type_id) {
        this.triple_calculation_type_id = triple_calculation_type_id;
    }

    public Integer getYouth1_calculation_type_id() {
        return youth1_calculation_type_id;
    }

    public void setYouth1_calculation_type_id(Integer youth1_calculation_type_id) {
        this.youth1_calculation_type_id = youth1_calculation_type_id;
    }

    public boolean isYouth_price_split() {
        return youth_price_split;
    }

    public void setYouth_price_split(boolean youth_price_split) {
        this.youth_price_split = youth_price_split;
    }

    public Integer getYouth_price_split1_max() {
        return youth_price_split1_max;
    }

    public void setYouth_price_split1_max(Integer youth_price_split1_max) {
        this.youth_price_split1_max = youth_price_split1_max;
    }

    public Integer getYouth_price_split1_min() {
        return youth_price_split1_min;
    }

    public void setYouth_price_split1_min(Integer youth_price_split1_min) {
        this.youth_price_split1_min = youth_price_split1_min;
    }

    public Integer getYouth_price_split2_max() {
        return youth_price_split2_max;
    }

    public void setYouth_price_split2_max(Integer youth_price_split2_max) {
        this.youth_price_split2_max = youth_price_split2_max;
    }

    public Integer getYouth_price_split2_min() {
        return youth_price_split2_min;
    }

    public void setYouth_price_split2_min(Integer youth_price_split2_min) {
        this.youth_price_split2_min = youth_price_split2_min;
    }

    public Integer getYouth_pricing_type_id() {
        return youth_pricing_type_id;
    }

    public void setYouth_pricing_type_id(Integer youth_pricing_type_id) {
        this.youth_pricing_type_id = youth_pricing_type_id;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Float getAdult2_charge() {
        return adult2_charge;
    }

    public void setAdult2_charge(Float adult2_charge) {
        this.adult2_charge = adult2_charge;
    }

    public Float getBase_rate() {
        return base_rate;
    }

    public void setBase_rate(Float base_rate) {
        this.base_rate = base_rate;
    }

    public Float getChild1_charge() {
        return child1_charge;
    }

    public void setChild1_charge(Float child1_charge) {
        this.child1_charge = child1_charge;
    }

    public Float getChild1_split2_charge() {
        return child1_split2_charge;
    }

    public void setChild1_split2_charge(Float child1_split2_charge) {
        this.child1_split2_charge = child1_split2_charge;
    }

    public Float getDouble_occ_charge() {
        return double_occ_charge;
    }

    public void setDouble_occ_charge(Float double_occ_charge) {
        this.double_occ_charge = double_occ_charge;
    }

    public Float getSingle_occ_charge() {
        return single_occ_charge;
    }

    public void setSingle_occ_charge(Float single_occ_charge) {
        this.single_occ_charge = single_occ_charge;
    }

    public Float getTriple_occ_charge() {
        return triple_occ_charge;
    }

    public void setTriple_occ_charge(Float triple_occ_charge) {
        this.triple_occ_charge = triple_occ_charge;
    }

    public Float getYouth1_charge() {
        return youth1_charge;
    }

    public void setYouth1_charge(Float youth1_charge) {
        this.youth1_charge = youth1_charge;
    }

    public Float getYouth1_split2_charge() {
        return youth1_split2_charge;
    }

    public void setYouth1_split2_charge(Float youth1_split2_charge) {
        this.youth1_split2_charge = youth1_split2_charge;
    }
}
