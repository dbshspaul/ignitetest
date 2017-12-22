package com.jac.travels.spring.service;

import com.jac.travels.model.RatePlanAllocation;
import com.jac.travels.spring.repositories.RatePlanAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by My System on 21-Dec-17
 **/
@Service
public class RatePlanAllocationServiceImpl implements RatePlanAllocationService {
    @Autowired
    RatePlanAllocationRepository ratePlanAllocationRepository;
    @Override
    public List<RatePlanAllocation> getAll() {
        return (List<RatePlanAllocation>) ratePlanAllocationRepository.findAll();
    }
}
