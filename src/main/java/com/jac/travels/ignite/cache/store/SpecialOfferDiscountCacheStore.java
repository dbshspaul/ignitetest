package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.SpecialOfferDiscountPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.SpecialOfferDiscount;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class SpecialOfferDiscountCacheStore extends CacheStoreAdapter<SpecialOfferDiscountPK, SpecialOfferDiscount> {
    Logger logger = LoggerFactory.getLogger(SpecialOfferDiscountCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public SpecialOfferDiscount load(SpecialOfferDiscountPK specialOfferDiscountPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + specialOfferDiscountPK + ']');
        return queryBuilder.getDataById(SpecialOfferDiscount.class, specialOfferDiscountPK);
    }

    @Override
    public void write(Cache.Entry<? extends SpecialOfferDiscountPK, ? extends SpecialOfferDiscount> entry) throws CacheWriterException {
        SpecialOfferDiscountPK key = entry.getKey();
        SpecialOfferDiscount value = entry.getValue();
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
