package com.jac.travels.model;

import com.jac.travels.idclass.RoomAllocationPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.time.ZonedDateTime;

@Table("room_allocation")
public class RoomAllocation {
    @PrimaryKey
    private RoomAllocationPK roomAllocationPK;
    private Integer allocation;
    private Boolean child_close_out;
    private Boolean child_youth_close_out;
    private Boolean close_out;
    private Integer extra_bed_allocation;
    private Integer extra_bed_sold;
    private Boolean is_free_sale;
    private Integer max_duration;
    private Integer min_allocation;
    private Integer min_duration;
    private Integer occupancy01_allocation;
    private Integer occupancy01_sold;
    private Integer occupancy02_allocation;
    private Integer occupancy02_sold;
    private Integer occupancy03_allocation;
    private Integer occupancy03_sold;
    private Integer occupancy04_allocation;
    private Integer occupancy04_sold;
    private Integer occupancy05_allocation;
    private Integer occupancy05_sold;
    private Integer occupancy06_allocation;
    private Integer occupancy06_sold;
    private Integer occupancy07_allocation;
    private Integer occupancy07_sold;
    private Integer occupancy08_allocation;
    private Integer occupancy08_sold;
    private Integer occupancy09_allocation;
    private Integer occupancy09_sold;
    private Integer occupancy10_allocation;
    private Integer occupancy10_sold;
    private Integer occupancy11_allocation;
    private Integer occupancy11_sold;
    private Integer occupancy12_allocation;
    private Integer occupancy12_sold;
    private Integer occupancy13_allocation;
    private Integer occupancy13_sold;
    private Integer occupancy14_allocation;
    private Integer occupancy14_sold;
    private Integer occupancy15_allocation;
    private Integer occupancy15_sold;
    private Integer occupancy16_allocation;
    private Integer occupancy16_sold;
    private Integer occupancy17_allocation;
    private Integer occupancy17_sold;
    private Integer occupancy18_allocation;
    private Integer occupancy18_sold;
    private Integer occupancy19_allocation;
    private Integer occupancy19_sold;
    private Integer occupancy20_allocation;
    private Integer occupancy20_sold;
    private Integer occupancy21_allocation;
    private Integer occupancy21_sold;
    private Integer occupancy22_allocation;
    private Integer occupancy22_sold;
    private Integer occupancy23_allocation;
    private Integer occupancy23_sold;
    private Integer occupancy24_allocation;
    private Integer occupancy24_sold;
    private Integer occupancy25_allocation;
    private Integer occupancy25_sold;
    private Integer occupancy26_allocation;
    private Integer occupancy26_sold;
    private Integer occupancy27_allocation;
    private Integer occupancy27_sold;
    private Integer occupancy28_allocation;
    private Integer occupancy28_sold;
    private Integer occupancy29_allocation;
    private Integer occupancy29_sold;
    private Integer occupancy30_allocation;
    private Integer occupancy30_sold;
    private Integer occupancy31_allocation;
    private Integer occupancy31_sold;
    private Integer occupancy32_allocation;
    private Integer occupancy32_sold;
    private Integer occupancy33_allocation;
    private Integer occupancy33_sold;
    private Integer occupancy34_allocation;
    private Integer occupancy34_sold;
    private Integer occupancy35_allocation;
    private Integer occupancy35_sold;
    private Integer occupancy36_allocation;
    private Integer occupancy36_sold;
    private Integer occupancy37_allocation;
    private Integer occupancy37_sold;
    private Integer occupancy38_allocation;
    private Integer occupancy38_sold;
    private Integer occupancy39_allocation;
    private Integer occupancy39_sold;
    private Integer occupancy40_allocation;
    private Integer occupancy40_sold;
    private Integer occupancy41_allocation;
    private Integer occupancy41_sold;
    private Integer occupancy42_allocation;
    private Integer occupancy42_sold;
    private Integer occupancy43_allocation;
    private Integer occupancy43_sold;
    private Integer occupancy44_allocation;
    private Integer occupancy44_sold;
    private Integer occupancy45_allocation;
    private Integer occupancy45_sold;
    private Integer occupancy46_allocation;
    private Integer occupancy46_sold;
    private Integer occupancy47_allocation;
    private Integer occupancy47_sold;
    private Integer occupancy48_allocation;
    private Integer occupancy48_sold;
    private Integer occupancy49_allocation;
    private Integer occupancy49_sold;
    private Integer occupancy50_allocation;
    private Integer occupancy50_sold;
    private Integer release;
    private Integer sold;
    private Integer split_release;
    private Integer split_release_allocation;
    private Integer split_release_sold;
    private Integer total_sold;
    private ZonedDateTime utc_release_date_time;
    private ZonedDateTime utc_split_release_date_time;

