package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Set;

@Table("special_offer")
public class SpecialOffer {
    @PrimaryKey
    private Integer special_offer_id;
    private Byte adult_max_occ;
    private Byte adult_min_occ;
    private Byte applicable_days;
    private Byte arrival_days;
    private Set<Integer> board_basis_ids;
    private LocalDate booking_from;
    private LocalDate booking_to;
    private Set<Byte> booking_type_ids;
    private Set<Byte> channel_type_ids;
    private Byte children_max_age;
    private Byte children_max_occ;
    private Byte children_min_age;
    private Byte children_min_occ;
    private String description;
    private Byte include_days;
    private Boolean is_combinable;
    private Boolean is_daily;
    private Boolean is_disabled;
    private Boolean is_for_adults_standard_occupancy;
    private Boolean is_lateral;
    private Boolean is_occupancy;
    private Boolean is_per_night;
    private Boolean is_per_person;
    private Integer max_book_ahead;
    private Integer max_discount_days;
    private Integer max_duration;
    private Integer min_book_ahead;
    private Integer min_duration;
    private Boolean only_for_base_rate;
    private Boolean recurring_discount;
    private Byte recurring_occurrences;
    private Byte spo_applies_at_type_id;
    private Byte spo_supplement_type_id;
    private Integer spo_type_id;
    private Byte stay_date_type;
    private Boolean supplementary_charges;
    private Byte youth_max_age;
    private Byte youth_max_occ;
    private Byte youth_min_age;
    private Byte youth_min_occ;

    public Integer getSpecial_offer_id() {
        return special_offer_id;
    }

    public void setSpecial_offer_id(Integer special_offer_id) {
        this.special_offer_id = special_offer_id;
    }

    public Byte getAdult_max_occ() {
        return adult_max_occ;
    }

    public void setAdult_max_occ(Byte adult_max_occ) {
        this.adult_max_occ = adult_max_occ;
    }

    public Byte getAdult_min_occ() {
        return adult_min_occ;
    }

    public void setAdult_min_occ(Byte adult_min_occ) {
        this.adult_min_occ = adult_min_occ;
    }

    public Byte getApplicable_days() {
        return applicable_days;
    }

    public void setApplicable_days(Byte applicable_days) {
        this.applicable_days = applicable_days;
    }

    public Byte getArrival_days() {
        return arrival_days;
    }

    public void setArrival_days(Byte arrival_days) {
        this.arrival_days = arrival_days;
    }

    public Set<Integer> getBoard_basis_ids() {
        return board_basis_ids;
    }

