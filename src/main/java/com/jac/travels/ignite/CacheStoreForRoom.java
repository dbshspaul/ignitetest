package com.jac.travels.ignite;

import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Room;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class CacheStoreForRoom extends CacheStoreAdapter<Integer, Room> {
    Logger logger = LoggerFactory.getLogger(CacheStoreForRoom.class);
    QueryBuilder queryBuilder = new QueryBuilder();


    @Override
    public Room load(Integer aLong) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + aLong + ']');
        return queryBuilder.getDataById(Room.class, "room_id", aLong);
    }

    @Override
    public void write(Cache.Entry<? extends Integer, ? extends Room> entry) throws CacheWriterException {
        Integer key = entry.getKey();
        Room room = entry.getValue();
        logger.info(">>> Store write [key=" + key + ", val=" + room + ']');
        queryBuilder.insertData(room, "room_id");
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void loadCache(IgniteBiInClosure<Integer, Room> clo, Object... args) {
        logger.info(">>> loading cache");
        queryBuilder.getAllData(Room.class).stream().forEach(room -> {
            try {
                clo.apply(room.getRoom_id(), room);
                ProducerUtil.sendMessage("kafkaCacheTopic", room.toString());
            } catch (Exception e) {
                ProducerUtil.sendMessage("kafkaErrorTopic", room.toString());
                e.printStackTrace();
            }
        });
    }
}