    public RoomAllocationPK getRoomAllocationPK() {
        return roomAllocationPK;
    }

    public void setRoomAllocationPK(RoomAllocationPK roomAllocationPK) {
        this.roomAllocationPK = roomAllocationPK;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }

    public Boolean getChild_close_out() {
        return child_close_out;
    }

    public void setChild_close_out(Boolean child_close_out) {
        this.child_close_out = child_close_out;
    }

    public Boolean getChild_youth_close_out() {
        return child_youth_close_out;
    }

    public void setChild_youth_close_out(Boolean child_youth_close_out) {
        this.child_youth_close_out = child_youth_close_out;
    }

    public Boolean getClose_out() {
        return close_out;
    }

    public void setClose_out(Boolean close_out) {
        this.close_out = close_out;
    }

    public Integer getExtra_bed_allocation() {
        return extra_bed_allocation;
    }

    public void setExtra_bed_allocation(Integer extra_bed_allocation) {
        this.extra_bed_allocation = extra_bed_allocation;
    }

    public Integer getExtra_bed_sold() {
        return extra_bed_sold;
    }

    public void setExtra_bed_sold(Integer extra_bed_sold) {
        this.extra_bed_sold = extra_bed_sold;
    }

    public Boolean getIs_free_sale() {
        return is_free_sale;
    }

    public void setIs_free_sale(Boolean is_free_sale) {
        this.is_free_sale = is_free_sale;
    }

    public Integer getMax_duration() {
        return max_duration;
    }

    public void setMax_duration(Integer max_duration) {
        this.max_duration = max_duration;
    }

    public Integer getMin_allocation() {
        return min_allocation;
    }

    public void setMin_allocation(Integer min_allocation) {
        this.min_allocation = min_allocation;
    }

    public Integer getMin_duration() {
        return min_duration;
    }

    public void setMin_duration(Integer min_duration) {
        this.min_duration = min_duration;
    }

    public Integer getOccupancy01_allocation() {
        return occupancy01_allocation;
    }

    public void setOccupancy01_allocation(Integer occupancy01_allocation) {
        this.occupancy01_allocation = occupancy01_allocation;
    }

    public Integer getOccupancy01_sold() {
        return occupancy01_sold;
    }

    public void setOccupancy01_sold(Integer occupancy01_sold) {
        this.occupancy01_sold = occupancy01_sold;
    }

    public Integer getOccupancy02_allocation() {
        return occupancy02_allocation;
    }

    public void setOccupancy02_allocation(Integer occupancy02_allocation) {
        this.occupancy02_allocation = occupancy02_allocation;
    }

    public Integer getOccupancy02_sold() {
        return occupancy02_sold;
    }

    public void setOccupancy02_sold(Integer occupancy02_sold) {
        this.occupancy02_sold = occupancy02_sold;
    }

    public Integer getOccupancy03_allocation() {
        return occupancy03_allocation;
    }

    public void setOccupancy03_allocation(Integer occupancy03_allocation) {
        this.occupancy03_allocation = occupancy03_allocation;
    }

    public Integer getOccupancy03_sold() {
        return occupancy03_sold;
    }

    public void setOccupancy03_sold(Integer occupancy03_sold) {
        this.occupancy03_sold = occupancy03_sold;
    }

    public Integer getOccupancy04_allocation() {
        return occupancy04_allocation;
    }

    public void setOccupancy04_allocation(Integer occupancy04_allocation) {
        this.occupancy04_allocation = occupancy04_allocation;
    }

    public Integer getOccupancy04_sold() {
        return occupancy04_sold;
    }

    public void setOccupancy04_sold(Integer occupancy04_sold) {
        this.occupancy04_sold = occupancy04_sold;
    }

    public Integer getOccupancy05_allocation() {
        return occupancy05_allocation;
    }

    public void setOccupancy05_allocation(Integer occupancy05_allocation) {
        this.occupancy05_allocation = occupancy05_allocation;
    }

    public Integer getOccupancy05_sold() {
        return occupancy05_sold;
    }

    public void setOccupancy05_sold(Integer occupancy05_sold) {
        this.occupancy05_sold = occupancy05_sold;
    }

    public Integer getOccupancy06_allocation() {
        return occupancy06_allocation;
    }

    public void setOccupancy06_allocation(Integer occupancy06_allocation) {
        this.occupancy06_allocation = occupancy06_allocation;
    }

    public Integer getOccupancy06_sold() {
        return occupancy06_sold;
    }

    public void setOccupancy06_sold(Integer occupancy06_sold) {
        this.occupancy06_sold = occupancy06_sold;
    }

    public Integer getOccupancy07_allocation() {
        return occupancy07_allocation;
    }

