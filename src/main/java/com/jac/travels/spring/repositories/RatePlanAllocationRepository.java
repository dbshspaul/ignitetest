package com.jac.travels.spring.repositories;

import com.jac.travels.model.RatePlanAllocation;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * created by My System on 21-Dec-17
 **/
public interface RatePlanAllocationRepository extends CassandraRepository<RatePlanAllocation> {
}
