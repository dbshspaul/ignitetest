package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateBoardBasisUpgradePK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RateBoardBasisUpgrade;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateBoardBasisUpgradeCacheStore extends CacheStoreAdapter<RateBoardBasisUpgradePK, RateBoardBasisUpgrade> {
    Logger logger = LoggerFactory.getLogger(RateBoardBasisUpgradeCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateBoardBasisUpgrade load(RateBoardBasisUpgradePK rateBoardBasisUpgradePK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + rateBoardBasisUpgradePK + ']');
        return queryBuilder.getDataById(RateBoardBasisUpgrade.class, rateBoardBasisUpgradePK);
    }

    @Override
    public void write(Cache.Entry<? extends RateBoardBasisUpgradePK, ? extends RateBoardBasisUpgrade> entry) throws CacheWriterException {
        RateBoardBasisUpgradePK key = entry.getKey();
        RateBoardBasisUpgrade value = entry.getValue();
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
