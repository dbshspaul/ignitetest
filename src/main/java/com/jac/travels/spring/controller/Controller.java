package com.jac.travels.spring.controller;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.ignite.IgniteDemo;
import com.jac.travels.model.Contract;
import com.jac.travels.model.Rate;
import com.jac.travels.model.RatePlan;
import com.jac.travels.model.Room;
import com.jac.travels.spring.converters.RateConverter;
import com.jac.travels.spring.service.ContractService;
import com.jac.travels.spring.service.RatePlanService;
import com.jac.travels.spring.service.RateService;
import com.jac.travels.spring.service.RoomService;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.transactions.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.cache.Cache;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    IgniteCache<LocalDate, Rate> rateIgniteCache = IgniteDemo.getInstance().getRateCache();
    IgniteCache<Integer, Room> roomIgniteCache = IgniteDemo.getInstance().getRoomCache();


    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> allRooms() {
        return roomService.getAll();
    }

    @GetMapping("/rate/{id}")
    @ResponseBody
    public ResponseEntity rateByStayDate(@PathVariable(name = "id") int day) {
        try {
            LocalDate localDate = LocalDate.fromDaysSinceEpoch(day);
//            QueryCursor<Cache.Entry<LocalDate, Rate>> query = rateIgniteCache.query(new ScanQuery<LocalDate, Rate>((k, p) -> p.getStay_date().equals(localDate)));
//            List<Cache.Entry<LocalDate, Rate>> all = query.getAll();
//            return new ResponseEntity(all.get(0).getValue(), HttpStatus.FOUND);
            return new ResponseEntity(rateIgniteCache.get(localDate), HttpStatus.FOUND);

        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Failed to find data.");
            response.put("cause", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/rates")
    @ResponseBody
    public ResponseEntity allRates() {
        QueryCursor<Cache.Entry<LocalDate, Rate>> query = rateIgniteCache.query(new ScanQuery<LocalDate, Rate>((k, p) -> true));
        List<Cache.Entry<LocalDate, Rate>> all = query.getAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
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

    @PostMapping(value = "/rate/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity insertRate(@RequestParam(name = "rate", required = false) Rate rate) {
        try {
            rateIgniteCache.put(rate.getStay_date(), rate);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Failed to find data.");
            response.put("cause", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping(value = "/room/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity insertRoom(@RequestParam(name = "room", required = false) Room room) {
        try {
            roomIgniteCache.put(room.getRoom_id(), room);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Failed to find data.");
            response.put("cause", e.getMessage());
            e.printStackTrace();
            return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
