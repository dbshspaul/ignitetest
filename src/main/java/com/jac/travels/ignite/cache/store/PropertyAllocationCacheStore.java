package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.PropertyAllocationPK;
import com.jac.travels.model.PropertyAllocation;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class PropertyAllocationCacheStore extends CacheStoreAdapter<PropertyAllocationPK, PropertyAllocation>  {
    Logger logger = LoggerFactory.getLogger(PropertyAllocationCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();


    @Override
    public PropertyAllocation load(PropertyAllocationPK propertyAllocationPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends PropertyAllocationPK, ? extends PropertyAllocation> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
