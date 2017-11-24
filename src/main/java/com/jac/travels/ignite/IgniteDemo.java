package com.jac.travels.ignite;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.model.Contract;
import com.jac.travels.model.Rate;
import com.jac.travels.model.Room;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;

import javax.annotation.PostConstruct;
import javax.cache.configuration.FactoryBuilder;

public class IgniteDemo {

    private IgniteCache<Integer, Room> roomCache;
    private IgniteCache<Integer, Contract> contractCache;
    private IgniteCache<LocalDate, Rate> rateCache;

    private IgniteDemo() {
        startCache();
    }

    private static final IgniteDemo instance = new IgniteDemo();

    public static IgniteDemo getInstance() {
        return instance;
    }


    @PostConstruct
    public void startCache() {
        Ignite ignite = Ignition.start();

        CacheConfiguration rateCacheConfig = new CacheConfiguration();
        rateCacheConfig.setName("myCache");
        rateCacheConfig.setReadThrough(true);
        rateCacheConfig.setWriteThrough(true);
        rateCacheConfig.setWriteBehindEnabled(true);
        rateCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        rateCacheConfig.setIndexedTypes(LocalDate.class, Rate.class);
        rateCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStoreForRate.class));
        rateCache = ignite.getOrCreateCache(rateCacheConfig);

        CacheConfiguration roomCacheConfig = new CacheConfiguration();
        roomCacheConfig.setName("myCache");
        roomCacheConfig.setReadThrough(true);
        roomCacheConfig.setWriteThrough(true);
        roomCacheConfig.setWriteBehindEnabled(true);
        roomCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        roomCacheConfig.setIndexedTypes(Integer.class, Room.class);
        roomCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStoreForRoom.class));
        roomCache = ignite.getOrCreateCache(roomCacheConfig);

        CacheConfiguration contractCacheConfig = new CacheConfiguration();
        contractCacheConfig.setName("myCache");
        contractCacheConfig.setReadThrough(true);
        contractCacheConfig.setWriteThrough(true);
        contractCacheConfig.setWriteBehindEnabled(true);
        contractCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        contractCacheConfig.setIndexedTypes(Integer.class, Contract.class);
        contractCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStroreForContract.class));
        contractCache = ignite.getOrCreateCache(contractCacheConfig);


    }

    public IgniteCache<Integer, Room> getRoomCache() {
        return roomCache;
    }

    public void setRoomCache(IgniteCache<Integer, Room> roomCache) {
        this.roomCache = roomCache;
    }

    public IgniteCache<Integer, Contract> getContractCache() {
        return contractCache;
    }

    public void setContractCache(IgniteCache<Integer, Contract> contractCache) {
        this.contractCache = contractCache;
    }

    public IgniteCache<LocalDate, Rate> getRateCache() {
        return rateCache;
    }

    public void setRateCache(IgniteCache<LocalDate, Rate> rateCache) {
        this.rateCache = rateCache;
    }

//    public static void main(String[] args) {
////        IgniteDemo.getInstance();
//    }
}
