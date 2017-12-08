package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.ContractAllocationPK;
import com.jac.travels.model.ContractAllocation;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class ContractAllocationCacheStore extends CacheStoreAdapter<ContractAllocationPK, ContractAllocation> {
    Logger logger = LoggerFactory.getLogger(ContractAllocationCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public ContractAllocation load(ContractAllocationPK contractAllocationPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends ContractAllocationPK, ? extends ContractAllocation> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
