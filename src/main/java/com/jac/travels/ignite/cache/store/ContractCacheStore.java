package com.jac.travels.ignite.cache.store;

import com.jac.travels.idclass.ContractPK;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Contract;
import com.jac.travels.model.Property;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.lang.reflect.InvocationTargetException;

public class ContractCacheStore extends CacheStoreAdapter<ContractPK, Contract> {
    Logger logger = LoggerFactory.getLogger(ContractCacheStore.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Contract load(ContractPK contractPK) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + contractPK + ']');
        return queryBuilder.getDataById(Contract.class, contractPK);
    }

    @Override
    public void write(Cache.Entry<? extends ContractPK, ? extends Contract> entry) throws CacheWriterException {
        ContractPK key = entry.getKey();
        Contract value = entry.getValue();
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
        try {
            queryBuilder.delete(o,Contract.class);
            logger.info("<<< Contract Successfully deleted.");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
