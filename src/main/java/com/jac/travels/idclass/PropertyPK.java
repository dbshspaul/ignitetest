package com.jac.travels.idclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

/**
 * created by My System on 19-Dec-17
 **/
public class PropertyPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    @JsonIgnore
    private String tenant_id;
    @PrimaryKey
    private Integer property_id;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    @Override
    public String toString() {
        return "PropertyPK{" +
                "tenant_id='" + tenant_id + '\'' +
                ", property_id=" + property_id +
                '}';
    }
}
