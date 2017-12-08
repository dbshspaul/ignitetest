package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.BoardBasisAllocationPK;
import com.jac.travels.model.BoardBasisAllocation;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class BoardBasisAllocationCacheStore extends CacheStoreAdapter<BoardBasisAllocationPK, BoardBasisAllocation> {
    Logger logger = LoggerFactory.getLogger(BoardBasisAllocationCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public BoardBasisAllocation load(BoardBasisAllocationPK boardBasisAllocationPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends BoardBasisAllocationPK, ? extends BoardBasisAllocation> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
