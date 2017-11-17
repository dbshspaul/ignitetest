package com.jac.travels.spring.repositories;

import com.jac.travels.model.Contract;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CassandraRepository<Contract> {
}
