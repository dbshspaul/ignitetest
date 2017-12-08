package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateSupplementPK;
import com.jac.travels.model.RateSupplement;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateSupplementCacheStore extends CacheStoreAdapter<RateSupplementPK, RateSupplement> {
    Logger logger = LoggerFactory.getLogger(RateSupplementCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateSupplement load(RateSupplementPK rateSupplementPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends RateSupplementPK, ? extends RateSupplement> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
