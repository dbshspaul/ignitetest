package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.TupleType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Table("rate_plan")
public class RatePlan {
    @PrimaryKey
    private Integer room_id;
    @PrimaryKey
    private Integer rate_plan_id;
    private Integer adult_occupant_type_id;
    private Integer allocation_type_id;
    private Boolean allow_child_close_out;
    private Boolean allow_child_youth_close_out;
    private Integer arrival_days;
    private Integer base_rate_plan_id;
    private Integer board_basis_id;
    private Boolean board_basis_upgrade;
    private Map<Integer, Integer> board_basis_upgrades;
    private LocalDate booking_from;
    private LocalDate booking_to;
    private Integer booking_type_id;
    private Set<Integer> brands;
    private Set<Byte> channel_type_ids;
    private Integer child_occupant_type_id;
    private Boolean child_rate_split;
    private Integer child_rate_split1_max_age;
    private Integer child_rate_split1_min_age;
    private Integer child_rate_split2_max_age;
    private Integer child_rate_split2_min_age;
    private Set<Integer> countries;
    private Integer duration_based_pricing_value;
    private Set<Integer> exclusive_to;
    private Float floating_rate_discount;
    private Integer follow_on_rate_plan_id;
    private Float gross_commission;
    private Boolean has_bbu_inventory_defined;
    private Boolean has_durations_defined;
    private Boolean has_inventory_defined;
    private Boolean has_split_inventory_defined;
    private Integer include_days;
    private Boolean no_end_String;
    private Map<Integer, Byte> rate_code_ids;
    private Integer rate_grid_type_id;
    private String rate_plan_name;
    private Integer rate_type_id;
    private Set<Integer> special_offer_ids;
    private LocalDate stay_from;
    private LocalDate stay_to;
    private Set<Integer> supplement_ids;
//    private Map<String,List<TupleType>> supported_occ_combos;
    private Boolean use_duration_based_pricing;
    private Integer youth_occupant_type_id;
    private Boolean youth_rate_split;
    private Integer youth_rate_split1_max_age;
    private Integer youth_rate_split1_min_age;
    private Integer youth_rate_split2_max_age;
    private Integer youth_rate_split2_min_age;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
    }

    public Integer getAdult_occupant_type_id() {
        return adult_occupant_type_id;
    }

    public void setAdult_occupant_type_id(Integer adult_occupant_type_id) {
        this.adult_occupant_type_id = adult_occupant_type_id;
    }

    public Integer getAllocation_type_id() {
        return allocation_type_id;
    }

    public void setAllocation_type_id(Integer allocation_type_id) {
        this.allocation_type_id = allocation_type_id;
    }

    public Boolean getAllow_child_close_out() {
        return allow_child_close_out;
    }

    public void setAllow_child_close_out(Boolean allow_child_close_out) {
        this.allow_child_close_out = allow_child_close_out;
    }

    public Boolean getAllow_child_youth_close_out() {
        return allow_child_youth_close_out;
    }

    public void setAllow_child_youth_close_out(Boolean allow_child_youth_close_out) {
        this.allow_child_youth_close_out = allow_child_youth_close_out;
    }

    public Integer getArrival_days() {
        return arrival_days;
    }

    public void setArrival_days(Integer arrival_days) {
        this.arrival_days = arrival_days;
    }

    public Integer getBase_rate_plan_id() {
        return base_rate_plan_id;
    }

    public void setBase_rate_plan_id(Integer base_rate_plan_id) {
        this.base_rate_plan_id = base_rate_plan_id;
    }

    public Integer getBoard_basis_id() {
        return board_basis_id;
    }

    public void setBoard_basis_id(Integer board_basis_id) {
        this.board_basis_id = board_basis_id;
    }

    public Boolean getBoard_basis_upgrade() {
        return board_basis_upgrade;
    }

    public void setBoard_basis_upgrade(Boolean board_basis_upgrade) {
        this.board_basis_upgrade = board_basis_upgrade;
    }

    public Map<Integer, Integer> getBoard_basis_upgrades() {
        return board_basis_upgrades;
    }

    public void setBoard_basis_upgrades(Map<Integer, Integer> board_basis_upgrades) {
        this.board_basis_upgrades = board_basis_upgrades;
    }

    public LocalDate getBooking_from() {
        return booking_from;
    }

    public void setBooking_from(LocalDate booking_from) {
        this.booking_from = booking_from;
    }

    public LocalDate getBooking_to() {
        return booking_to;
    }

    public void setBooking_to(LocalDate booking_to) {
        this.booking_to = booking_to;
    }

    public Integer getBooking_type_id() {
        return booking_type_id;
    }

    public void setBooking_type_id(Integer booking_type_id) {
        this.booking_type_id = booking_type_id;
    }

    public Set<Integer> getBrands() {
        return brands;
    }

    public void setBrands(Set<Integer> brands) {
        this.brands = brands;
    }

    public Integer getChild_occupant_type_id() {
        return child_occupant_type_id;
    }

    public void setChild_occupant_type_id(Integer child_occupant_type_id) {
        this.child_occupant_type_id = child_occupant_type_id;
    }

    public Boolean getChild_rate_split() {
        return child_rate_split;
    }

    public void setChild_rate_split(Boolean child_rate_split) {
        this.child_rate_split = child_rate_split;
    }

    public Integer getChild_rate_split1_max_age() {
        return child_rate_split1_max_age;
    }

    public void setChild_rate_split1_max_age(Integer child_rate_split1_max_age) {
        this.child_rate_split1_max_age = child_rate_split1_max_age;
    }

    public Integer getChild_rate_split1_min_age() {
        return child_rate_split1_min_age;
    }

    public void setChild_rate_split1_min_age(Integer child_rate_split1_min_age) {
        this.child_rate_split1_min_age = child_rate_split1_min_age;
    }

    public Integer getChild_rate_split2_max_age() {
        return child_rate_split2_max_age;
    }

    public void setChild_rate_split2_max_age(Integer child_rate_split2_max_age) {
        this.child_rate_split2_max_age = child_rate_split2_max_age;
    }

    public Integer getChild_rate_split2_min_age() {
        return child_rate_split2_min_age;
    }

    public void setChild_rate_split2_min_age(Integer child_rate_split2_min_age) {
        this.child_rate_split2_min_age = child_rate_split2_min_age;
    }

    public Set<Integer> getCountries() {
        return countries;
    }

    public void setCountries(Set<Integer> countries) {
        this.countries = countries;
    }

    public Integer getDuration_based_pricing_value() {
        return duration_based_pricing_value;
    }

    public void setDuration_based_pricing_value(Integer duration_based_pricing_value) {
        this.duration_based_pricing_value = duration_based_pricing_value;
    }

    public Set<Integer> getExclusive_to() {
        return exclusive_to;
    }

    public void setExclusive_to(Set<Integer> exclusive_to) {
        this.exclusive_to = exclusive_to;
    }

    public Float getFloating_rate_discount() {
        return floating_rate_discount;
    }

    public void setFloating_rate_discount(Float floating_rate_discount) {
        this.floating_rate_discount = floating_rate_discount;
    }

    public Integer getFollow_on_rate_plan_id() {
        return follow_on_rate_plan_id;
    }

    public void setFollow_on_rate_plan_id(Integer follow_on_rate_plan_id) {
        this.follow_on_rate_plan_id = follow_on_rate_plan_id;
    }

    public Float getGross_commission() {
        return gross_commission;
    }

    public void setGross_commission(Float gross_commission) {
        this.gross_commission = gross_commission;
    }

    public Boolean getHas_bbu_inventory_defined() {
        return has_bbu_inventory_defined;
    }

    public void setHas_bbu_inventory_defined(Boolean has_bbu_inventory_defined) {
        this.has_bbu_inventory_defined = has_bbu_inventory_defined;
    }

    public Boolean getHas_durations_defined() {
        return has_durations_defined;
    }

    public void setHas_durations_defined(Boolean has_durations_defined) {
        this.has_durations_defined = has_durations_defined;
    }

    public Boolean getHas_inventory_defined() {
        return has_inventory_defined;
    }

    public void setHas_inventory_defined(Boolean has_inventory_defined) {
        this.has_inventory_defined = has_inventory_defined;
    }

    public Boolean getHas_split_inventory_defined() {
        return has_split_inventory_defined;
    }

    public void setHas_split_inventory_defined(Boolean has_split_inventory_defined) {
        this.has_split_inventory_defined = has_split_inventory_defined;
    }

    public Integer getInclude_days() {
        return include_days;
    }

    public void setInclude_days(Integer include_days) {
        this.include_days = include_days;
    }

    public Boolean getNo_end_String() {
        return no_end_String;
    }

    public void setNo_end_String(Boolean no_end_String) {
        this.no_end_String = no_end_String;
    }

    public Set<Byte> getChannel_type_ids() {
        return channel_type_ids;
    }

    public void setChannel_type_ids(Set<Byte> channel_type_ids) {
        this.channel_type_ids = channel_type_ids;
    }

    public Map<Integer, Byte> getRate_code_ids() {
        return rate_code_ids;
    }

    public void setRate_code_ids(Map<Integer, Byte> rate_code_ids) {
        this.rate_code_ids = rate_code_ids;
    }

    public Integer getRate_grid_type_id() {
        return rate_grid_type_id;
    }

    public void setRate_grid_type_id(Integer rate_grid_type_id) {
        this.rate_grid_type_id = rate_grid_type_id;
    }

    public String getRate_plan_name() {
        return rate_plan_name;
    }

    public void setRate_plan_name(String rate_plan_name) {
        this.rate_plan_name = rate_plan_name;
    }

    public Integer getRate_type_id() {
        return rate_type_id;
    }

    public void setRate_type_id(Integer rate_type_id) {
        this.rate_type_id = rate_type_id;
    }

    public Set<Integer> getSpecial_offer_ids() {
        return special_offer_ids;
    }

    public void setSpecial_offer_ids(Set<Integer> special_offer_ids) {
        this.special_offer_ids = special_offer_ids;
    }

    public LocalDate getStay_from() {
        return stay_from;
    }

    public void setStay_from(LocalDate stay_from) {
        this.stay_from = stay_from;
    }

    public LocalDate getStay_to() {
        return stay_to;
    }

    public void setStay_to(LocalDate stay_to) {
        this.stay_to = stay_to;
    }

    public Set<Integer> getSupplement_ids() {
        return supplement_ids;
    }

    public void setSupplement_ids(Set<Integer> supplement_ids) {
        this.supplement_ids = supplement_ids;
    }

    public Boolean getUse_duration_based_pricing() {
        return use_duration_based_pricing;
    }

    public void setUse_duration_based_pricing(Boolean use_duration_based_pricing) {
        this.use_duration_based_pricing = use_duration_based_pricing;
    }

    public Integer getYouth_occupant_type_id() {
        return youth_occupant_type_id;
    }

    public void setYouth_occupant_type_id(Integer youth_occupant_type_id) {
        this.youth_occupant_type_id = youth_occupant_type_id;
    }

    public Boolean getYouth_rate_split() {
        return youth_rate_split;
    }

    public void setYouth_rate_split(Boolean youth_rate_split) {
        this.youth_rate_split = youth_rate_split;
    }

    public Integer getYouth_rate_split1_max_age() {
        return youth_rate_split1_max_age;
    }

    public void setYouth_rate_split1_max_age(Integer youth_rate_split1_max_age) {
        this.youth_rate_split1_max_age = youth_rate_split1_max_age;
    }

    public Integer getYouth_rate_split1_min_age() {
        return youth_rate_split1_min_age;
    }

    public void setYouth_rate_split1_min_age(Integer youth_rate_split1_min_age) {
        this.youth_rate_split1_min_age = youth_rate_split1_min_age;
    }

    public Integer getYouth_rate_split2_max_age() {
        return youth_rate_split2_max_age;
    }

    public void setYouth_rate_split2_max_age(Integer youth_rate_split2_max_age) {
        this.youth_rate_split2_max_age = youth_rate_split2_max_age;
    }

    public Integer getYouth_rate_split2_min_age() {
        return youth_rate_split2_min_age;
    }

    public void setYouth_rate_split2_min_age(Integer youth_rate_split2_min_age) {
        this.youth_rate_split2_min_age = youth_rate_split2_min_age;
    }
}
