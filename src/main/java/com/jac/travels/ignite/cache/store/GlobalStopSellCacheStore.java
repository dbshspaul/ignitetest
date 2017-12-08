package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.GlobalStopSellPK;
import com.jac.travels.model.GlobalStopSell;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class GlobalStopSellCacheStore extends CacheStoreAdapter<GlobalStopSellPK, GlobalStopSell> {
    Logger logger = LoggerFactory.getLogger(GlobalStopSellCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public GlobalStopSell load(GlobalStopSellPK globalStopSellPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends GlobalStopSellPK, ? extends GlobalStopSell> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
