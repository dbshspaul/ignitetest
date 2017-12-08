package com.jac.travels.ignite.cache.store;

import com.jac.travels.model.SpecialOffer;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class SpecialOfferCacheStore extends CacheStoreAdapter<Integer, SpecialOffer> {
    Logger logger = LoggerFactory.getLogger(SpecialOfferCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public SpecialOffer load(Integer integer) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends Integer, ? extends SpecialOffer> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
