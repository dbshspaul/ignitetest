package com.jac.travels.model;

public class Room {
   private int contract_id;
   private int room_id;
   private int adult_max;
   private int adult_min;
   private int adult_with_child_max;
   private boolean allow_child_close_out;
   private boolean allow_child_youth_close_out;
   private boolean auto_upgrade_child_to_adult;
   private boolean child_occ_only_allowed;
   private int children_max;
   private int children_max_age;
   private int children_min;
   private int children_min_age;
   private int cots_max;
   private boolean exclude_adult_child_combinations;
   private boolean extra_beds_used;
   private boolean extra_rate_allocation;
   private boolean has_durations_defined;
   private boolean has_inventory_defined;
   private boolean has_occ_allocation_defined;
   private boolean has_split_inventory_defined;
   private int infant_max_age;
   private boolean infants_count_toward_occupancy;
   private int max_adults_extra_bed;
   private int max_children_extra_bed;
   private int max_occupancy_before_extra_bed;
   private int occupancy_max;
   private int occupancy_min;
   private int occupancy_standard;
   private String room_type_code;
   private String room_type_name;
   private int senior_min_age;
   private boolean youth_count_as_adults;
   private int youth_max_age;
   private int youth_min_age;

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getAdult_max() {
        return adult_max;
    }

    public void setAdult_max(int adult_max) {
        this.adult_max = adult_max;
    }

    public int getAdult_min() {
        return adult_min;
    }

    public void setAdult_min(int adult_min) {
        this.adult_min = adult_min;
    }

    public int getAdult_with_child_max() {
        return adult_with_child_max;
    }

    public void setAdult_with_child_max(int adult_with_child_max) {
        this.adult_with_child_max = adult_with_child_max;
    }

    public boolean isAllow_child_close_out() {
        return allow_child_close_out;
    }

    public void setAllow_child_close_out(boolean allow_child_close_out) {
        this.allow_child_close_out = allow_child_close_out;
    }

    public boolean isAllow_child_youth_close_out() {
        return allow_child_youth_close_out;
    }

    public void setAllow_child_youth_close_out(boolean allow_child_youth_close_out) {
        this.allow_child_youth_close_out = allow_child_youth_close_out;
    }

    public boolean isAuto_upgrade_child_to_adult() {
        return auto_upgrade_child_to_adult;
    }

    public void setAuto_upgrade_child_to_adult(boolean auto_upgrade_child_to_adult) {
        this.auto_upgrade_child_to_adult = auto_upgrade_child_to_adult;
    }

    public boolean isChild_occ_only_allowed() {
        return child_occ_only_allowed;
    }

    public void setChild_occ_only_allowed(boolean child_occ_only_allowed) {
        this.child_occ_only_allowed = child_occ_only_allowed;
    }

    public int getChildren_max() {
        return children_max;
    }

    public void setChildren_max(int children_max) {
        this.children_max = children_max;
    }

    public int getChildren_max_age() {
        return children_max_age;
    }

    public void setChildren_max_age(int children_max_age) {
        this.children_max_age = children_max_age;
    }

    public int getChildren_min() {
        return children_min;
    }

    public void setChildren_min(int children_min) {
        this.children_min = children_min;
    }

    public int getChildren_min_age() {
        return children_min_age;
    }

    public void setChildren_min_age(int children_min_age) {
        this.children_min_age = children_min_age;
    }

    public int getCots_max() {
        return cots_max;
    }

    public void setCots_max(int cots_max) {
        this.cots_max = cots_max;
    }

    public boolean isExclude_adult_child_combinations() {
        return exclude_adult_child_combinations;
    }

    public void setExclude_adult_child_combinations(boolean exclude_adult_child_combinations) {
        this.exclude_adult_child_combinations = exclude_adult_child_combinations;
    }

    public boolean isExtra_beds_used() {
        return extra_beds_used;
    }

    public void setExtra_beds_used(boolean extra_beds_used) {
        this.extra_beds_used = extra_beds_used;
    }

    public boolean isExtra_rate_allocation() {
        return extra_rate_allocation;
    }

    public void setExtra_rate_allocation(boolean extra_rate_allocation) {
        this.extra_rate_allocation = extra_rate_allocation;
    }

    public boolean isHas_durations_defined() {
        return has_durations_defined;
    }

    public void setHas_durations_defined(boolean has_durations_defined) {
        this.has_durations_defined = has_durations_defined;
    }

    public boolean isHas_inventory_defined() {
        return has_inventory_defined;
    }

    public void setHas_inventory_defined(boolean has_inventory_defined) {
        this.has_inventory_defined = has_inventory_defined;
    }

    public boolean isHas_occ_allocation_defined() {
        return has_occ_allocation_defined;
    }

    public void setHas_occ_allocation_defined(boolean has_occ_allocation_defined) {
        this.has_occ_allocation_defined = has_occ_allocation_defined;
    }

    public boolean isHas_split_inventory_defined() {
        return has_split_inventory_defined;
    }

