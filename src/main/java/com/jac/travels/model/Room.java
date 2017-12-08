package com.jac.travels.model;

import com.jac.travels.idclass.RoomPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("room")
public class Room {
    @PrimaryKey
    private RoomPK roomPK;
    private Integer adult_max;
    private Integer adult_min;
    private Integer adult_with_child_max;
    private Boolean allow_child_close_out;
    private Boolean allow_child_youth_close_out;
    private Boolean auto_upgrade_child_to_adult;
    private Boolean child_occ_only_allowed;
    private Integer children_max;
    private Integer children_max_age;
    private Integer children_min;
    private Integer children_min_age;
    private Integer cots_max;
    private Boolean exclude_adult_child_combinations;
    private Boolean extra_beds_used;
    private Boolean extra_rate_allocation;
    private Boolean has_durations_defined;
    private Boolean has_inventory_defined;
    private Boolean has_occ_allocation_defined;
    private Boolean has_split_inventory_defined;
    private Integer infant_max_age;
    private Boolean infants_count_toward_occupancy;
    private Integer max_adults_extra_bed;
    private Integer max_children_extra_bed;
    private Integer max_occupancy_before_extra_bed;
    private Integer occupancy_max;
    private Integer occupancy_min;
    private Integer occupancy_standard;
    private String room_type_code;
    private String room_type_name;
    private Integer senior_min_age;
    private Boolean youth_count_as_adults;
    private Integer youth_max_age;
    private Integer youth_min_age;

    public RoomPK getRoomPK() {
        return roomPK;
    }

    public void setRoomPK(RoomPK roomPK) {
        this.roomPK = roomPK;
    }

    public Integer getAdult_max() {
        return adult_max;
    }

    public void setAdult_max(Integer adult_max) {
        this.adult_max = adult_max;
    }

    public Integer getAdult_min() {
        return adult_min;
    }

    public void setAdult_min(Integer adult_min) {
        this.adult_min = adult_min;
    }

    public Integer getAdult_with_child_max() {
        return adult_with_child_max;
    }

    public void setAdult_with_child_max(Integer adult_with_child_max) {
        this.adult_with_child_max = adult_with_child_max;
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

    public Boolean getAuto_upgrade_child_to_adult() {
        return auto_upgrade_child_to_adult;
    }

    public void setAuto_upgrade_child_to_adult(Boolean auto_upgrade_child_to_adult) {
        this.auto_upgrade_child_to_adult = auto_upgrade_child_to_adult;
    }

    public Boolean getChild_occ_only_allowed() {
        return child_occ_only_allowed;
    }

    public void setChild_occ_only_allowed(Boolean child_occ_only_allowed) {
        this.child_occ_only_allowed = child_occ_only_allowed;
    }

    public Integer getChildren_max() {
        return children_max;
    }

    public void setChildren_max(Integer children_max) {
        this.children_max = children_max;
    }

    public Integer getChildren_max_age() {
        return children_max_age;
    }

    public void setChildren_max_age(Integer children_max_age) {
        this.children_max_age = children_max_age;
    }

    public Integer getChildren_min() {
        return children_min;
    }

    public void setChildren_min(Integer children_min) {
        this.children_min = children_min;
    }

    public Integer getChildren_min_age() {
        return children_min_age;
    }

    public void setChildren_min_age(Integer children_min_age) {
        this.children_min_age = children_min_age;
    }

    public Integer getCots_max() {
        return cots_max;
    }

    public void setCots_max(Integer cots_max) {
        this.cots_max = cots_max;
    }

    public Boolean getExclude_adult_child_combinations() {
        return exclude_adult_child_combinations;
    }

    public void setExclude_adult_child_combinations(Boolean exclude_adult_child_combinations) {
        this.exclude_adult_child_combinations = exclude_adult_child_combinations;
    }

    public Boolean getExtra_beds_used() {
        return extra_beds_used;
    }

    public void setExtra_beds_used(Boolean extra_beds_used) {
        this.extra_beds_used = extra_beds_used;
    }

    public Boolean getExtra_rate_allocation() {
        return extra_rate_allocation;
    }

    public void setExtra_rate_allocation(Boolean extra_rate_allocation) {
        this.extra_rate_allocation = extra_rate_allocation;
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

    public Boolean getHas_occ_allocation_defined() {
        return has_occ_allocation_defined;
    }

    public void setHas_occ_allocation_defined(Boolean has_occ_allocation_defined) {
        this.has_occ_allocation_defined = has_occ_allocation_defined;
    }

    public Boolean getHas_split_inventory_defined() {
        return has_split_inventory_defined;
    }

    public void setHas_split_inventory_defined(Boolean has_split_inventory_defined) {
        this.has_split_inventory_defined = has_split_inventory_defined;
    }

    public Integer getInfant_max_age() {
        return infant_max_age;
    }

    public void setInfant_max_age(Integer infant_max_age) {
        this.infant_max_age = infant_max_age;
    }

    public Boolean getInfants_count_toward_occupancy() {
        return infants_count_toward_occupancy;
    }

    public void setInfants_count_toward_occupancy(Boolean infants_count_toward_occupancy) {
        this.infants_count_toward_occupancy = infants_count_toward_occupancy;
    }

    public Integer getMax_adults_extra_bed() {
        return max_adults_extra_bed;
    }

    public void setMax_adults_extra_bed(Integer max_adults_extra_bed) {
        this.max_adults_extra_bed = max_adults_extra_bed;
    }

    public Integer getMax_children_extra_bed() {
        return max_children_extra_bed;
    }

    public void setMax_children_extra_bed(Integer max_children_extra_bed) {
        this.max_children_extra_bed = max_children_extra_bed;
    }

    public Integer getMax_occupancy_before_extra_bed() {
        return max_occupancy_before_extra_bed;
    }

    public void setMax_occupancy_before_extra_bed(Integer max_occupancy_before_extra_bed) {
        this.max_occupancy_before_extra_bed = max_occupancy_before_extra_bed;
    }

    public Integer getOccupancy_max() {
        return occupancy_max;
    }

    public void setOccupancy_max(Integer occupancy_max) {
        this.occupancy_max = occupancy_max;
    }

    public Integer getOccupancy_min() {
        return occupancy_min;
    }

    public void setOccupancy_min(Integer occupancy_min) {
        this.occupancy_min = occupancy_min;
    }

    public Integer getOccupancy_standard() {
        return occupancy_standard;
    }

    public void setOccupancy_standard(Integer occupancy_standard) {
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

    public Integer getSenior_min_age() {
        return senior_min_age;
    }

    public void setSenior_min_age(Integer senior_min_age) {
        this.senior_min_age = senior_min_age;
    }

    public Boolean getYouth_count_as_adults() {
        return youth_count_as_adults;
    }

    public void setYouth_count_as_adults(Boolean youth_count_as_adults) {
        this.youth_count_as_adults = youth_count_as_adults;
    }

    public Integer getYouth_max_age() {
        return youth_max_age;
    }

    public void setYouth_max_age(Integer youth_max_age) {
        this.youth_max_age = youth_max_age;
    }

    public Integer getYouth_min_age() {
        return youth_min_age;
    }

    public void setYouth_min_age(Integer youth_min_age) {
        this.youth_min_age = youth_min_age;
    }

    @Override
    public String toString() {
        return "Room:{" +
                "roomPK=" + roomPK +
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