    public void setBoard_basis_ids(Set<Integer> board_basis_ids) {
        this.board_basis_ids = board_basis_ids;
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

    public Set<Byte> getBooking_type_ids() {
        return booking_type_ids;
    }

    public void setBooking_type_ids(Set<Byte> booking_type_ids) {
        this.booking_type_ids = booking_type_ids;
    }

    public Set<Byte> getChannel_type_ids() {
        return channel_type_ids;
    }

    public void setChannel_type_ids(Set<Byte> channel_type_ids) {
        this.channel_type_ids = channel_type_ids;
    }

    public Byte getChildren_max_age() {
        return children_max_age;
    }

    public void setChildren_max_age(Byte children_max_age) {
        this.children_max_age = children_max_age;
    }

    public Byte getChildren_max_occ() {
        return children_max_occ;
    }

    public void setChildren_max_occ(Byte children_max_occ) {
        this.children_max_occ = children_max_occ;
    }

    public Byte getChildren_min_age() {
        return children_min_age;
    }

    public void setChildren_min_age(Byte children_min_age) {
        this.children_min_age = children_min_age;
    }

    public Byte getChildren_min_occ() {
        return children_min_occ;
    }

    public void setChildren_min_occ(Byte children_min_occ) {
        this.children_min_occ = children_min_occ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getInclude_days() {
        return include_days;
    }

    public void setInclude_days(Byte include_days) {
        this.include_days = include_days;
    }

    public Boolean getIs_combinable() {
        return is_combinable;
    }

    public void setIs_combinable(Boolean is_combinable) {
        this.is_combinable = is_combinable;
    }

    public Boolean getIs_daily() {
        return is_daily;
    }

    public void setIs_daily(Boolean is_daily) {
        this.is_daily = is_daily;
    }

    public Boolean getIs_disabled() {
        return is_disabled;
    }

    public void setIs_disabled(Boolean is_disabled) {
        this.is_disabled = is_disabled;
    }

    public Boolean getIs_for_adults_standard_occupancy() {
        return is_for_adults_standard_occupancy;
    }

    public void setIs_for_adults_standard_occupancy(Boolean is_for_adults_standard_occupancy) {
        this.is_for_adults_standard_occupancy = is_for_adults_standard_occupancy;
    }

    public Boolean getIs_lateral() {
        return is_lateral;
    }

    public void setIs_lateral(Boolean is_lateral) {
        this.is_lateral = is_lateral;
    }

    public Boolean getIs_occupancy() {
        return is_occupancy;
    }

    public void setIs_occupancy(Boolean is_occupancy) {
        this.is_occupancy = is_occupancy;
    }

    public Boolean getIs_per_night() {
        return is_per_night;
    }

    public void setIs_per_night(Boolean is_per_night) {
        this.is_per_night = is_per_night;
    }

    public Boolean getIs_per_person() {
        return is_per_person;
    }

    public void setIs_per_person(Boolean is_per_person) {
        this.is_per_person = is_per_person;
    }

    public Integer getMax_book_ahead() {
        return max_book_ahead;
    }

    public void setMax_book_ahead(Integer max_book_ahead) {
        this.max_book_ahead = max_book_ahead;
    }

    public Integer getMax_discount_days() {
        return max_discount_days;
    }

    public void setMax_discount_days(Integer max_discount_days) {
        this.max_discount_days = max_discount_days;
    }

    public Integer getMax_duration() {
        return max_duration;
    }

    public void setMax_duration(Integer max_duration) {
        this.max_duration = max_duration;
    }

    public Integer getMin_book_ahead() {
        return min_book_ahead;
    }

    public void setMin_book_ahead(Integer min_book_ahead) {
        this.min_book_ahead = min_book_ahead;
    }

    public Integer getMin_duration() {
        return min_duration;
    }

    public void setMin_duration(Integer min_duration) {
        this.min_duration = min_duration;
    }

    public Boolean getOnly_for_base_rate() {
        return only_for_base_rate;
    }

    public void setOnly_for_base_rate(Boolean only_for_base_rate) {
        this.only_for_base_rate = only_for_base_rate;
    }

    public Boolean getRecurring_discount() {
        return recurring_discount;
    }

    public void setRecurring_discount(Boolean recurring_discount) {
        this.recurring_discount = recurring_discount;
    }

    public Byte getRecurring_occurrences() {
        return recurring_occurrences;
    }

    public void setRecurring_occurrences(Byte recurring_occurrences) {
        this.recurring_occurrences = recurring_occurrences;
    }

    public Byte getSpo_applies_at_type_id() {
        return spo_applies_at_type_id;
    }

    public void setSpo_applies_at_type_id(Byte spo_applies_at_type_id) {
        this.spo_applies_at_type_id = spo_applies_at_type_id;
    }

    public Byte getSpo_supplement_type_id() {
        return spo_supplement_type_id;
    }

    public void setSpo_supplement_type_id(Byte spo_supplement_type_id) {
        this.spo_supplement_type_id = spo_supplement_type_id;
    }

    public Integer getSpo_type_id() {
        return spo_type_id;
    }

    public void setSpo_type_id(Integer spo_type_id) {
        this.spo_type_id = spo_type_id;
    }

    public Byte getStay_date_type() {
        return stay_date_type;
    }

    public void setStay_date_type(Byte stay_date_type) {
        this.stay_date_type = stay_date_type;
    }

    public Boolean getSupplementary_charges() {
        return supplementary_charges;
    }

    public void setSupplementary_charges(Boolean supplementary_charges) {
        this.supplementary_charges = supplementary_charges;
    }

    public Byte getYouth_max_age() {
        return youth_max_age;
    }

    public void setYouth_max_age(Byte youth_max_age) {
        this.youth_max_age = youth_max_age;
    }

    public Byte getYouth_max_occ() {
        return youth_max_occ;
    }

    public void setYouth_max_occ(Byte youth_max_occ) {
        this.youth_max_occ = youth_max_occ;
    }

    public Byte getYouth_min_age() {
        return youth_min_age;
    }

    public void setYouth_min_age(Byte youth_min_age) {
        this.youth_min_age = youth_min_age;
    }

    public Byte getYouth_min_occ() {
        return youth_min_occ;
    }

    public void setYouth_min_occ(Byte youth_min_occ) {
        this.youth_min_occ = youth_min_occ;
    }
}
