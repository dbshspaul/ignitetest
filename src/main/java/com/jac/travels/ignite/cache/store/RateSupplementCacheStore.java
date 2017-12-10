package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateSupplementPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RateSupplement;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateSupplementCacheStore extends CacheStoreAdapter<RateSupplementPK, RateSupplement> {
    Logger logger = LoggerFactory.getLogger(RateSupplementCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateSupplement load(RateSupplementPK rateSupplementPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + rateSupplementPK + ']');
        return queryBuilder.getDataById(RateSupplement.class, rateSupplementPK);
    }

    @Override
    public void write(Cache.Entry<? extends RateSupplementPK, ? extends RateSupplement> entry) throws CacheWriterException {
        RateSupplementPK key = entry.getKey();
        RateSupplement value = entry.getValue();
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
