package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.List;

@Table("special_offer_discount")
public class SpecialOfferDiscount {
    @PrimaryKey
    private Integer special_offer_id;
    @PrimaryKey
    private Boolean is_customer;
    @PrimaryKey
    private LocalDate stay_from;
    @PrimaryKey
    private LocalDate stay_to;
    @PrimaryKey
    private Byte day_of_week;
    private Boolean all_adults_free;
    private Boolean all_children_free;
    private Float discount;
    private Float discount_adult;
    private Float discount_child;
    private Float discount_youth;
    private List<Byte> free_adult_indexes;
    private List<Byte> free_child_indexes;
    private Byte free_nights;
    private Byte max_stay;
    private Byte min_stay;
    private Float sup_charge_adult;
    private Float sup_charge_children;
    private Float sup_charge_room;
    private Float sup_charge_youth;

    public Integer getSpecial_offer_id() {
        return special_offer_id;
    }

    public void setSpecial_offer_id(Integer special_offer_id) {
        this.special_offer_id = special_offer_id;
    }

    public Boolean getIs_customer() {
        return is_customer;
    }

    public void setIs_customer(Boolean is_customer) {
        this.is_customer = is_customer;
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

    public Byte getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Byte day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Boolean getAll_adults_free() {
        return all_adults_free;
    }

    public void setAll_adults_free(Boolean all_adults_free) {
        this.all_adults_free = all_adults_free;
    }

    public Boolean getAll_children_free() {
        return all_children_free;
    }

    public void setAll_children_free(Boolean all_children_free) {
        this.all_children_free = all_children_free;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getDiscount_adult() {
        return discount_adult;
    }

    public void setDiscount_adult(Float discount_adult) {
        this.discount_adult = discount_adult;
    }

    public Float getDiscount_child() {
        return discount_child;
    }

    public void setDiscount_child(Float discount_child) {
        this.discount_child = discount_child;
    }

    public Float getDiscount_youth() {
        return discount_youth;
    }

    public void setDiscount_youth(Float discount_youth) {
        this.discount_youth = discount_youth;
    }

    public List<Byte> getFree_adult_indexes() {
        return free_adult_indexes;
    }

    public void setFree_adult_indexes(List<Byte> free_adult_indexes) {
        this.free_adult_indexes = free_adult_indexes;
    }

    public List<Byte> getFree_child_indexes() {
        return free_child_indexes;
    }

    public void setFree_child_indexes(List<Byte> free_child_indexes) {
        this.free_child_indexes = free_child_indexes;
    }

    public Byte getFree_nights() {
        return free_nights;
    }

    public void setFree_nights(Byte free_nights) {
        this.free_nights = free_nights;
    }

    public Byte getMax_stay() {
        return max_stay;
    }

    public void setMax_stay(Byte max_stay) {
        this.max_stay = max_stay;
    }

    public Byte getMin_stay() {
        return min_stay;
    }

    public void setMin_stay(Byte min_stay) {
        this.min_stay = min_stay;
    }

    public Float getSup_charge_adult() {
        return sup_charge_adult;
    }

    public void setSup_charge_adult(Float sup_charge_adult) {
        this.sup_charge_adult = sup_charge_adult;
    }

    public Float getSup_charge_children() {
        return sup_charge_children;
    }

    public void setSup_charge_children(Float sup_charge_children) {
        this.sup_charge_children = sup_charge_children;
    }

    public Float getSup_charge_room() {
        return sup_charge_room;
    }

    public void setSup_charge_room(Float sup_charge_room) {
        this.sup_charge_room = sup_charge_room;
    }

    public Float getSup_charge_youth() {
        return sup_charge_youth;
    }

    public void setSup_charge_youth(Float sup_charge_youth) {
        this.sup_charge_youth = sup_charge_youth;
    }
}
