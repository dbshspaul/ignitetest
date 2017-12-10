package com.jac.travels.model;

import com.jac.travels.idclass.RateSupplementSearchPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;

@Table("rate_supplement_search")
public class RateSupplementSearch {
    @PrimaryKey
    private RateSupplementSearchPK rateSupplementSearchPK;
    private Boolean close_out;
    private BigDecimal supplement;

    public RateSupplementSearchPK getRateSupplementSearchPK() {
        return rateSupplementSearchPK;
    }

    public void setRateSupplementSearchPK(RateSupplementSearchPK rateSupplementSearchPK) {
        this.rateSupplementSearchPK = rateSupplementSearchPK;
    }

    public Boolean getClose_out() {
        return close_out;
    }

    public void setClose_out(Boolean close_out) {
        this.close_out = close_out;
    }

    public BigDecimal getSupplement() {
        return supplement;
    }

    public void setSupplement(BigDecimal supplement) {
        this.supplement = supplement;
    }

    @Override
    public String toString() {
        return "RateSupplementSearch:{" +
                "rateSupplementSearchPK=" + rateSupplementSearchPK +
                ", close_out=" + close_out +
                ", supplement=" + supplement +
                '}';
    }
}
