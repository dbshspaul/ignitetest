package com.jac.travels.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.travels.cassendra.CassandraConnector;
import com.jac.travels.ignite.TestIgnite;
import com.jac.travels.model.*;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * created by My System on 14-Dec-17
 **/
public class QueryBuilderTest {

    QueryBuilder queryBuilder = new QueryBuilder();

    @Test
    public void getAllData() {
        assertEquals("as","as");
    }

    @Test
    public void getDataById() {
    }

    @Test
    public void insertData() {
        ObjectMapper mapper = new ObjectMapper();
        Rate rate= null;
        try {
            rate = mapper.readValue("{\n" +
                    "\t\"ratePK\": {\n" +
                    "\t\t\"stay_date\": 16802,\n" +
                    "\t\"tenant_id\": \"weq12jn3j00000\",\n" +
                    "\t\t\"rate_plan_id\": 26\n" +
                    "\t},\n" +
                    "\t\"adult02_charge\": 10.5,\n" +
                    "\t\"adult03_charge\": null,\n" +
                    "\t\"adult04_charge\": null,\n" +
                    "\t\"adult05_charge\": null,\n" +
                    "\t\"adult06_charge\": null,\n" +
                    "\t\"adult07_charge\": null,\n" +
                    "\t\"adult08_charge\": null,\n" +
                    "\t\"adult09_charge\": null,\n" +
                    "\t\"adult10_charge\": null,\n" +
                    "\t\"adult11_charge\": null,\n" +
                    "\t\"adult12_charge\": null,\n" +
                    "\t\"adult13_charge\": null,\n" +
                    "\t\"adult14_charge\": null,\n" +
                    "\t\"adult15_charge\": null,\n" +
                    "\t\"adult16_charge\": null,\n" +
                    "\t\"adult17_charge\": null,\n" +
                    "\t\"adult18_charge\": null,\n" +
                    "\t\"adult19_charge\": null,\n" +
                    "\t\"adult20_charge\": null,\n" +
                    "\t\"adult21_charge\": null,\n" +
                    "\t\"adult22_charge\": null,\n" +
                    "\t\"adult23_charge\": null,\n" +
                    "\t\"adult24_charge\": null,\n" +
                    "\t\"adult25_charge\": null,\n" +
                    "\t\"adult26_charge\": null,\n" +
                    "\t\"adult27_charge\": null,\n" +
                    "\t\"adult28_charge\": null,\n" +
                    "\t\"adult29_charge\": null,\n" +
                    "\t\"adult30_charge\": null,\n" +
                    "\t\"adult_extra_charge\": 10,\n" +
                    "\t\"base_rate\": 50,\n" +
                    "\t\"child01_charge\": null,\n" +
                    "\t\"child01_split2_charge\": null,\n" +
                    "\t\"child02_charge\": null,\n" +
                    "\t\"child02_split2_charge\": null,\n" +
                    "\t\"child03_charge\": null,\n" +
                    "\t\"child03_split2_charge\": null,\n" +
                    "\t\"child04_charge\": null,\n" +
                    "\t\"child04_split2_charge\": null,\n" +
                    "\t\"child05_charge\": null,\n" +
                    "\t\"child06_charge\": null,\n" +
                    "\t\"child07_charge\": null,\n" +
                    "\t\"child08_charge\": null,\n" +
                    "\t\"child09_charge\": null,\n" +
                    "\t\"child10_charge\": null,\n" +
                    "\t\"child11_charge\": null,\n" +
                    "\t\"child12_charge\": null,\n" +
                    "\t\"child13_charge\": null,\n" +
                    "\t\"child14_charge\": null,\n" +
                    "\t\"child15_charge\": null,\n" +
                    "\t\"child16_charge\": null,\n" +
                    "\t\"child17_charge\": null,\n" +
                    "\t\"child18_charge\": null,\n" +
                    "\t\"child19_charge\": null,\n" +
                    "\t\"child20_charge\": null,\n" +
                    "\t\"child_charge\": 10,\n" +
                    "\t\"child_extra_charge\": null,\n" +
                    "\t\"child_extra_split2_charge\": null,\n" +
                    "\t\"child_split2_charge\": null,\n" +
                    "\t\"double_occ_charge\": 30,\n" +
                    "\t\"single_occ_charge\": 35,\n" +
                    "\t\"triple_occ_charge\": null,\n" +
                    "\t\"unit_rate\": null,\n" +
                    "\t\"youth01_charge\": null,\n" +
                    "\t\"youth01_split2_charge\": null,\n" +
                    "\t\"youth02_charge\": null,\n" +
                    "\t\"youth02_split2_charge\": null,\n" +
                    "\t\"youth03_charge\": null,\n" +
                    "\t\"youth03_split2_charge\": null,\n" +
                    "\t\"youth04_charge\": null,\n" +
                    "\t\"youth04_split2_charge\": null,\n" +
                    "\t\"youth05_charge\": null,\n" +
                    "\t\"youth06_charge\": null,\n" +
                    "\t\"youth07_charge\": null,\n" +
                    "\t\"youth08_charge\": null,\n" +
                    "\t\"youth09_charge\": null,\n" +
                    "\t\"youth10_charge\": null,\n" +
                    "\t\"youth11_charge\": null,\n" +
                    "\t\"youth12_charge\": null,\n" +
                    "\t\"youth13_charge\": null,\n" +
                    "\t\"youth14_charge\": null,\n" +
                    "\t\"youth15_charge\": null,\n" +
                    "\t\"youth16_charge\": null,\n" +
                    "\t\"youth17_charge\": null,\n" +
                    "\t\"youth18_charge\": null,\n" +
                    "\t\"youth19_charge\": null,\n" +
                    "\t\"youth20_charge\": null,\n" +
                    "\t\"youth_charge\": 20,\n" +
                    "\t\"youth_extra_charge\": 5,\n" +
                    "\t\"youth_extra_split2_charge\": null,\n" +
                    "\t\"youth_split2_charge\": null\n" +
                    "}", Rate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        queryBuilder.insertData(rate);
    }

    @Test
    public void insertData1(){

        ObjectMapper mapper = new ObjectMapper();
        List<Room> rooms = new ArrayList<>();
        try {
            rooms = mapper.readValue("[{\n" +
                    "\t\t\"roomPK\": {\n" +
                    "\t\t\t\"room_id\": 21,\n" +
                    "\t\t\t\"contract_id\": 5,\n" +
                    "\t\t\t\"tenant_id\": null\n" +
                    "\t\t},\n" +
                    "\t\t\"adult_max\": 1,\n" +
                    "\t\t\"adult_min\": 1,\n" +
                    "\t\t\"adult_with_child_max\": 9,\n" +
                    "\t\t\"allow_child_close_out\": null,\n" +
                    "\t\t\"allow_child_youth_close_out\": null,\n" +
                    "\t\t\"auto_upgrade_child_to_adult\": false,\n" +
                    "\t\t\"child_occ_only_allowed\": false,\n" +
                    "\t\t\"children_max\": 0,\n" +
                    "\t\t\"children_max_age\": 15,\n" +
                    "\t\t\"children_min\": 0,\n" +
                    "\t\t\"children_min_age\": 2,\n" +
                    "\t\t\"cots_max\": 1,\n" +
                    "\t\t\"exclude_adult_child_combinations\": null,\n" +
                    "\t\t\"extra_beds_used\": false,\n" +
                    "\t\t\"extra_rate_allocation\": null,\n" +
                    "\t\t\"has_durations_defined\": null,\n" +
                    "\t\t\"has_inventory_defined\": null,\n" +
                    "\t\t\"has_occ_allocation_defined\": null,\n" +
                    "\t\t\"has_split_inventory_defined\": null,\n" +
                    "\t\t\"infant_max_age\": 1,\n" +
                    "\t\t\"infants_count_toward_occupancy\": false,\n" +
                    "\t\t\"max_adults_extra_bed\": null,\n" +
                    "\t\t\"max_children_extra_bed\": null,\n" +
                    "\t\t\"max_occupancy_before_extra_bed\": null,\n" +
                    "\t\t\"occupancy_max\": 1,\n" +
                    "\t\t\"occupancy_min\": 1,\n" +
                    "\t\t\"occupancy_standard\": 1,\n" +
                    "\t\t\"room_type_code\": \"null\",\n" +
                    "\t\t\"room_type_name\": \"Single with Cot\",\n" +
                    "\t\t\"senior_min_age\": null,\n" +
                    "\t\t\"youth_count_as_adults\": false,\n" +
                    "\t\t\"youth_max_age\": null,\n" +
                    "\t\t\"youth_min_age\": null\n" +
                    "\t},\n" +
                    "\t{\n" +
                    "\t\t\"roomPK\": {\n" +
                    "\t\t\t\"room_id\": 22,\n" +
                    "\t\t\t\"contract_id\": 5,\n" +
                    "\t\t\t\"tenant_id\": null\n" +
                    "\t\t},\n" +
                    "\t\t\"adult_max\": 1,\n" +
                    "\t\t\"adult_min\": 1,\n" +
                    "\t\t\"adult_with_child_max\": null,\n" +
                    "\t\t\"allow_child_close_out\": null,\n" +
                    "\t\t\"allow_child_youth_close_out\": null,\n" +
                    "\t\t\"auto_upgrade_child_to_adult\": false,\n" +
                    "\t\t\"child_occ_only_allowed\": false,\n" +
                    "\t\t\"children_max\": 0,\n" +
                    "\t\t\"children_max_age\": 15,\n" +
                    "\t\t\"children_min\": 0,\n" +
                    "\t\t\"children_min_age\": 2,\n" +
                    "\t\t\"cots_max\": 0,\n" +
                    "\t\t\"exclude_adult_child_combinations\": null,\n" +
                    "\t\t\"extra_beds_used\": false,\n" +
                    "\t\t\"extra_rate_allocation\": null,\n" +
                    "\t\t\"has_durations_defined\": null,\n" +
                    "\t\t\"has_inventory_defined\": null,\n" +
                    "\t\t\"has_occ_allocation_defined\": null,\n" +
                    "\t\t\"has_split_inventory_defined\": null,\n" +
                    "\t\t\"infant_max_age\": 1,\n" +
                    "\t\t\"infants_count_toward_occupancy\": false,\n" +
                    "\t\t\"max_adults_extra_bed\": null,\n" +
                    "\t\t\"max_children_extra_bed\": null,\n" +
                    "\t\t\"max_occupancy_before_extra_bed\": null,\n" +
                    "\t\t\"occupancy_max\": 1,\n" +
                    "\t\t\"occupancy_min\": 1,\n" +
                    "\t\t\"occupancy_standard\": 1,\n" +
                    "\t\t\"room_type_code\": null,\n" +
                    "\t\t\"room_type_name\": \"Single\",\n" +
                    "\t\t\"senior_min_age\": null,\n" +
                    "\t\t\"youth_count_as_adults\": false,\n" +
                    "\t\t\"youth_max_age\": null,\n" +
                    "\t\t\"youth_min_age\": null\n" +
                    "\t}\n" +
                    "]", new TypeReference<List<Room>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
        queryBuilder.insertData(rooms);
    }

    @Test
    public void updateData() {
    }

    @Test
    public void checkTenantID() {
        ObjectMapper mapper = new ObjectMapper();
        Property property= null;
        try {
            property = mapper.readValue("{\n" +
                    "    \"property_id\": 37,\n" +
                    "    \"cutoff_time\": 14,\n" +
                    "    \"name\": \"Hotel 37\",\n" +
                    "    \"star_rating\": 4,\n" +
                    "    \"status\": true,\n" +
                    "    \"tenant_id\": \"123pok4400\",\n" +
                    "    \"timezone_id\": \"UTC\"\n" +
                    "}", Property.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean b=false;
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
            b = queryBuilder.checkTenantID(property,client,Property.class);
        }catch (Exception e){

        }
        assertEquals(true,b);
    }

    @Test
    public void delete() {
        ObjectMapper mapper = new ObjectMapper();
        Property property= null;
        try {
            property = mapper.readValue("{\n" +
                    "    \"property_id\": 88,\n" +
                    "    \"cutoff_time\": 14,\n" +
                    "    \"name\": \"Hotel 37\",\n" +
                    "    \"star_rating\": 4,\n" +
                    "    \"status\": true,\n" +
                    "    \"tenant_id\": \"123pok4400\",\n" +
                    "    \"timezone_id\": \"UTC\"\n" +
                    "}", Property.class);
            queryBuilder.delete(property,Property.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTableName(){
        assertEquals("rate",queryBuilder.getTableName(Rate.class));
        assertEquals("rate_plan",queryBuilder.getTableName(RatePlan.class));
        assertEquals("rate_plan_allocation",queryBuilder.getTableName(RatePlanAllocation.class));
    }
}
