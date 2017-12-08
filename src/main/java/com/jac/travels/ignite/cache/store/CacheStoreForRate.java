package com.jac.travels.ignite.cache.store;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.RatePK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Rate;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class CacheStoreForRate extends CacheStoreAdapter<RatePK, Rate> {
    Logger logger = LoggerFactory.getLogger(CacheStoreForRate.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Rate load(RatePK ratePK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends RatePK, ? extends Rate> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