    public void setHas_split_inventory_defined(boolean has_split_inventory_defined) {
        this.has_split_inventory_defined = has_split_inventory_defined;
    }

    public int getInfant_max_age() {
        return infant_max_age;
    }

    public void setInfant_max_age(int infant_max_age) {
        this.infant_max_age = infant_max_age;
    }

    public boolean isInfants_count_toward_occupancy() {
        return infants_count_toward_occupancy;
    }

    public void setInfants_count_toward_occupancy(boolean infants_count_toward_occupancy) {
        this.infants_count_toward_occupancy = infants_count_toward_occupancy;
    }

    public int getMax_adults_extra_bed() {
        return max_adults_extra_bed;
    }

    public void setMax_adults_extra_bed(int max_adults_extra_bed) {
        this.max_adults_extra_bed = max_adults_extra_bed;
    }

    public int getMax_children_extra_bed() {
        return max_children_extra_bed;
    }

    public void setMax_children_extra_bed(int max_children_extra_bed) {
        this.max_children_extra_bed = max_children_extra_bed;
    }

    public int getMax_occupancy_before_extra_bed() {
        return max_occupancy_before_extra_bed;
    }

    public void setMax_occupancy_before_extra_bed(int max_occupancy_before_extra_bed) {
        this.max_occupancy_before_extra_bed = max_occupancy_before_extra_bed;
    }

    public int getOccupancy_max() {
        return occupancy_max;
    }

    public void setOccupancy_max(int occupancy_max) {
        this.occupancy_max = occupancy_max;
    }

    public int getOccupancy_min() {
        return occupancy_min;
    }

    public void setOccupancy_min(int occupancy_min) {
        this.occupancy_min = occupancy_min;
    }

    public int getOccupancy_standard() {
        return occupancy_standard;
    }

    public void setOccupancy_standard(int occupancy_standard) {
        this.occupancy_standard = occupancy_standard;
    }

    public String getRoom_type_code() {
        return room_type_code;
    }

    public void setRoom_type_code(String room_type_code) {
        this.room_type_code = room_type_code;
    }

    public String getRoom_type_name() {
        return room_type_name;
    }

    public void setRoom_type_name(String room_type_name) {
        this.room_type_name = room_type_name;
    }

    public int getSenior_min_age() {
        return senior_min_age;
    }

    public void setSenior_min_age(int senior_min_age) {
        this.senior_min_age = senior_min_age;
    }

    public boolean isYouth_count_as_adults() {
        return youth_count_as_adults;
    }

    public void setYouth_count_as_adults(boolean youth_count_as_adults) {
        this.youth_count_as_adults = youth_count_as_adults;
    }

    public int getYouth_max_age() {
        return youth_max_age;
    }

    public void setYouth_max_age(int youth_max_age) {
        this.youth_max_age = youth_max_age;
    }

    public int getYouth_min_age() {
        return youth_min_age;
    }

    public void setYouth_min_age(int youth_min_age) {
        this.youth_min_age = youth_min_age;
    }

    @Override
    public String toString() {
        return "Room:{" +
                "contract_id=" + contract_id +
                ", room_id=" + room_id +
                ", adult_max=" + adult_max +
                ", adult_min=" + adult_min +
                ", adult_with_child_max=" + adult_with_child_max +
                ", allow_child_close_out=" + allow_child_close_out +
                ", allow_child_youth_close_out=" + allow_child_youth_close_out +
                ", auto_upgrade_child_to_adult=" + auto_upgrade_child_to_adult +
                ", child_occ_only_allowed=" + child_occ_only_allowed +
                ", children_max=" + children_max +
                ", children_max_age=" + children_max_age +
                ", children_min=" + children_min +
                ", children_min_age=" + children_min_age +
                ", cots_max=" + cots_max +
                ", exclude_adult_child_combinations=" + exclude_adult_child_combinations +
                ", extra_beds_used=" + extra_beds_used +
                ", extra_rate_allocation=" + extra_rate_allocation +
                ", has_durations_defined=" + has_durations_defined +
                ", has_inventory_defined=" + has_inventory_defined +
                ", has_occ_allocation_defined=" + has_occ_allocation_defined +
                ", has_split_inventory_defined=" + has_split_inventory_defined +
                ", infant_max_age=" + infant_max_age +
                ", infants_count_toward_occupancy=" + infants_count_toward_occupancy +
                ", max_adults_extra_bed=" + max_adults_extra_bed +
                ", max_children_extra_bed=" + max_children_extra_bed +
                ", max_occupancy_before_extra_bed=" + max_occupancy_before_extra_bed +
                ", occupancy_max=" + occupancy_max +
                ", occupancy_min=" + occupancy_min +
                ", occupancy_standard=" + occupancy_standard +
                ", room_type_code='" + room_type_code + '\'' +
                ", room_type_name='" + room_type_name + '\'' +
                ", senior_min_age=" + senior_min_age +
                ", youth_count_as_adults=" + youth_count_as_adults +
                ", youth_max_age=" + youth_max_age +
                ", youth_min_age=" + youth_min_age +
                '}';
    }
}