    public void setOccupancy07_allocation(Integer occupancy07_allocation) {
        this.occupancy07_allocation = occupancy07_allocation;
    }

    public Integer getOccupancy07_sold() {
        return occupancy07_sold;
    }

    public void setOccupancy07_sold(Integer occupancy07_sold) {
        this.occupancy07_sold = occupancy07_sold;
    }

    public Integer getOccupancy08_allocation() {
        return occupancy08_allocation;
    }

    public void setOccupancy08_allocation(Integer occupancy08_allocation) {
        this.occupancy08_allocation = occupancy08_allocation;
    }

    public Integer getOccupancy08_sold() {
        return occupancy08_sold;
    }

    public void setOccupancy08_sold(Integer occupancy08_sold) {
        this.occupancy08_sold = occupancy08_sold;
    }

    public Integer getOccupancy09_allocation() {
        return occupancy09_allocation;
    }

    public void setOccupancy09_allocation(Integer occupancy09_allocation) {
        this.occupancy09_allocation = occupancy09_allocation;
    }

    public Integer getOccupancy09_sold() {
        return occupancy09_sold;
    }

    public void setOccupancy09_sold(Integer occupancy09_sold) {
        this.occupancy09_sold = occupancy09_sold;
    }

    public Integer getOccupancy10_allocation() {
        return occupancy10_allocation;
    }

    public void setOccupancy10_allocation(Integer occupancy10_allocation) {
        this.occupancy10_allocation = occupancy10_allocation;
    }

    public Integer getOccupancy10_sold() {
        return occupancy10_sold;
    }

    public void setOccupancy10_sold(Integer occupancy10_sold) {
        this.occupancy10_sold = occupancy10_sold;
    }

    public Integer getOccupancy11_allocation() {
        return occupancy11_allocation;
    }

    public void setOccupancy11_allocation(Integer occupancy11_allocation) {
        this.occupancy11_allocation = occupancy11_allocation;
    }

    public Integer getOccupancy11_sold() {
        return occupancy11_sold;
    }

    public void setOccupancy11_sold(Integer occupancy11_sold) {
        this.occupancy11_sold = occupancy11_sold;
    }

    public Integer getOccupancy12_allocation() {
        return occupancy12_allocation;
    }

    public void setOccupancy12_allocation(Integer occupancy12_allocation) {
        this.occupancy12_allocation = occupancy12_allocation;
    }

    public Integer getOccupancy12_sold() {
        return occupancy12_sold;
    }

    public void setOccupancy12_sold(Integer occupancy12_sold) {
        this.occupancy12_sold = occupancy12_sold;
    }

    public Integer getOccupancy13_allocation() {
        return occupancy13_allocation;
    }

    public void setOccupancy13_allocation(Integer occupancy13_allocation) {
        this.occupancy13_allocation = occupancy13_allocation;
    }

    public Integer getOccupancy13_sold() {
        return occupancy13_sold;
    }

    public void setOccupancy13_sold(Integer occupancy13_sold) {
        this.occupancy13_sold = occupancy13_sold;
    }

    public Integer getOccupancy14_allocation() {
        return occupancy14_allocation;
    }

    public void setOccupancy14_allocation(Integer occupancy14_allocation) {
        this.occupancy14_allocation = occupancy14_allocation;
    }

    public Integer getOccupancy14_sold() {
        return occupancy14_sold;
    }

    public void setOccupancy14_sold(Integer occupancy14_sold) {
        this.occupancy14_sold = occupancy14_sold;
    }

    public Integer getOccupancy15_allocation() {
        return occupancy15_allocation;
    }

    public void setOccupancy15_allocation(Integer occupancy15_allocation) {
        this.occupancy15_allocation = occupancy15_allocation;
    }

    public Integer getOccupancy15_sold() {
        return occupancy15_sold;
    }

    public void setOccupancy15_sold(Integer occupancy15_sold) {
        this.occupancy15_sold = occupancy15_sold;
    }

    public Integer getOccupancy16_allocation() {
        return occupancy16_allocation;
    }

    public void setOccupancy16_allocation(Integer occupancy16_allocation) {
        this.occupancy16_allocation = occupancy16_allocation;
    }

    public Integer getOccupancy16_sold() {
        return occupancy16_sold;
    }

    public void setOccupancy16_sold(Integer occupancy16_sold) {
        this.occupancy16_sold = occupancy16_sold;
    }

    public Integer getOccupancy17_allocation() {
        return occupancy17_allocation;
    }

    public void setOccupancy17_allocation(Integer occupancy17_allocation) {
        this.occupancy17_allocation = occupancy17_allocation;
    }

    public Integer getOccupancy17_sold() {
        return occupancy17_sold;
    }

