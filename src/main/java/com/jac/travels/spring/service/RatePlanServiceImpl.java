package com.jac.travels.spring.service;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.jac.travels.model.RatePlan;
import com.jac.travels.spring.repositories.RatePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatePlanServiceImpl implements RatePlanService {
    @Autowired
    RatePlanRepository repository;
    @Autowired
    private CassandraOperations cassandraTemplate;

    @Override
    public List<RatePlan> getAll() {
        return (List<RatePlan>) repository.findAll();
    }

    @Override
    public List<RatePlan> getRatePlaneByRoomId(int roomId) {
        Select select = QueryBuilder.select().from("rate_plan");
        select.where(QueryBuilder.eq("room_id", roomId));
        List<RatePlan> ratePlans=cassandraTemplate.select(select, RatePlan.class);
        return ratePlans;
    }
}
