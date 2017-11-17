package com.jac.travels.spring.repositories;

import com.jac.travels.model.Rate;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CassandraRepository<Rate> {
}
