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
            com.jac.travels.protobuf.Response.PropertyResponseProto property1 = com.jac.travels.protobuf.Response.PropertyResponseProto.newBuilder()
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
            com.jac.travels.protobuf.Response.ContractResponseProto contractRequestProto = com.jac.travels.protobuf.Response.ContractResponseProto.newBuilder()
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
                com.jac.travels.protobuf.Response.RateResponseProto rateResponseProto = com.jac.travels.protobuf.Response.RateResponseProto.newBuilder()
                        .setStayDate(rate.getRatePK().getStay_date().toString())
                        .setRatePlanId(rate.getRatePK().getRate_plan_id())
                        .setAdult02Charge(rate.getAdult02_charge().floatValue())
                        .setAdult03Charge(rate.getAdult03_charge().floatValue())
                        .setAdult04Charge(rate.getAdult04_charge().floatValue())
                        .setAdult05Charge(rate.getAdult05_charge().floatValue())
                        .setAdult06Charge(rate.getAdult06_charge().floatValue())
                        .setAdult07Charge(rate.getAdult07_charge().floatValue())
                        .setAdult08Charge(rate.getAdult08_charge().floatValue())
                        .setAdult09Charge(rate.getAdult09_charge().floatValue())
                        .setAdult10Charge(rate.getAdult10_charge().floatValue())
                        .setAdult11Charge(rate.getAdult11_charge().floatValue())
                        .setAdult12Charge(rate.getAdult12_charge().floatValue())
                        .setAdult13Charge(rate.getAdult13_charge().floatValue())
                        .setAdult14Charge(rate.getAdult14_charge().floatValue())
                        .setAdult15Charge(rate.getAdult15_charge().floatValue())
                        .setAdult16Charge(rate.getAdult16_charge().floatValue())
                        .setAdult17Charge(rate.getAdult17_charge().floatValue())
                        .setAdult18Charge(rate.getAdult18_charge().floatValue())
                        .setAdult19Charge(rate.getAdult19_charge().floatValue())
                        .setAdult20Charge(rate.getAdult20_charge().floatValue())
                        .setAdult21Charge(rate.getAdult21_charge().floatValue())
                        .setAdult22Charge(rate.getAdult22_charge().floatValue())
                        .setAdult23Charge(rate.getAdult23_charge().floatValue())
                        .setAdult24Charge(rate.getAdult24_charge().floatValue())
                        .setAdult25Charge(rate.getAdult25_charge().floatValue())
                        .setAdult26Charge(rate.getAdult26_charge().floatValue())
                        .setAdult27Charge(rate.getAdult27_charge().floatValue())
                        .setAdult28Charge(rate.getAdult28_charge().floatValue())
                        .setAdult29Charge(rate.getAdult29_charge().floatValue())
                        .setAdult30Charge(rate.getAdult30_charge().floatValue())
                        .setAdultExtraCharge(rate.getAdult_extra_charge().floatValue())
                        .setBaseRate(rate.getBase_rate().floatValue())
                        .setChild01Charge(rate.getChild01_charge().floatValue())
                        .setChild01Split2Charge(rate.getChild01_split2_charge().floatValue())
                        .setChild02Charge(rate.getChild02_charge().floatValue())
                        .setChild02Split2Charge(rate.getChild02_split2_charge().floatValue())
                        .setChild03Charge(rate.getChild03_charge().floatValue())
                        .setChild03Split2Charge(rate.getChild03_split2_charge().floatValue())
                        .setChild04Charge(rate.getChild04_charge().floatValue())
                        .setChild04Split2Charge(rate.getChild04_split2_charge().floatValue())
                        .setChild05Charge(rate.getChild05_charge().floatValue())
                        .setChild06Charge(rate.getChild06_charge().floatValue())
                        .setChild07Charge(rate.getChild07_charge().floatValue())
                        .setChild08Charge(rate.getChild08_charge().floatValue())
                        .setChild09Charge(rate.getChild09_charge().floatValue())
                        .setChild10Charge(rate.getChild10_charge().floatValue())
                        .setChild11Charge(rate.getChild11_charge().floatValue())
                        .setChild12Charge(rate.getChild12_charge().floatValue())
                        .setChild13Charge(rate.getChild13_charge().floatValue())
                        .setChild14Charge(rate.getChild14_charge().floatValue())
                        .setChild15Charge(rate.getChild15_charge().floatValue())
                        .setChild16Charge(rate.getChild16_charge().floatValue())
                        .setChild17Charge(rate.getChild17_charge().floatValue())
                        .setChild18Charge(rate.getChild18_charge().floatValue())
                        .setChild19Charge(rate.getChild19_charge().floatValue())
                        .setChild20Charge(rate.getChild20_charge().floatValue())
                        .setChildCharge(rate.getChild_charge().floatValue())
                        .setChildExtraCharge(rate.getChild_extra_charge().floatValue())
                        .setChildExtraSplit2Charge(rate.getChild_extra_split2_charge().floatValue())
                        .setChildSplit2Charge(rate.getChild_split2_charge().floatValue())
                        .setDoubleOccCharge(rate.getDouble_occ_charge().floatValue())
                        .setSingleOccCharge(rate.getSingle_occ_charge().floatValue())
                        .setTripleOccCharge(rate.getTriple_occ_charge().floatValue())
                        .setUnitRate(rate.getUnit_rate().floatValue())
                        .setYouth01Charge(rate.getYouth01_charge().floatValue())
                        .setYouth01Split2Charge(rate.getYouth01_split2_charge().floatValue())
                        .setYouth02Charge(rate.getYouth02_charge().floatValue())
                        .setYouth02Split2Charge(rate.getYouth02_split2_charge().floatValue())
                        .setYouth03Charge(rate.getYouth03_charge().floatValue())
                        .setYouth03Split2Charge(rate.getYouth03_split2_charge().floatValue())
                        .setYouth04Charge(rate.getYouth04_charge().floatValue())
                        .setYouth04Split2Charge(rate.getYouth04_split2_charge().floatValue())
                        .setYouth05Charge(rate.getYouth05_charge().floatValue())
                        .setYouth06Charge(rate.getYouth06_charge().floatValue())
                        .setYouth07Charge(rate.getYouth07_charge().floatValue())
                        .setYouth08Charge(rate.getYouth08_charge().floatValue())
                        .setYouth09Charge(rate.getYouth09_charge().floatValue())
                        .setYouth10Charge(rate.getYouth10_charge().floatValue())
                        .setYouth11Charge(rate.getYouth11_charge().floatValue())
                        .setYouth12Charge(rate.getYouth12_charge().floatValue())
                        .setYouth13Charge(rate.getYouth13_charge().floatValue())
                        .setYouth14Charge(rate.getYouth14_charge().floatValue())
                        .setYouth15Charge(rate.getYouth15_charge().floatValue())
                        .setYouth16Charge(rate.getYouth16_charge().floatValue())
                        .setYouth17Charge(rate.getYouth17_charge().floatValue())
                        .setYouth18Charge(rate.getYouth18_charge().floatValue())
                        .setYouth19Charge(rate.getYouth19_charge().floatValue())
                        .setYouth20Charge(rate.getYouth20_charge().floatValue())
                        .setYouthCharge(rate.getYouth_charge().floatValue())
                        .setYouthExtraCharge(rate.getYouth_extra_charge().floatValue())
                        .setYouthExtraSplit2Charge(rate.getYouth_extra_split2_charge().floatValue())
                        .setYouthSplit2Charge(rate.getYouth_split2_charge().floatValue())
                        .build();
                return new ResponseEntity(rateResponseProto, HttpStatus.FOUND);
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
                com.jac.travels.protobuf.Response.RoomResponseProto roomResponseProto = com.jac.travels.protobuf.Response.RoomResponseProto.newBuilder()
                        .setRoomId(room.getRoomPK().getRoom_id())
                        .setContractId(room.getRoomPK().getContract_id())
                        .setAdultMax(room.getAdult_max())
                        .setAdultMin(room.getAdult_min())
                        .setAdultWithChildMax(room.getAdult_with_child_max())
                        .setAllowChildCloseOut(room.getAllow_child_close_out())
                        .setAllowChildYouthCloseOut(room.getAllow_child_youth_close_out())
                        .setAutoUpgradeChildToAdult(room.getAuto_upgrade_child_to_adult())
                        .setChildOccOnlyAllowed(room.getChild_occ_only_allowed())
                        .setChildrenMax(room.getChildren_max())
                        .setChildrenMaxAge(room.getChildren_max_age())
                        .setChildrenMin(room.getChildren_min())
                        .setChildrenMinAge(room.getChildren_min_age())
                        .setCotsMax(room.getCots_max())
                        .setExcludeAdultChildCombinations(room.getExclude_adult_child_combinations())
                        .setExtraBedsUsed(room.getExtra_beds_used())
                        .setExtraRateAllocation(room.getExtra_rate_allocation())
                        .setHasDurationsDefined(room.getHas_durations_defined())
                        .setHasInventoryDefined(room.getHas_inventory_defined())
                        .setHasOccAllocationDefined(room.getHas_occ_allocation_defined())
                        .setHasSplitInventoryDefined(room.getHas_split_inventory_defined())
                        .setInfantMaxAge(room.getInfant_max_age())
                        .setInfantsCountTowardOccupancy(room.getInfants_count_toward_occupancy())
                        .setMaxAdultsExtraBed(room.getMax_adults_extra_bed())
                        .setMaxChildrenExtraBed(room.getMax_children_extra_bed())
                        .setMaxOccupancyBeforeExtraBed(room.getMax_occupancy_before_extra_bed())
                        .setOccupancyMax(room.getOccupancy_max())
                        .setOccupancyMin(room.getOccupancy_min())
                        .setOccupancyStandard(room.getOccupancy_standard())
                        .setRoomTypeCode(room.getRoom_type_code())
                        .setRoomTypeName(room.getRoom_type_name())
                        .setSeniorMinAge(room.getSenior_min_age())
                        .setYouthCountAsAdults(room.getYouth_count_as_adults())
                        .setYouthMaxAge(room.getYouth_max_age())
                        .setYouthMinAge(room.getYouth_min_age())
                        .build();
                return new ResponseEntity(roomResponseProto, HttpStatus.FOUND);
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
                com.jac.travels.protobuf.Response.RatePlanResponseProto ratePlanResponseProto = com.jac.travels.protobuf.Response.RatePlanResponseProto.newBuilder()
                        .build();
                return new ResponseEntity(ratePlanResponseProto, HttpStatus.FOUND);
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
