package com.jac.travels.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;

@Table("property")
public class Property {
    @PrimaryKey
    private Integer property_id;
    private String tenant_id;
    private Integer cutoff_time;
    private String name;
    private BigDecimal star_rating;
    private Boolean status;
    private String timezone_id;

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

    public BigDecimal getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(BigDecimal star_rating) {
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

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "Property:{" +
                "property_id=" + property_id +
                ", tenant_id=" + tenant_id +
                ", cutoff_time=" + cutoff_time +
                ", name='" + name + '\'' +
                ", star_rating=" + star_rating +
                ", status=" + status +
                ", timezone_id='" + timezone_id + '\'' +
                '}';
    }
}
