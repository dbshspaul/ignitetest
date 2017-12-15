package com.jac.travels.spring.controller;

import com.jac.travels.idclass.RatePK;
import com.jac.travels.ignite.IgniteDemo;
import com.jac.travels.model.Property;
import com.jac.travels.model.Rate;
import com.jac.travels.model.Room;
import com.jac.travels.spring.converters.RateConverter;
import com.jac.travels.spring.service.ContractService;
import com.jac.travels.spring.service.RatePlanService;
import com.jac.travels.spring.service.RateService;
import com.jac.travels.spring.service.RoomService;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.cache.Cache;
import java.util.Arrays;
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
    @Autowired
    IgniteDemo igniteDemo;


    @GetMapping("/rooms")
    @ResponseBody
    public List<Room> allRooms() {
        return roomService.getAll();
    }

    @GetMapping("/rate-db")
    @ResponseBody
    public List<Rate> allRatesFromDb() {
        return rateService.getAll();
    }

    @PostMapping("/rate")
    @ResponseBody
    public ResponseEntity rateByStayDate(@RequestParam(name = "rate-pk") RatePK ratePK) {
        try {
            IgniteCache<RatePK, Rate> rateIgniteCache = igniteDemo.getRateCache();
//            LocalDate localDate = LocalDate.fromDaysSinceEpoch(day);
//            QueryCursor<Cache.Entry<LocalDate, Rate>> query = rateIgniteCache.query(new ScanQuery<LocalDate, Rate>((k, p) -> p.getStay_date().equals(localDate)));
//            List<Cache.Entry<LocalDate, Rate>> all = query.getAll();
//            return new ResponseEntity(all.get(0).getValue(), HttpStatus.FOUND);
            return new ResponseEntity(rateIgniteCache.get(ratePK), HttpStatus.FOUND);

        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @GetMapping("/rates")
    @ResponseBody
    public ResponseEntity allRates() {
        IgniteCache<RatePK, Rate> rateIgniteCache = igniteDemo.getRateCache();
        QueryCursor<Cache.Entry<RatePK, Rate>> query = rateIgniteCache.query(new ScanQuery<RatePK, Rate>((k, p) -> true));
        List<Cache.Entry<RatePK, Rate>> all = query.getAll();
        return new ResponseEntity(all, HttpStatus.FOUND);
    }

    //    @GetMapping("/rate-plans")
//    @ResponseBody
//    public List<RatePlan> allRatePlans() {
//        return ratePlanService.getAll();
//    }
//
//    @GetMapping("/contracts")
//    @ResponseBody
//    public List<Contract> allContracts() {
//        return contractService.getAll();
//    }
//
    @PostMapping(value = "/set-rate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity insertRate(@RequestParam(name = "rate", required = false) Rate rate) {
        try {
            IgniteCache<RatePK, Rate> rateIgniteCache = igniteDemo.getRateCache();
            rateIgniteCache.put(rate.getRatePK(), rate);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }
//
//    @PostMapping(value = "/room/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public ResponseEntity insertRoom(@RequestParam(name = "room", required = false) Room room) {
//        try {
//            roomIgniteCache.put(room.getRoomPK().getRoom_id(), room);
//            Map<String, String> response = new HashMap<>();
//            response.put("msg", "Data updated successfully.");
//            return new ResponseEntity(response, HttpStatus.CREATED);
//        } catch (Exception e) {
//            Map<String, String> response = new HashMap<>();
//            response.put("msg", "Failed to find data.");
//            response.put("cause", e.getMessage());
//            e.printStackTrace();
//            return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
//        }
//    }

    @GetMapping(value = "/property/{propertyId}")
    @ResponseBody
    public ResponseEntity getProperty(@PathVariable(value = "propertyId") Integer propertyId) {
        MultiValueMap<String, String> header = new HttpHeaders();
        header.put("schema", Arrays.asList("PropertyRequestProto"));
        header.put("Content-Type", Arrays.asList("application/x-protobuf"));
        header.put("format", Arrays.asList("binary"));

        IgniteCache<Integer, Property> propertyCache = igniteDemo.getPropertyCache();
        Property property = propertyCache.get(propertyId);
        com.jac.travels.protobuf.Property.PropertyRequestProto property1 = com.jac.travels.protobuf.Property.PropertyRequestProto.newBuilder()
                .setPropertyId(property.getProperty_id())
                .setCutOffTime(property.getCutoff_time())
                .setStarRating(property.getStar_rating().floatValue())
                .setStatus(property.getStatus()==true?1:0)
                .setName(property.getName())
                .build();
        ResponseEntity entity = new ResponseEntity(property1,header, HttpStatus.FOUND);

        return entity;
    }

    @PostMapping(value = "/property")
    @ResponseBody
    public ResponseEntity saveProperty(@RequestParam(name = "property", required = true) Property property) {
        try {
            IgniteCache<Integer, Property> propertyCache = igniteDemo.getPropertyCache();
            propertyCache.put(property.getProperty_id(), property);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }


    @NotNull
    private ResponseEntity getErrorResponseEntity(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Failed to find data.");
        response.put("cause", e.getMessage());
        e.printStackTrace();
        return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
    }

}
