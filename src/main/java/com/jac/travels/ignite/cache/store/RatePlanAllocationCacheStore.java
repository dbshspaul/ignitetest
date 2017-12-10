package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RatePlanAllocationPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RatePlanAllocation;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RatePlanAllocationCacheStore extends CacheStoreAdapter<RatePlanAllocationPK, RatePlanAllocation> {
    Logger logger = LoggerFactory.getLogger(RatePlanAllocationCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RatePlanAllocation load(RatePlanAllocationPK ratePlanAllocationPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + ratePlanAllocationPK + ']');
        return queryBuilder.getDataById(RatePlanAllocation.class, ratePlanAllocationPK);
    }

    @Override
    public void write(Cache.Entry<? extends RatePlanAllocationPK, ? extends RatePlanAllocation> entry) throws CacheWriterException {
        RatePlanAllocationPK key = entry.getKey();
        RatePlanAllocation value = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + value + ']');
            queryBuilder.insertData(value);
            ProducerUtil.sendMessage("kafkaCacheTopic", value.toString());
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", value.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
