package com.jac.travels.ignite.cache.store;

import com.jac.travels.model.Property;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class PropertyCacheStore extends CacheStoreAdapter<Integer, Property> {
    Logger logger = LoggerFactory.getLogger(PropertyCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();


    @Override
    public Property load(java.lang.Integer integer) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends java.lang.Integer, ? extends Property> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
