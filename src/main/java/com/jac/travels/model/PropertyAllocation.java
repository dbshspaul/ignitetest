package com.jac.travels.model;

import com.jac.travels.idclass.PropertyAllocationPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("property_allocation")
public class PropertyAllocation {
    @PrimaryKey
    private PropertyAllocationPK propertyAllocationPK;
    private Boolean stop_sell;

    public PropertyAllocationPK getPropertyAllocationPK() {
        return propertyAllocationPK;
    }

    public void setPropertyAllocationPK(PropertyAllocationPK propertyAllocationPK) {
        this.propertyAllocationPK = propertyAllocationPK;
    }

    public Boolean getStop_sell() {
        return stop_sell;
    }

    public void setStop_sell(Boolean stop_sell) {
        this.stop_sell = stop_sell;
    }
}
