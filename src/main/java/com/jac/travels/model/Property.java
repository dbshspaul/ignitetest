package com.jac.travels.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("property")
public class Property {
    @PrimaryKey
    private	Integer	property_id;
    private	Integer	cutoff_time;
    private	String	name;
    private	Float	star_rating;
    private	Boolean	status;
    private	String	timezone_id;

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Integer getCutoff_time() {
        return cutoff_time;
    }

    public void setCutoff_time(Integer cutoff_time) {
        this.cutoff_time = cutoff_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Float star_rating) {
        this.star_rating = star_rating;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTimezone_id() {
        return timezone_id;
    }

    public void setTimezone_id(String timezone_id) {
        this.timezone_id = timezone_id;
    }
}