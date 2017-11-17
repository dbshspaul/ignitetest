package com.jac.travels.spring.service;

import com.jac.travels.model.Rate;
import com.jac.travels.spring.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateRepository rateRepository;

    @Override
    public List<Rate> getAll() {
        return (List<Rate>) rateRepository.findAll();
    }
}
