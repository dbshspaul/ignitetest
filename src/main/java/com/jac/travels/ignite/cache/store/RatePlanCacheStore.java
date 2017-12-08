package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RatePlanPK;
import com.jac.travels.model.RatePlan;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RatePlanCacheStore extends CacheStoreAdapter<RatePlanPK, RatePlan> {
    Logger logger = LoggerFactory.getLogger(RatePlanCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RatePlan load(RatePlanPK ratePlanPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends RatePlanPK, ? extends RatePlan> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
