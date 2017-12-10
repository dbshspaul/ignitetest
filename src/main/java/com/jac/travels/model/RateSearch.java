package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.RateSearchPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;
import java.util.List;

@Table("rate_search")
public class RateSearch {
    @PrimaryKey
    private RateSearchPK rateSearchPK;
    private BigDecimal base_rate;
    private List<BigDecimal> bbu_rates;
    private List<BigDecimal> occupant_rates;
    private BigDecimal rate;

    public RateSearchPK getRateSearchPK() {
        return rateSearchPK;
    }

    public void setRateSearchPK(RateSearchPK rateSearchPK) {
        this.rateSearchPK = rateSearchPK;
    }

    public BigDecimal getBase_rate() {
        return base_rate;
    }

    public void setBase_rate(BigDecimal base_rate) {
        this.base_rate = base_rate;
    }

    public List<BigDecimal> getBbu_rates() {
        return bbu_rates;
    }

    public void setBbu_rates(List<BigDecimal> bbu_rates) {
        this.bbu_rates = bbu_rates;
    }

    public List<BigDecimal> getOccupant_rates() {
        return occupant_rates;
    }

    public void setOccupant_rates(List<BigDecimal> occupant_rates) {
        this.occupant_rates = occupant_rates;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "RateSearch:{" +
                "rateSearchPK=" + rateSearchPK +
                ", base_rate=" + base_rate +
                ", bbu_rates=" + bbu_rates +
                ", occupant_rates=" + occupant_rates +
                ", rate=" + rate +
                '}';
    }
}
