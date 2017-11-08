package com.jac.travels.ignite;

import com.jac.travels.kafka.ProducerUtil;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.jetbrains.annotations.Nullable;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class StoreDataInCache extends CacheStoreAdapter<Long, String> {

    @Override
    public String load(Long aLong) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends Long, ? extends String> entry) throws CacheWriterException {
        System.out.println("StoreDataInCache.write");
        ProducerUtil.sendMessage("cacheDataTopic", entry.toString());
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }
}