    public void setOccupancy17_sold(Integer occupancy17_sold) {
        this.occupancy17_sold = occupancy17_sold;
    }

    public Integer getOccupancy18_allocation() {
        return occupancy18_allocation;
    }

    public void setOccupancy18_allocation(Integer occupancy18_allocation) {
        this.occupancy18_allocation = occupancy18_allocation;
    }

    public Integer getOccupancy18_sold() {
        return occupancy18_sold;
    }

    public void setOccupancy18_sold(Integer occupancy18_sold) {
        this.occupancy18_sold = occupancy18_sold;
    }

    public Integer getOccupancy19_allocation() {
        return occupancy19_allocation;
    }

    public void setOccupancy19_allocation(Integer occupancy19_allocation) {
        this.occupancy19_allocation = occupancy19_allocation;
    }

    public Integer getOccupancy19_sold() {
        return occupancy19_sold;
    }

    public void setOccupancy19_sold(Integer occupancy19_sold) {
        this.occupancy19_sold = occupancy19_sold;
    }

    public Integer getOccupancy20_allocation() {
        return occupancy20_allocation;
    }

    public void setOccupancy20_allocation(Integer occupancy20_allocation) {
        this.occupancy20_allocation = occupancy20_allocation;
    }

    public Integer getOccupancy20_sold() {
        return occupancy20_sold;
    }

    public void setOccupancy20_sold(Integer occupancy20_sold) {
        this.occupancy20_sold = occupancy20_sold;
    }

    public Integer getOccupancy21_allocation() {
        return occupancy21_allocation;
    }

    public void setOccupancy21_allocation(Integer occupancy21_allocation) {
        this.occupancy21_allocation = occupancy21_allocation;
    }

    public Integer getOccupancy21_sold() {
        return occupancy21_sold;
    }

    public void setOccupancy21_sold(Integer occupancy21_sold) {
        this.occupancy21_sold = occupancy21_sold;
    }

    public Integer getOccupancy22_allocation() {
        return occupancy22_allocation;
    }

    public void setOccupancy22_allocation(Integer occupancy22_allocation) {
        this.occupancy22_allocation = occupancy22_allocation;
    }

    public Integer getOccupancy22_sold() {
        return occupancy22_sold;
    }

    public void setOccupancy22_sold(Integer occupancy22_sold) {
        this.occupancy22_sold = occupancy22_sold;
    }

    public Integer getOccupancy23_allocation() {
        return occupancy23_allocation;
    }

    public void setOccupancy23_allocation(Integer occupancy23_allocation) {
        this.occupancy23_allocation = occupancy23_allocation;
    }

    public Integer getOccupancy23_sold() {
        return occupancy23_sold;
    }

    public void setOccupancy23_sold(Integer occupancy23_sold) {
        this.occupancy23_sold = occupancy23_sold;
    }

    public Integer getOccupancy24_allocation() {
        return occupancy24_allocation;
    }

    public void setOccupancy24_allocation(Integer occupancy24_allocation) {
        this.occupancy24_allocation = occupancy24_allocation;
    }

    public Integer getOccupancy24_sold() {
        return occupancy24_sold;
    }

    public void setOccupancy24_sold(Integer occupancy24_sold) {
        this.occupancy24_sold = occupancy24_sold;
    }

    public Integer getOccupancy25_allocation() {
        return occupancy25_allocation;
    }

    public void setOccupancy25_allocation(Integer occupancy25_allocation) {
        this.occupancy25_allocation = occupancy25_allocation;
    }

    public Integer getOccupancy25_sold() {
        return occupancy25_sold;
    }

    public void setOccupancy25_sold(Integer occupancy25_sold) {
        this.occupancy25_sold = occupancy25_sold;
    }

    public Integer getOccupancy26_allocation() {
        return occupancy26_allocation;
    }

    public void setOccupancy26_allocation(Integer occupancy26_allocation) {
        this.occupancy26_allocation = occupancy26_allocation;
    }

    public Integer getOccupancy26_sold() {
        return occupancy26_sold;
    }

    public void setOccupancy26_sold(Integer occupancy26_sold) {
        this.occupancy26_sold = occupancy26_sold;
    }

    public Integer getOccupancy27_allocation() {
        return occupancy27_allocation;
    }

    public void setOccupancy27_allocation(Integer occupancy27_allocation) {
        this.occupancy27_allocation = occupancy27_allocation;
    }

    public Integer getOccupancy27_sold() {
        return occupancy27_sold;
    }

    public void setOccupancy27_sold(Integer occupancy27_sold) {
        this.occupancy27_sold = occupancy27_sold;
    }

    public Integer getOccupancy28_allocation() {
        return occupancy28_allocation;
    }

