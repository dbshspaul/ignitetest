package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.RateSearchPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.List;

@Table("rate_search")
public class RateSearch {
    @PrimaryKey
    private RateSearchPK rateSearchPK;
    private Float base_rate;
    private List<Float> bbu_rates;
    private List<Float> occupant_rates;
    private Float rate;

    public RateSearchPK getRateSearchPK() {
        return rateSearchPK;
    }

    public void setRateSearchPK(RateSearchPK rateSearchPK) {
        this.rateSearchPK = rateSearchPK;
    }

    public Float getBase_rate() {
        return base_rate;
    }

    public void setBase_rate(Float base_rate) {
        this.base_rate = base_rate;
    }

    public List<Float> getBbu_rates() {
        return bbu_rates;
    }

    public void setBbu_rates(List<Float> bbu_rates) {
        this.bbu_rates = bbu_rates;
    }

    public List<Float> getOccupant_rates() {
        return occupant_rates;
    }

    public void setOccupant_rates(List<Float> occupant_rates) {
        this.occupant_rates = occupant_rates;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
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
