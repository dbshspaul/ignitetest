package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateSearchPK;
import com.jac.travels.model.RateSearch;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateSearchCacheStore extends CacheStoreAdapter<RateSearchPK, RateSearch> {
    Logger logger = LoggerFactory.getLogger(RateSearchCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateSearch load(RateSearchPK rateSearchPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends RateSearchPK, ? extends RateSearch> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