    public void setOccupancy28_allocation(Integer occupancy28_allocation) {
        this.occupancy28_allocation = occupancy28_allocation;
    }

    public Integer getOccupancy28_sold() {
        return occupancy28_sold;
    }

    public void setOccupancy28_sold(Integer occupancy28_sold) {
        this.occupancy28_sold = occupancy28_sold;
    }

    public Integer getOccupancy29_allocation() {
        return occupancy29_allocation;
    }

    public void setOccupancy29_allocation(Integer occupancy29_allocation) {
        this.occupancy29_allocation = occupancy29_allocation;
    }

    public Integer getOccupancy29_sold() {
        return occupancy29_sold;
    }

    public void setOccupancy29_sold(Integer occupancy29_sold) {
        this.occupancy29_sold = occupancy29_sold;
    }

    public Integer getOccupancy30_allocation() {
        return occupancy30_allocation;
    }

    public void setOccupancy30_allocation(Integer occupancy30_allocation) {
        this.occupancy30_allocation = occupancy30_allocation;
    }

    public Integer getOccupancy30_sold() {
        return occupancy30_sold;
    }

    public void setOccupancy30_sold(Integer occupancy30_sold) {
        this.occupancy30_sold = occupancy30_sold;
    }

    public Integer getOccupancy31_allocation() {
        return occupancy31_allocation;
    }

    public void setOccupancy31_allocation(Integer occupancy31_allocation) {
        this.occupancy31_allocation = occupancy31_allocation;
    }

    public Integer getOccupancy31_sold() {
        return occupancy31_sold;
    }

    public void setOccupancy31_sold(Integer occupancy31_sold) {
        this.occupancy31_sold = occupancy31_sold;
    }

    public Integer getOccupancy32_allocation() {
        return occupancy32_allocation;
    }

    public void setOccupancy32_allocation(Integer occupancy32_allocation) {
        this.occupancy32_allocation = occupancy32_allocation;
    }

    public Integer getOccupancy32_sold() {
        return occupancy32_sold;
    }

    public void setOccupancy32_sold(Integer occupancy32_sold) {
        this.occupancy32_sold = occupancy32_sold;
    }

    public Integer getOccupancy33_allocation() {
        return occupancy33_allocation;
    }

    public void setOccupancy33_allocation(Integer occupancy33_allocation) {
        this.occupancy33_allocation = occupancy33_allocation;
    }

    public Integer getOccupancy33_sold() {
        return occupancy33_sold;
    }

    public void setOccupancy33_sold(Integer occupancy33_sold) {
        this.occupancy33_sold = occupancy33_sold;
    }

    public Integer getOccupancy34_allocation() {
        return occupancy34_allocation;
    }

    public void setOccupancy34_allocation(Integer occupancy34_allocation) {
        this.occupancy34_allocation = occupancy34_allocation;
    }

    public Integer getOccupancy34_sold() {
        return occupancy34_sold;
    }

    public void setOccupancy34_sold(Integer occupancy34_sold) {
        this.occupancy34_sold = occupancy34_sold;
    }

    public Integer getOccupancy35_allocation() {
        return occupancy35_allocation;
    }

    public void setOccupancy35_allocation(Integer occupancy35_allocation) {
        this.occupancy35_allocation = occupancy35_allocation;
    }

    public Integer getOccupancy35_sold() {
        return occupancy35_sold;
    }

    public void setOccupancy35_sold(Integer occupancy35_sold) {
        this.occupancy35_sold = occupancy35_sold;
    }

    public Integer getOccupancy36_allocation() {
        return occupancy36_allocation;
    }

    public void setOccupancy36_allocation(Integer occupancy36_allocation) {
        this.occupancy36_allocation = occupancy36_allocation;
    }

    public Integer getOccupancy36_sold() {
        return occupancy36_sold;
    }

    public void setOccupancy36_sold(Integer occupancy36_sold) {
        this.occupancy36_sold = occupancy36_sold;
    }

    public Integer getOccupancy37_allocation() {
        return occupancy37_allocation;
    }

    public void setOccupancy37_allocation(Integer occupancy37_allocation) {
        this.occupancy37_allocation = occupancy37_allocation;
    }

    public Integer getOccupancy37_sold() {
        return occupancy37_sold;
    }

    public void setOccupancy37_sold(Integer occupancy37_sold) {
        this.occupancy37_sold = occupancy37_sold;
    }

    public Integer getOccupancy38_allocation() {
        return occupancy38_allocation;
    }

    public void setOccupancy38_allocation(Integer occupancy38_allocation) {
        this.occupancy38_allocation = occupancy38_allocation;
    }

    public Integer getOccupancy38_sold() {
        return occupancy38_sold;
    }

