package com.jac.travels.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.ContinuousQuery;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.cache.annotation.CacheConfig;

import javax.cache.Cache;
import javax.cache.configuration.FactoryBuilder;

public class IgniteDemo {


    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        CacheConfiguration cfg = new CacheConfiguration();
        cfg.setName("myCache");
        cfg.setReadThrough(true);
        cfg.setWriteThrough(true);
        cfg.setCacheMode(CacheMode.PARTITIONED);
        cfg.setIndexedTypes(Integer.class, String.class);
        cfg.setCacheStoreFactory(FactoryBuilder.factoryOf(StoreDataInCache.class));
        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cfg);

        cache.put(10, "hello India");
    }
}
