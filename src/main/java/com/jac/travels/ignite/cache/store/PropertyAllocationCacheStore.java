package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.PropertyAllocationPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.PropertyAllocation;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class PropertyAllocationCacheStore extends CacheStoreAdapter<PropertyAllocationPK, PropertyAllocation> {
    Logger logger = LoggerFactory.getLogger(PropertyAllocationCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();


    @Override
    public PropertyAllocation load(PropertyAllocationPK propertyAllocationPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + propertyAllocationPK + ']');
        return queryBuilder.getDataById(PropertyAllocation.class, propertyAllocationPK);
    }

    @Override
    public void write(Cache.Entry<? extends PropertyAllocationPK, ? extends PropertyAllocation> entry) throws CacheWriterException {
        PropertyAllocationPK key = entry.getKey();
        PropertyAllocation value = entry.getValue();
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
