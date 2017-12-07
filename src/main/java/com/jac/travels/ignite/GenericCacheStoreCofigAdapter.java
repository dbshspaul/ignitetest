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

public class GenericCacheStoreCofigAdapter<pk, clazz> extends CacheStoreAdapter<pk, clazz> {
    Logger logger = LoggerFactory.getLogger(GenericCacheStoreCofigAdapter.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public clazz load(pk pk) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + pk + ']');
//        return queryBuilder.getDataById(clazz, "stay_date", pk);
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends pk, ? extends clazz> entry) throws CacheWriterException {
        pk key = entry.getKey();
        clazz data = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + data + ']');
            //queryBuilder.insertData(data);
            ProducerUtil.sendMessage("kafkaCacheTopic", data.toString());
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", data.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void loadCache(IgniteBiInClosure<pk, clazz> clo, Object... args) {
        logger.info(">>> loading cache");

    }
}
