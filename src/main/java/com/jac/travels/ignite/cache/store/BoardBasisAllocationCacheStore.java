package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.BoardBasisAllocationPK;
import com.jac.travels.kafka.ProducerUtil;
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
        logger.info(">>> Store load [key=" + boardBasisAllocationPK + ']');
        return queryBuilder.getDataById(BoardBasisAllocation.class, boardBasisAllocationPK);
    }

    @Override
    public void write(Cache.Entry<? extends BoardBasisAllocationPK, ? extends BoardBasisAllocation> entry) throws CacheWriterException {
        BoardBasisAllocationPK key = entry.getKey();
        BoardBasisAllocation value = entry.getValue();
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
