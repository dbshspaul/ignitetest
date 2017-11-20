package com.jac.travels.spring.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.jac.travels.model.Rate;
import com.jac.travels.spring.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateRepository rateRepository;
    com.jac.travels.utility.QueryBuilder builder = new com.jac.travels.utility.QueryBuilder();
    @Override
    public List<Rate> getAll() {
        return (List<Rate>) rateRepository.findAll();
    }

    @Override
    public void updateRateByRatePlanId(Rate rate, Integer ratePlanId) {
        rateRepository.save(rate);
        builder.updateData(rate,"stay_date","rate_plan_id",String.valueOf(ratePlanId));
    }
}
