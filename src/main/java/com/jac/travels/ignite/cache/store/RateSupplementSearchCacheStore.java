package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RateSupplementSearchPK;
import com.jac.travels.model.RateSupplementSearch;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RateSupplementSearchCacheStore extends CacheStoreAdapter<RateSupplementSearchPK, RateSupplementSearch> {
    Logger logger = LoggerFactory.getLogger(RateSupplementSearchCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RateSupplementSearch load(RateSupplementSearchPK rateSupplementSearchPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends RateSupplementSearchPK, ? extends RateSupplementSearch> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
