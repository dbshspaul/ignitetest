package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RoomAllocationPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.RoomAllocation;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class RoomAllocationCacheStore extends CacheStoreAdapter<RoomAllocationPK, RoomAllocation> {
    Logger logger = LoggerFactory.getLogger(RoomAllocationCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public RoomAllocation load(RoomAllocationPK roomAllocationPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + roomAllocationPK + ']');
        return queryBuilder.getDataById(RoomAllocation.class, roomAllocationPK);
    }

    @Override
    public void write(Cache.Entry<? extends RoomAllocationPK, ? extends RoomAllocation> entry) throws CacheWriterException {
        RoomAllocationPK key = entry.getKey();
        RoomAllocation value = entry.getValue();
        try {
            logger.info(">>> Store write [key=" + key + ", val=" + value + ']');
            queryBuilder.insertData(value);
            ProducerUtil.sendMessage("kafkaCacheTopic", value.toString());
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", value.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
