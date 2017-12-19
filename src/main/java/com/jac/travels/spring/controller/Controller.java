package com.jac.travels.spring.controller;

import com.jac.travels.idclass.ContractPK;
import com.jac.travels.idclass.PropertyPK;
import com.jac.travels.ignite.IgniteClientNode;
import com.jac.travels.model.Contract;
import com.jac.travels.model.Property;
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
        Contract contract= contractCache.get(contractPK);
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
                    .setNoEndDates(contract.getNo_end_dates()?1:0)
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


    @NotNull
    private ResponseEntity getErrorResponseEntity(Exception e) {
        Map<String, String> response = new HashMap<>();
        response.put("msg", "Failed to find data.");
        response.put("cause", e.getMessage());
        e.printStackTrace();
        return new ResponseEntity(response, HttpStatus.EXPECTATION_FAILED);
    }

}
