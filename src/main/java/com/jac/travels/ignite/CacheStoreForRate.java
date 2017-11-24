package com.jac.travels.ignite;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Rate;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class CacheStoreForRate extends CacheStoreAdapter<LocalDate, Rate> {
    Logger logger = LoggerFactory.getLogger(CacheStoreForRate.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Rate load(LocalDate localDate) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + localDate + ']');
        return queryBuilder.getDataById(Rate.class, "room_id", localDate);
    }

    @Override
    public void write(Cache.Entry<? extends LocalDate, ? extends Rate> entry) throws CacheWriterException {
        LocalDate key = entry.getKey();
        Rate rate = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + rate + ']');
            queryBuilder.insertData(rate);
            ProducerUtil.sendMessage("kafkaCacheTopic", rate.toString());
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", rate.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void loadCache(IgniteBiInClosure<LocalDate, Rate> clo, Object... args) {
        logger.info(">>> loading cache");
        queryBuilder.getAllData(Rate.class).stream().forEach(rate ->  {
            try {
                clo.apply(rate.getStay_date(), rate);
                ProducerUtil.sendMessage("kafkaCacheTopic", rate.toString());
            } catch (Exception e) {
                ProducerUtil.sendMessage("kafkaErrorTopic", rate.toString());
                e.printStackTrace();
            }
        });
    }
}
