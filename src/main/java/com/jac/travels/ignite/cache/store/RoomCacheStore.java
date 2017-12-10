package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.RoomPK;
import com.jac.travels.kafka.ProducerUtil;
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
        logger.info(">>> Store load [key=" + roomPK + ']');
        return queryBuilder.getDataById(Room.class, roomPK);
    }

    @Override
    public void write(Cache.Entry<? extends RoomPK, ? extends Room> entry) throws CacheWriterException {
        RoomPK key = entry.getKey();
        Room value = entry.getValue();
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
