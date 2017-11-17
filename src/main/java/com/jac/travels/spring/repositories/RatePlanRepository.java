package com.jac.travels.spring.repositories;

import com.jac.travels.model.RatePlan;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatePlanRepository extends CassandraRepository<RatePlan> {
}
