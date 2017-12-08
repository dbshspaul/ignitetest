package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.ContractPK;
import com.jac.travels.model.Contract;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class ContractCacheStore extends CacheStoreAdapter<ContractPK, Contract> {
    Logger logger = LoggerFactory.getLogger(ContractCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Contract load(ContractPK contractPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends ContractPK, ? extends Contract> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
