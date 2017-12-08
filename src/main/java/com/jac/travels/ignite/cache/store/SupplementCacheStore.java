package com.jac.travels.ignite.cache.store;

import com.jac.travels.model.Supplement;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class SupplementCacheStore extends CacheStoreAdapter<Integer, Supplement> {
    Logger logger = LoggerFactory.getLogger(SupplementCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Supplement load(Integer integer) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends Integer, ? extends Supplement> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
