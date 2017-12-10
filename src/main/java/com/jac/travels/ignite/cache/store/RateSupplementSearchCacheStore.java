package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateSupplementSearchPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RateSupplementSearch;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateSupplementSearchCacheStore extends CacheStoreAdapter<RateSupplementSearchPK, RateSupplementSearch> {
    Logger logger = LoggerFactory.getLogger(RateSupplementSearchCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateSupplementSearch load(RateSupplementSearchPK rateSupplementSearchPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + rateSupplementSearchPK + ']');
        return queryBuilder.getDataById(RateSupplementSearch.class, rateSupplementSearchPK);
    }

    @Override
    public void write(Cache.Entry<? extends RateSupplementSearchPK, ? extends RateSupplementSearch> entry) throws CacheWriterException {
        RateSupplementSearchPK key = entry.getKey();
        RateSupplementSearch value = entry.getValue();
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