    public void setOccupancy38_sold(Integer occupancy38_sold) {
        this.occupancy38_sold = occupancy38_sold;
    }

    public Integer getOccupancy39_allocation() {
        return occupancy39_allocation;
    }

    public void setOccupancy39_allocation(Integer occupancy39_allocation) {
        this.occupancy39_allocation = occupancy39_allocation;
    }

    public Integer getOccupancy39_sold() {
        return occupancy39_sold;
    }

    public void setOccupancy39_sold(Integer occupancy39_sold) {
        this.occupancy39_sold = occupancy39_sold;
    }

    public Integer getOccupancy40_allocation() {
        return occupancy40_allocation;
    }

    public void setOccupancy40_allocation(Integer occupancy40_allocation) {
        this.occupancy40_allocation = occupancy40_allocation;
    }

    public Integer getOccupancy40_sold() {
        return occupancy40_sold;
    }

    public void setOccupancy40_sold(Integer occupancy40_sold) {
        this.occupancy40_sold = occupancy40_sold;
    }

    public Integer getOccupancy41_allocation() {
        return occupancy41_allocation;
    }

    public void setOccupancy41_allocation(Integer occupancy41_allocation) {
        this.occupancy41_allocation = occupancy41_allocation;
    }

    public Integer getOccupancy41_sold() {
        return occupancy41_sold;
    }

    public void setOccupancy41_sold(Integer occupancy41_sold) {
        this.occupancy41_sold = occupancy41_sold;
    }

    public Integer getOccupancy42_allocation() {
        return occupancy42_allocation;
    }

    public void setOccupancy42_allocation(Integer occupancy42_allocation) {
        this.occupancy42_allocation = occupancy42_allocation;
    }

    public Integer getOccupancy42_sold() {
        return occupancy42_sold;
    }

    public void setOccupancy42_sold(Integer occupancy42_sold) {
        this.occupancy42_sold = occupancy42_sold;
    }

    public Integer getOccupancy43_allocation() {
        return occupancy43_allocation;
    }

    public void setOccupancy43_allocation(Integer occupancy43_allocation) {
        this.occupancy43_allocation = occupancy43_allocation;
    }

    public Integer getOccupancy43_sold() {
        return occupancy43_sold;
    }

    public void setOccupancy43_sold(Integer occupancy43_sold) {
        this.occupancy43_sold = occupancy43_sold;
    }

    public Integer getOccupancy44_allocation() {
        return occupancy44_allocation;
    }

    public void setOccupancy44_allocation(Integer occupancy44_allocation) {
        this.occupancy44_allocation = occupancy44_allocation;
    }

    public Integer getOccupancy44_sold() {
        return occupancy44_sold;
    }

    public void setOccupancy44_sold(Integer occupancy44_sold) {
        this.occupancy44_sold = occupancy44_sold;
    }

    public Integer getOccupancy45_allocation() {
        return occupancy45_allocation;
    }

    public void setOccupancy45_allocation(Integer occupancy45_allocation) {
        this.occupancy45_allocation = occupancy45_allocation;
    }

    public Integer getOccupancy45_sold() {
        return occupancy45_sold;
    }

    public void setOccupancy45_sold(Integer occupancy45_sold) {
        this.occupancy45_sold = occupancy45_sold;
    }

    public Integer getOccupancy46_allocation() {
        return occupancy46_allocation;
    }

    public void setOccupancy46_allocation(Integer occupancy46_allocation) {
        this.occupancy46_allocation = occupancy46_allocation;
    }

    public Integer getOccupancy46_sold() {
        return occupancy46_sold;
    }

    public void setOccupancy46_sold(Integer occupancy46_sold) {
        this.occupancy46_sold = occupancy46_sold;
    }

    public Integer getOccupancy47_allocation() {
        return occupancy47_allocation;
    }

    public void setOccupancy47_allocation(Integer occupancy47_allocation) {
        this.occupancy47_allocation = occupancy47_allocation;
    }

    public Integer getOccupancy47_sold() {
        return occupancy47_sold;
    }

    public void setOccupancy47_sold(Integer occupancy47_sold) {
        this.occupancy47_sold = occupancy47_sold;
    }

    public Integer getOccupancy48_allocation() {
        return occupancy48_allocation;
    }

    public void setOccupancy48_allocation(Integer occupancy48_allocation) {
        this.occupancy48_allocation = occupancy48_allocation;
    }

    public Integer getOccupancy48_sold() {
        return occupancy48_sold;
    }

    public void setOccupancy48_sold(Integer occupancy48_sold) {
        this.occupancy48_sold = occupancy48_sold;
    }

    public Integer getOccupancy49_allocation() {
        return occupancy49_allocation;
    }

