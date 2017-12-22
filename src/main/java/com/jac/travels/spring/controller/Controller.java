package com.jac.travels.spring.controller;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.*;
import com.jac.travels.ignite.IgniteClientNode;
import com.jac.travels.model.*;
import org.apache.ignite.IgniteCache;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    IgniteClientNode igniteClientNode;


    @GetMapping(value = "/property/{propertyId}")
    @ResponseBody
    public ResponseEntity getProperty(@PathVariable(value = "propertyId") Integer propertyId, @RequestParam(value = "tenant_id") String tenantId) {
        MultiValueMap<String, String> header = new HttpHeaders();
        header.put("schema", Arrays.asList("PropertyRequestProto"));
        header.put("Content-Type", Arrays.asList("application/x-protobuf"));
        header.put("format", Arrays.asList("binary"));

        IgniteCache<PropertyPK, Property> propertyCache = igniteClientNode.getPropertyCache();
        PropertyPK propertyPK = new PropertyPK();
        propertyPK.setProperty_id(propertyId);
        propertyPK.setTenant_id(tenantId);
        Property property = propertyCache.get(propertyPK);
        ResponseEntity entity = null;
        if (property != null) {
            com.jac.travels.protobuf.Property.PropertyRequestProto property1 = com.jac.travels.protobuf.Property.PropertyRequestProto.newBuilder()
                    .setPropertyId(property.getPropertyPK().getProperty_id())
                    .setCutOffTime(property.getCutoff_time())
                    .setStarRating(property.getStar_rating().floatValue())
                    .setStatus(property.getStatus() == true ? 1 : 0)
                    .setName(property.getName())
                    .build();
            entity = new ResponseEntity(property1, header, HttpStatus.FOUND);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), header, HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @DeleteMapping(value = "/property/{propertyId}")
    @ResponseBody
    public ResponseEntity deletePropery(@PathVariable(value = "propertyId") Integer propertyId, @RequestParam(value = "tenant_id") String tenantId) {
        IgniteCache<PropertyPK, Property> propertyCache = igniteClientNode.getPropertyCache();
        PropertyPK propertyPK = new PropertyPK();
        propertyPK.setProperty_id(propertyId);
        propertyPK.setTenant_id(tenantId);
        propertyCache.remove(propertyPK);
        return new ResponseEntity(new StringBuilder("Successfully deleted."), HttpStatus.CREATED);
    }

    @PostMapping(value = "/property")
    @ResponseBody
    public ResponseEntity saveProperty(@RequestParam(name = "property", required = true) Property property) {
        try {
            IgniteCache<PropertyPK, Property> propertyCache = igniteClientNode.getPropertyCache();
            propertyCache.put(property.getPropertyPK(), property);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }


    /////////////////////////////////////CONTRACT///////////////////////////////////////////
    @PostMapping(value = "/contract")
    @ResponseBody
    public ResponseEntity saveContract(@RequestParam(name = "contract", required = true) Contract contract) {
        try {
            IgniteCache<ContractPK, Contract> contractCache = igniteClientNode.getContractCache();
            contractCache.put(contract.getContractPK(), contract);
            Map<String, String> response = new HashMap<>();
            response.put("msg", "Data updated successfully.");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @GetMapping(value = "/contract/{contractId}")
    @ResponseBody
    public ResponseEntity getContractById(@PathVariable(value = "contractId") Integer contractId,
                                          @RequestParam(value = "tenant_id") String tenantId,
                                          @RequestParam(value = "property_id") Integer propertyId) {
        MultiValueMap<String, String> header = new HttpHeaders();
        header.put("schema", Arrays.asList("PropertyRequestProto"));
        header.put("Content-Type", Arrays.asList("application/x-protobuf"));
        header.put("format", Arrays.asList("binary"));

        IgniteCache<ContractPK, Contract> contractCache = igniteClientNode.getContractCache();
        ContractPK contractPK = new ContractPK();
        contractPK.setProperty_id(propertyId);
        contractPK.setContract_id(contractId);
        contractPK.setTenant_id(tenantId);
        Contract contract = contractCache.get(contractPK);
        ResponseEntity entity = null;
        if (contract != null) {
            com.jac.travels.protobuf.Contract.ContractRequestProto contractRequestProto = com.jac.travels.protobuf.Contract.ContractRequestProto.newBuilder()
                    .setContractId(contract.getContractPK().getContract_id())
                    .setPropertyId(contract.getContractPK().getProperty_id())
                    .setBookingFrom(contract.getBooking_from().toString())
                    .setBookingTo(contract.getBooking_to().toString())
                    .setBuyingCurrency(contract.getBuying_currency())
                    .setChannelManagerId(contract.getChannel_manager_id())
                    .setChannelTypeId(contract.getChannel_type_id())
                    .setContractStatusId(contract.getContract_status_id())
                    .setContractTypeId(contract.getContract_type_id())
                    .setFollowOnContractId(contract.getFollow_on_contract_id())
                    .setNoEndDates(contract.getNo_end_dates() ? 1 : 0)
                    .setStayFrom(contract.getStay_from().toString())
                    .setStayTo(contract.getStay_to().toString())
                    .build();
            entity = new ResponseEntity(contractRequestProto, header, HttpStatus.FOUND);
        } else {
            entity = new ResponseEntity(new StringBuilder("No Data found."), header, HttpStatus.NOT_FOUND);
        }

        return entity;
    }

    @DeleteMapping(value = "/contract/{contractId}")
    @ResponseBody
    public ResponseEntity deleteContractById(@PathVariable(value = "contractId") Integer contractId,
                                             @RequestParam(value = "tenant_id") String tenantId,
                                             @RequestParam(value = "property_id") Integer propertyId) {
        IgniteCache<ContractPK, Contract> contractCache = igniteClientNode.getContractCache();
        ContractPK contractPK = new ContractPK();
        contractPK.setProperty_id(propertyId);
        contractPK.setContract_id(contractId);
        contractPK.setTenant_id(tenantId);
        contractCache.remove(contractPK);
        return new ResponseEntity(new StringBuilder("Successfully deleted."), HttpStatus.CREATED);
    }

    //////////////////////////////////////rate/////////////////////////////////////////////////
    @PostMapping("/rate")
    @ResponseBody
    public ResponseEntity rateByStayDate(@RequestParam(name = "rate") Rate rate) {
        try {
            IgniteCache<RatePK, Rate> rateIgniteCache = igniteClientNode.getRateCache();
            rateIgniteCache.put(rate.getRatePK(), rate);
            return new ResponseEntity(new StringBuilder("Successfully created"), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @GetMapping("/rate/{ratePlanId}")
    @ResponseBody
    public ResponseEntity getRateById(@PathVariable(name = "ratePlanId") Integer ratePlanId, @RequestParam(name = "stayDate") LocalDate stayDate, @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RatePK, Rate> rateIgniteCache = igniteClientNode.getRateCache();
            RatePK ratePK = new RatePK();
            ratePK.setRate_plan_id(ratePlanId);
            ratePK.setStay_date(stayDate);
            ratePK.setTenant_id(tenantId);
            Rate rate = rateIgniteCache.get(ratePK);
            if (rate != null) {
                return new ResponseEntity(rate, HttpStatus.FOUND);
            } else {
                return new ResponseEntity(new StringBuilder("No data found"), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @DeleteMapping("/rate/{ratePlanId}")
    @ResponseBody
    public ResponseEntity deleteRateById(@PathVariable(name = "ratePlanId") Integer ratePlanId, @RequestParam(name = "stayDate") LocalDate stayDate, @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RatePK, Rate> rateIgniteCache = igniteClientNode.getRateCache();
            RatePK ratePK = new RatePK();
            ratePK.setRate_plan_id(ratePlanId);
            ratePK.setStay_date(stayDate);
            ratePK.setTenant_id(tenantId);
            rateIgniteCache.remove(ratePK);
            return new ResponseEntity(new StringBuilder("Rate Successfully Deleted."), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    //////////////////////////////////////room/////////////////////////////////////////////////
    @PostMapping("/room")
    @ResponseBody
    public ResponseEntity insertRoom(@RequestParam(name = "room") Room room) {
        try {
            IgniteCache<RoomPK, Room> roomCache = igniteClientNode.getRoomCache();
            roomCache.put(room.getRoomPK(), room);
            return new ResponseEntity(new StringBuilder("Successfully created"), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ResponseEntity getRateById(@PathVariable(name = "roomId") Integer roomId,
                                      @RequestParam(name = "contractId") Integer contractId,
                                      @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RoomPK, Room> roomCache = igniteClientNode.getRoomCache();
            RoomPK roomPK = new RoomPK();
            roomPK.setRoom_id(roomId);
            roomPK.setContract_id(contractId);
            roomPK.setTenant_id(tenantId);
            Room room = roomCache.get(roomPK);
            if (room != null) {
                return new ResponseEntity(room, HttpStatus.FOUND);
            } else {
                return new ResponseEntity(new StringBuilder("No data found"), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @DeleteMapping("/room/{roomId}")
    @ResponseBody
    public ResponseEntity deleteRateById(@PathVariable(name = "roomId") Integer roomId,
                                         @RequestParam(name = "contractId") Integer contractId,
                                         @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RoomPK, Room> roomCache = igniteClientNode.getRoomCache();
            RoomPK roomPK = new RoomPK();
            roomPK.setRoom_id(roomId);
            roomPK.setContract_id(contractId);
            roomPK.setTenant_id(tenantId);
            roomCache.remove(roomPK);
            return new ResponseEntity(new StringBuilder("Room Successfully Deleted."), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

//////////////////////////////////////rate plan/////////////////////////////////////////////////////////////////////

    @PostMapping("/rate-plan")
    @ResponseBody
    public ResponseEntity insertRatePlan(@RequestParam(name = "ratePlan") RatePlan ratePlan) {
        try {
            IgniteCache<RatePlanPK, RatePlan> ratePlanIgniteCache = igniteClientNode.getRatePlanIgniteCache();
            ratePlanIgniteCache.put(ratePlan.getRatePlanPK(), ratePlan);
            return new ResponseEntity(new StringBuilder("Successfully created"), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @GetMapping("/rate-plan/{ratePlanId}")
    @ResponseBody
    public ResponseEntity getRatePlanById(@PathVariable(name = "ratePlanId") Integer ratePlanId,
                                      @RequestParam(name = "roomId") Integer roomId,
                                      @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RatePlanPK, RatePlan> ratePlanIgniteCache = igniteClientNode.getRatePlanIgniteCache();
            RatePlanPK ratePlanPK = new RatePlanPK();
            ratePlanPK.setRoom_id(roomId);
            ratePlanPK.setRate_plan_id(ratePlanId);
            ratePlanPK.setTenant_id(tenantId);
            RatePlan ratePlan = ratePlanIgniteCache.get(ratePlanPK);
            if (ratePlan != null) {
                return new ResponseEntity(ratePlan, HttpStatus.FOUND);
            } else {
                return new ResponseEntity(new StringBuilder("No data found"), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @DeleteMapping("/rate-plan/{ratePlanId}")
    @ResponseBody
    public ResponseEntity deleteRatePlanById(@PathVariable(name = "ratePlanId") Integer ratePlanId,
                                             @RequestParam(name = "roomId") Integer roomId,
                                             @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RatePlanPK, RatePlan> ratePlanIgniteCache = igniteClientNode.getRatePlanIgniteCache();
            RatePlanPK ratePlanPK = new RatePlanPK();
            ratePlanPK.setRoom_id(roomId);
            ratePlanPK.setRate_plan_id(ratePlanId);
            ratePlanPK.setTenant_id(tenantId);
            ratePlanIgniteCache.remove(ratePlanPK);
            return new ResponseEntity(new StringBuilder("Rate Plan Successfully Deleted."), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

//////////////////////////////////////rateplan allocation/////////////////////////////////////////////////////////////////////

    @PostMapping("/rate-plan-allocations")
    @ResponseBody
    public ResponseEntity insertRatePlanallocations(@RequestParam(name = "ratePlanAllocation") RatePlanAllocation ratePlanAllocation) {
        try {
            IgniteCache<RatePlanAllocationPK, RatePlanAllocation> ratePlanAllocationIgniteCache = igniteClientNode.getRatePlanAllocationIgniteCache();
            ratePlanAllocationIgniteCache.put(ratePlanAllocation.getRatePlanAllocationPK(), ratePlanAllocation);
            return new ResponseEntity(new StringBuilder("Successfully created"), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @GetMapping("/rate-plan-allocations/{ratePlanId}")
    @ResponseBody
    public ResponseEntity getRatePlanallocationsById(@PathVariable(name = "ratePlanId") Integer ratePlanId,
                                      @RequestParam(name = "stay_date") LocalDate stayDate,
                                      @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RatePlanAllocationPK, RatePlanAllocation> ratePlanAllocationIgniteCache = igniteClientNode.getRatePlanAllocationIgniteCache();
            RatePlanAllocationPK ratePlanAllocationPK = new RatePlanAllocationPK();
            ratePlanAllocationPK.setStay_date(stayDate);
            ratePlanAllocationPK.setRate_plan_id(ratePlanId);
            ratePlanAllocationPK.setTenant_id(tenantId);
            RatePlanAllocation planAllocation = ratePlanAllocationIgniteCache.get(ratePlanAllocationPK);
            if (planAllocation != null) {
                return new ResponseEntity(planAllocation, HttpStatus.FOUND);
            } else {
                return new ResponseEntity(new StringBuilder("No data found"), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }

    @DeleteMapping("/rate-plan-allocations/{ratePlanId}")
    @ResponseBody
    public ResponseEntity deleteRatePlaallocationsnById(@PathVariable(name = "ratePlanId") Integer ratePlanId,
                                                        @RequestParam(name = "stay_date") LocalDate stayDate,
                                                        @RequestParam(name = "tenantId") String tenantId) {
        try {
            IgniteCache<RatePlanAllocationPK, RatePlanAllocation> ratePlanAllocationIgniteCache = igniteClientNode.getRatePlanAllocationIgniteCache();
            RatePlanAllocationPK ratePlanAllocationPK = new RatePlanAllocationPK();
            ratePlanAllocationPK.setStay_date(stayDate);
            ratePlanAllocationPK.setRate_plan_id(ratePlanId);
            ratePlanAllocationPK.setTenant_id(tenantId);
            ratePlanAllocationIgniteCache.get(ratePlanAllocationPK);
            return new ResponseEntity(new StringBuilder("Rate Plan Allocation Successfully Deleted."), HttpStatus.CREATED);
        } catch (Exception e) {
            return getErrorResponseEntity(e);
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @NotNull
    private ResponseEntity getErrorResponseEntity(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Failed to find data.");
        response.put("cause", e.getMessage());
        e.printStackTrace();
        return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
    }

}
