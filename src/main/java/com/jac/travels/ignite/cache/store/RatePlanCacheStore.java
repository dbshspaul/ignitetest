package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RatePlanPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RatePlan;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RatePlanCacheStore extends CacheStoreAdapter<RatePlanPK, RatePlan> {
    Logger logger = LoggerFactory.getLogger(RatePlanCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RatePlan load(RatePlanPK ratePlanPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + ratePlanPK + ']');
        return queryBuilder.getDataById(RatePlan.class, ratePlanPK);
    }

    @Override
    public void write(Cache.Entry<? extends RatePlanPK, ? extends RatePlan> entry) throws CacheWriterException {
        RatePlanPK key = entry.getKey();
        RatePlan rate = entry.getValue();
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