    public void setOccupancy49_allocation(Integer occupancy49_allocation) {
        this.occupancy49_allocation = occupancy49_allocation;
    }

    public Integer getOccupancy49_sold() {
        return occupancy49_sold;
    }

    public void setOccupancy49_sold(Integer occupancy49_sold) {
        this.occupancy49_sold = occupancy49_sold;
    }

    public Integer getOccupancy50_allocation() {
        return occupancy50_allocation;
    }

    public void setOccupancy50_allocation(Integer occupancy50_allocation) {
        this.occupancy50_allocation = occupancy50_allocation;
    }

    public Integer getOccupancy50_sold() {
        return occupancy50_sold;
    }

    public void setOccupancy50_sold(Integer occupancy50_sold) {
        this.occupancy50_sold = occupancy50_sold;
    }

    public Integer getRelease() {
        return release;
    }

    public void setRelease(Integer release) {
        this.release = release;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getSplit_release() {
        return split_release;
    }

    public void setSplit_release(Integer split_release) {
        this.split_release = split_release;
    }

    public Integer getSplit_release_allocation() {
        return split_release_allocation;
    }

    public void setSplit_release_allocation(Integer split_release_allocation) {
        this.split_release_allocation = split_release_allocation;
    }

    public Integer getSplit_release_sold() {
        return split_release_sold;
    }

    public void setSplit_release_sold(Integer split_release_sold) {
        this.split_release_sold = split_release_sold;
    }

    public Integer getTotal_sold() {
        return total_sold;
    }

    public void setTotal_sold(Integer total_sold) {
        this.total_sold = total_sold;
    }

    public ZonedDateTime getUtc_release_date_time() {
        return utc_release_date_time;
    }

    public void setUtc_release_date_time(ZonedDateTime utc_release_date_time) {
        this.utc_release_date_time = utc_release_date_time;
    }

    public ZonedDateTime getUtc_split_release_date_time() {
        return utc_split_release_date_time;
    }

    public void setUtc_split_release_date_time(ZonedDateTime utc_split_release_date_time) {
        this.utc_split_release_date_time = utc_split_release_date_time;
    }

    @Override
    public String toString() {
        return "RoomAllocation:{" +
                "roomAllocationPK=" + roomAllocationPK +
                ", allocation=" + allocation +
                ", child_close_out=" + child_close_out +
                ", child_youth_close_out=" + child_youth_close_out +
                ", close_out=" + close_out +
                ", extra_bed_allocation=" + extra_bed_allocation +
                ", extra_bed_sold=" + extra_bed_sold +
                ", is_free_sale=" + is_free_sale +
                ", max_duration=" + max_duration +
                ", min_allocation=" + min_allocation +
                ", min_duration=" + min_duration +
                ", occupancy01_allocation=" + occupancy01_allocation +
                ", occupancy01_sold=" + occupancy01_sold +
                ", occupancy02_allocation=" + occupancy02_allocation +
                ", occupancy02_sold=" + occupancy02_sold +
                ", occupancy03_allocation=" + occupancy03_allocation +
                ", occupancy03_sold=" + occupancy03_sold +
                ", occupancy04_allocation=" + occupancy04_allocation +
                ", occupancy04_sold=" + occupancy04_sold +
                ", occupancy05_allocation=" + occupancy05_allocation +
                ", occupancy05_sold=" + occupancy05_sold +
                ", occupancy06_allocation=" + occupancy06_allocation +
                ", occupancy06_sold=" + occupancy06_sold +
                ", occupancy07_allocation=" + occupancy07_allocation +
                ", occupancy07_sold=" + occupancy07_sold +
                ", occupancy08_allocation=" + occupancy08_allocation +
                ", occupancy08_sold=" + occupancy08_sold +
                ", occupancy09_allocation=" + occupancy09_allocation +
                ", occupancy09_sold=" + occupancy09_sold +
                ", occupancy10_allocation=" + occupancy10_allocation +
                ", occupancy10_sold=" + occupancy10_sold +
                ", occupancy11_allocation=" + occupancy11_allocation +
                ", occupancy11_sold=" + occupancy11_sold +
                ", occupancy12_allocation=" + occupancy12_allocation +
                ", occupancy12_sold=" + occupancy12_sold +
                ", occupancy13_allocation=" + occupancy13_allocation +
                ", occupancy13_sold=" + occupancy13_sold +
                ", occupancy14_allocation=" + occupancy14_allocation +
                ", occupancy14_sold=" + occupancy14_sold +
                ", occupancy15_allocation=" + occupancy15_allocation +
                ", occupancy15_sold=" + occupancy15_sold +
                ", occupancy16_allocation=" + occupancy16_allocation +
                ", occupancy16_sold=" + occupancy16_sold +
                ", occupancy17_allocation=" + occupancy17_allocation +
                ", occupancy17_sold=" + occupancy17_sold +
                ", occupancy18_allocation=" + occupancy18_allocation +
                ", occupancy18_sold=" + occupancy18_sold +
                ", occupancy19_allocation=" + occupancy19_allocation +
                ", occupancy19_sold=" + occupancy19_sold +
                ", occupancy20_allocation=" + occupancy20_allocation +
                ", occupancy20_sold=" + occupancy20_sold +
                ", occupancy21_allocation=" + occupancy21_allocation +
                ", occupancy21_sold=" + occupancy21_sold +
                ", occupancy22_allocation=" + occupancy22_allocation +
                ", occupancy22_sold=" + occupancy22_sold +
                ", occupancy23_allocation=" + occupancy23_allocation +
                ", occupancy23_sold=" + occupancy23_sold +
                ", occupancy24_allocation=" + occupancy24_allocation +
                ", occupancy24_sold=" + occupancy24_sold +
                ", occupancy25_allocation=" + occupancy25_allocation +
                ", occupancy25_sold=" + occupancy25_sold +
                ", occupancy26_allocation=" + occupancy26_allocation +
                ", occupancy26_sold=" + occupancy26_sold +
                ", occupancy27_allocation=" + occupancy27_allocation +
                ", occupancy27_sold=" + occupancy27_sold +
                ", occupancy28_allocation=" + occupancy28_allocation +
                ", occupancy28_sold=" + occupancy28_sold +
                ", occupancy29_allocation=" + occupancy29_allocation +
                ", occupancy29_sold=" + occupancy29_sold +
                ", occupancy30_allocation=" + occupancy30_allocation +
                ", occupancy30_sold=" + occupancy30_sold +
                ", occupancy31_allocation=" + occupancy31_allocation +
                ", occupancy31_sold=" + occupancy31_sold +
                ", occupancy32_allocation=" + occupancy32_allocation +
                ", occupancy32_sold=" + occupancy32_sold +
                ", occupancy33_allocation=" + occupancy33_allocation +
                ", occupancy33_sold=" + occupancy33_sold +
                ", occupancy34_allocation=" + occupancy34_allocation +
                ", occupancy34_sold=" + occupancy34_sold +
                ", occupancy35_allocation=" + occupancy35_allocation +
                ", occupancy35_sold=" + occupancy35_sold +
                ", occupancy36_allocation=" + occupancy36_allocation +
                ", occupancy36_sold=" + occupancy36_sold +
                ", occupancy37_allocation=" + occupancy37_allocation +
                ", occupancy37_sold=" + occupancy37_sold +
                ", occupancy38_allocation=" + occupancy38_allocation +
                ", occupancy38_sold=" + occupancy38_sold +
                ", occupancy39_allocation=" + occupancy39_allocation +
                ", occupancy39_sold=" + occupancy39_sold +
                ", occupancy40_allocation=" + occupancy40_allocation +
                ", occupancy40_sold=" + occupancy40_sold +
                ", occupancy41_allocation=" + occupancy41_allocation +
                ", occupancy41_sold=" + occupancy41_sold +
                ", occupancy42_allocation=" + occupancy42_allocation +
                ", occupancy42_sold=" + occupancy42_sold +
                ", occupancy43_allocation=" + occupancy43_allocation +
                ", occupancy43_sold=" + occupancy43_sold +
                ", occupancy44_allocation=" + occupancy44_allocation +
                ", occupancy44_sold=" + occupancy44_sold +
                ", occupancy45_allocation=" + occupancy45_allocation +
                ", occupancy45_sold=" + occupancy45_sold +
                ", occupancy46_allocation=" + occupancy46_allocation +
                ", occupancy46_sold=" + occupancy46_sold +
                ", occupancy47_allocation=" + occupancy47_allocation +
                ", occupancy47_sold=" + occupancy47_sold +
                ", occupancy48_allocation=" + occupancy48_allocation +
                ", occupancy48_sold=" + occupancy48_sold +
                ", occupancy49_allocation=" + occupancy49_allocation +
                ", occupancy49_sold=" + occupancy49_sold +
                ", occupancy50_allocation=" + occupancy50_allocation +
                ", occupancy50_sold=" + occupancy50_sold +
                ", release=" + release +
                ", sold=" + sold +
                ", split_release=" + split_release +
                ", split_release_allocation=" + split_release_allocation +
                ", split_release_sold=" + split_release_sold +
                ", total_sold=" + total_sold +
                ", utc_release_date_time=" + utc_release_date_time +
                ", utc_split_release_date_time=" + utc_split_release_date_time +
                '}';
    }
}
