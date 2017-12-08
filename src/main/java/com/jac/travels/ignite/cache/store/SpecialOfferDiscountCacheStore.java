package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.SpecialOfferDiscountPK;
import com.jac.travels.model.SpecialOfferDiscount;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class SpecialOfferDiscountCacheStore extends CacheStoreAdapter<SpecialOfferDiscountPK, SpecialOfferDiscount> {
    Logger logger = LoggerFactory.getLogger(SpecialOfferDiscountCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public SpecialOfferDiscount load(SpecialOfferDiscountPK specialOfferDiscountPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends SpecialOfferDiscountPK, ? extends SpecialOfferDiscount> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
