package com.jac.travels.spring.service;

import com.jac.travels.model.Contract;
import com.jac.travels.spring.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository repository;

    @Override
    public List<Contract> getAll() {
        return (List<Contract>) repository.findAll();
    }
}
