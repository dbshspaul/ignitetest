package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.PropertyPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Property;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.lang.reflect.InvocationTargetException;

public class PropertyCacheStore extends CacheStoreAdapter<PropertyPK, Property> {
    Logger logger = LoggerFactory.getLogger(PropertyCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();


    @Override
    public Property load(PropertyPK integer) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + integer + ']');
        return queryBuilder.getDataById(Property.class, integer);
    }

    @Override
    public void write(Cache.Entry<? extends PropertyPK, ? extends Property> entry) throws CacheWriterException {
        PropertyPK key = entry.getKey();
        Property value = entry.getValue();
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
        try {
            queryBuilder.delete(o,Property.class);
            logger.info("<<< Successfully deleted.");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
