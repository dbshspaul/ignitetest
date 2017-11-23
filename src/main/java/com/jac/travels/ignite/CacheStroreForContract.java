package com.jac.travels.ignite;

import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Contract;
import com.jac.travels.utility.QueryBuilder;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class CacheStroreForContract extends CacheStoreAdapter<Integer, Contract> {
    Logger logger = LoggerFactory.getLogger(CacheStoreForRoom.class);
    QueryBuilder queryBuilder = new QueryBuilder();

    @Override
    public Contract load(Integer integer) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + integer + ']');
        return queryBuilder.getDataById(Contract.class, "contract_id", integer);
    }

    @Override
    public void write(Cache.Entry<? extends Integer, ? extends Contract> entry) throws CacheWriterException {
        Integer key = entry.getKey();
        Contract contract = entry.getValue();
        logger.info(">>> Store write [key=" + key + ", val=" + contract + ']');
        queryBuilder.insertData(contract, "contract_id");
        ProducerUtil.sendMessage("kafkaCacheTopic", contract.toString());
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void loadCache(IgniteBiInClosure<Integer, Contract> clo, Object... args) {
        logger.info(">>> loading cache");
        queryBuilder.getAllData(Contract.class).stream().forEach(contract -> {
            try {
                clo.apply(contract.getContract_id(), contract);
            } catch (Exception e) {
                ProducerUtil.sendMessage("kafkaErrorTopic", contract.toString());
                e.printStackTrace();
            }
        });
    }
}
