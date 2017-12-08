package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RoomPK;
import com.jac.travels.model.Room;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RoomCacheStore extends CacheStoreAdapter<RoomPK, Room> {
    Logger logger = LoggerFactory.getLogger(RoomCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Room load(RoomPK roomPK) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends RoomPK, ? extends Room> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
