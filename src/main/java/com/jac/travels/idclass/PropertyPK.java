package com.jac.travels.idclass;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

/**
 * created by My System on 19-Dec-17
 **/
@PrimaryKeyClass
public class PropertyPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyPK)) return false;
        PropertyPK that = (PropertyPK) o;
        return Objects.equals(getTenant_id(), that.getTenant_id()) &&
                Objects.equals(getProperty_id(), that.getProperty_id());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTenant_id(), getProperty_id());
    }

    @Override
    public String toString() {
        return "PropertyPK{" +
                "tenant_id='" + tenant_id + '\'' +
                ", property_id=" + property_id +
                '}';
    }
}
