package com.jac.travels.ignite.cache.store;

import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Supplement;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class SupplementCacheStore extends CacheStoreAdapter<Integer, Supplement> {
    Logger logger = LoggerFactory.getLogger(SupplementCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Supplement load(Integer integer) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + integer + ']');
        return queryBuilder.getDataById(Supplement.class, integer);
    }

    @Override
    public void write(Cache.Entry<? extends Integer, ? extends Supplement> entry) throws CacheWriterException {
        Integer key = entry.getKey();
        Supplement value = entry.getValue();
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
