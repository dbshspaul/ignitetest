package com.jac.travels.ignite;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.RatePK;
import com.jac.travels.model.Rate;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.transactions.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.cache.Cache;
import java.util.List;
import java.util.Scanner;

public class TestIgnite {
    Logger logger = LoggerFactory.getLogger(TestIgnite.class);
//    IgniteCache<RatePK, Rate> rateIgniteCache = IgniteDemo.getInstance().getRateCache();
    IgniteCache<RatePK, Rate> rateIgniteCache = null;

    public void insertData(int dayInEpoch){
        try {
            Rate rate = new Rate();
            RatePK ratePK = new RatePK();
            ratePK.setRate_plan_id(11);
            ratePK.setStay_date(LocalDate.fromDaysSinceEpoch(dayInEpoch));
            rate.setRatePK(ratePK);

            rateIgniteCache.put(rate.getRatePK(), rate);
            logger.info(rate.getRatePK()+" inserted successful.");
        } catch (TransactionException e) {
            logger.info(e.getMessage());
        }
    }

    public void getAllRates() {
        logger.info(">>>> fetching data.");
        QueryCursor<Cache.Entry<LocalDate, Rate>> query = rateIgniteCache.query(new ScanQuery<LocalDate, Rate>((k, p) -> true));
        try {
            query.forEach(localDateRateEntry -> {
                System.out.println(localDateRateEntry.getValue());
            });
        } catch (Exception e) {
            logger.info("No data found. "+e.getMessage());
        }
    }

    public void clearCache() {
        logger.info(">>>> clearing  cache.");
        rateIgniteCache.clear();
    }

    public static void main(String[] args) {
        TestIgnite testIgnite = new TestIgnite();
//        testIgnite.clearCache();
//        testIgnite.getAllRates();
//        testIgnite.insertData(16805);
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(!input.equalsIgnoreCase("x")){
            System.out.println("1 for clear, 2 for insert, 3 for scan, x for exit");
            input = sc.nextLine();
            switch (input){
                case "1" :
                    testIgnite.clearCache();
                    break;
                case "2" :
                    System.out.println("day in epoch...");
                    String s = sc.nextLine();
                    testIgnite.insertData(Integer.parseInt(s));
                    break;
                case "3" :
                    testIgnite.getAllRates();
                    break;
                default:
                    break;
            }
        }
    }
}
