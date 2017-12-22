package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.RatePlanAllocationPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("rate_plan_allocation")
public class RatePlanAllocation {
    @PrimaryKey
    private RatePlanAllocationPK ratePlanAllocationPK;
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
    private Integer release;
    private Integer sold;
    private Integer split_release;
    private Integer split_release_allocation;
    private Integer split_release_sold;
    private Integer total_sold;
    private Date utc_release_date_time;
    private Date utc_split_release_date_time;

    public RatePlanAllocationPK getRatePlanAllocationPK() {
        return ratePlanAllocationPK;
    }

    public void setRatePlanAllocationPK(RatePlanAllocationPK ratePlanAllocationPK) {
        this.ratePlanAllocationPK = ratePlanAllocationPK;
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

    public Date getUtc_release_date_time() {
        return utc_release_date_time;
    }

    public void setUtc_release_date_time(Date utc_release_date_time) {
        this.utc_release_date_time = utc_release_date_time;
    }

    public Date getUtc_split_release_date_time() {
        return utc_split_release_date_time;
    }

    public void setUtc_split_release_date_time(Date utc_split_release_date_time) {
        this.utc_split_release_date_time = utc_split_release_date_time;
    }

    @Override
    public String toString() {
        return "RatePlanAllocation:{" +
                "ratePlanAllocationPK=" + ratePlanAllocationPK +
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
