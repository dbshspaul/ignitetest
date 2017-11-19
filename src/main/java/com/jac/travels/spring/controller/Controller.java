package com.jac.travels.spring.controller;

import com.jac.travels.model.Contract;
import com.jac.travels.model.Rate;
import com.jac.travels.model.RatePlan;
import com.jac.travels.model.Room;
import com.jac.travels.spring.converters.RateConverter;
import com.jac.travels.spring.service.ContractService;
import com.jac.travels.spring.service.RatePlanService;
import com.jac.travels.spring.service.RateService;
import com.jac.travels.spring.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    RoomService roomService;
    @Autowired
    RateService rateService;
    @Autowired
    RatePlanService ratePlanService;
    @Autowired
    ContractService contractService;
    @Autowired
    RateConverter rateConverter;


    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> allRooms() {
        return roomService.getAll();
    }

    @GetMapping("/rates")
    @ResponseBody
    public List<Rate> allRates() {
        return rateService.getAll();
    }

    @GetMapping("/rate-plans")
    @ResponseBody
    public List<RatePlan> allRatePlans() {
        return ratePlanService.getAll();
    }

    @GetMapping("/contracts")
    @ResponseBody
    public List<Contract> allContracts() {
        return contractService.getAll();
    }

    @PutMapping(name = "/rate/room", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity updateRateByRoom(@RequestParam(name = "room-id") int roomId, @RequestParam(name = "rate", required = false) Rate rate) {
        List<RatePlan> ratePlans=ratePlanService.getRatePlaneByRoomId(roomId);
        //todo update rate
        return new ResponseEntity(ratePlans, HttpStatus.CREATED);
    }
}
