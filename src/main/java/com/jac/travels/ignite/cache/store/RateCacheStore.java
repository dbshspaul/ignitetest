package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RatePK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Rate;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateCacheStore extends CacheStoreAdapter<RatePK, Rate> {
    Logger logger = LoggerFactory.getLogger(RateCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Rate load(RatePK ratePK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + ratePK + ']');
        return queryBuilder.getDataById(Rate.class, ratePK);
    }

    @Override
    public void write(Cache.Entry<? extends RatePK, ? extends Rate> entry) throws CacheWriterException {
        RatePK key = entry.getKey();
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
}
