package com.jac.travels.spring.controller;

import com.jac.travels.model.*;
import com.jac.travels.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * created by My System on 19-Dec-17
 **/
@RestController
public class TestController {
    @Autowired
    RoomService roomService;
    @Autowired
    RateService rateService;
    @Autowired
    ContractService contractService;
    @Autowired
    RatePlanService ratePlanService;
    @Autowired
    RatePlanAllocationService ratePlanAllocationService;

    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> allRooms() {
        return roomService.getAll();
    }

    @GetMapping("/rates")
    @ResponseBody
    public List<Rate> allRatesFromDb() {
        return rateService.getAll();
    }

    @GetMapping(value = "/contracts")
    @ResponseBody
    public List<Contract> getAllContracts() {
        return contractService.getAll();
    }

    @GetMapping(value = "/rate-plans")
    @ResponseBody
    public List<RatePlan> getAllRatePlans() {
        return ratePlanService.getAll();
    }

    @PostMapping(value = "/rate-plans")
    @ResponseBody
    public ResponseEntity getSaveRatePlans(@RequestParam(name = "ratePlan")RatePlan ratePlan) {
        ratePlanService.save(ratePlan);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(value = "/rate-plan-allocations")
    @ResponseBody
    public List<RatePlanAllocation> getAllRatePlanAllocations() {
        return ratePlanAllocationService.getAll();
    }
}
