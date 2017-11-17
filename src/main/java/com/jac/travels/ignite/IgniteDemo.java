package com.jac.travels.ignite;

import com.jac.travels.model.Contract;
import com.jac.travels.model.Room;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;

import javax.cache.configuration.FactoryBuilder;
import java.util.UUID;

public class IgniteDemo {


    public static void main(String[] args) {
        Ignite ignite = Ignition.start();

        CacheConfiguration roomCacheConfig = new CacheConfiguration();
        roomCacheConfig.setName("myCache");
        roomCacheConfig.setReadThrough(true);
        roomCacheConfig.setWriteThrough(true);
        roomCacheConfig.setWriteBehindEnabled(true);
        roomCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        roomCacheConfig.setIndexedTypes(Integer.class, Room.class);
        roomCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStoreForRoom.class));
        IgniteCache<Integer, Room> roomCache = ignite.getOrCreateCache(roomCacheConfig);

        CacheConfiguration contractCacheConfig = new CacheConfiguration();
        contractCacheConfig.setName("myCache");
        contractCacheConfig.setReadThrough(true);
        contractCacheConfig.setWriteThrough(true);
        contractCacheConfig.setWriteBehindEnabled(true);
        contractCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        contractCacheConfig.setIndexedTypes(Integer.class, Contract.class);
        contractCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStroreForContract.class));
        IgniteCache<Integer, Contract> contractCache = ignite.getOrCreateCache(contractCacheConfig);

        //roomCache.put(10, "hello India");

        contractCache.loadCache(null);

    }
}
