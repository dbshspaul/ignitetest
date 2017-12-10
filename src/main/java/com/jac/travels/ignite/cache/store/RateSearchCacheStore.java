package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateSearchPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RateSearch;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateSearchCacheStore extends CacheStoreAdapter<RateSearchPK, RateSearch> {
    Logger logger = LoggerFactory.getLogger(RateSearchCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateSearch load(RateSearchPK rateSearchPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + rateSearchPK + ']');
        return queryBuilder.getDataById(RateSearch.class, rateSearchPK);
    }

    @Override
    public void write(Cache.Entry<? extends RateSearchPK, ? extends RateSearch> entry) throws CacheWriterException {
        RateSearchPK key = entry.getKey();
        RateSearch value = entry.getValue();
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
