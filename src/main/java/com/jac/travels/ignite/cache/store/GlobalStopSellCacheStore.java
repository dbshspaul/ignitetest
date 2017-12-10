package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.GlobalStopSellPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.GlobalStopSell;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class GlobalStopSellCacheStore extends CacheStoreAdapter<GlobalStopSellPK, GlobalStopSell> {
    Logger logger = LoggerFactory.getLogger(GlobalStopSellCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public GlobalStopSell load(GlobalStopSellPK globalStopSellPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + globalStopSellPK + ']');
        return queryBuilder.getDataById(GlobalStopSell.class, globalStopSellPK);
    }

    @Override
    public void write(Cache.Entry<? extends GlobalStopSellPK, ? extends GlobalStopSell> entry) throws CacheWriterException {
        GlobalStopSellPK key = entry.getKey();
        GlobalStopSell value = entry.getValue();
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
