package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.List;

@Table("rate_search")
public class RateSearch {
    @PrimaryKey
    private Integer rate_plan_id;
    @PrimaryKey
    private Integer board_basis_id;
    @PrimaryKey
    private Byte adults;
    @PrimaryKey
    private Byte infants;
    @PrimaryKey
    private String child_occupancy_key;
    @PrimaryKey
    private String youth_occupancy_key;
    @PrimaryKey
    private LocalDate stay_date;
    private Float base_rate;
    private List<Float> bbu_rates;
    private List<Float> occupant_rates;
    private Float rate;

}
