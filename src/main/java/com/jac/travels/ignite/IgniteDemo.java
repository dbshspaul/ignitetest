package com.jac.travels.ignite;

import com.jac.travels.model.Employee;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.transactions.Transaction;

import javax.cache.configuration.FactoryBuilder;
import java.util.UUID;

public class IgniteDemo {

    private static final Long id = Math.abs(UUID.randomUUID().getLeastSignificantBits());


    public static void main(String[] args) {
        Ignite ignite = Ignition.start();
        CacheConfiguration cfg = new CacheConfiguration();
        cfg.setName("myCache");
        cfg.setReadThrough(true);
        cfg.setWriteThrough(true);
        cfg.setCacheMode(CacheMode.PARTITIONED);
        cfg.setIndexedTypes(Long.class, Employee.class);
        cfg.setCacheStoreFactory(FactoryBuilder.factoryOf(StoreDataInCache.class));
        IgniteCache<Long, Employee> cache = ignite.getOrCreateCache(cfg);

        //cache.put(10, "hello India");

        cache.loadCache(null);
        executeTransaction(cache);
        // Execute query on cache.
//        QueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery(
//                "select id, name from Person"));
//        System.out.println(cursor.getAll());
    }


    private static void executeTransaction(IgniteCache<Long, Employee> cache) {
        try (Transaction tx = Ignition.ignite().transactions().txStart()) {
            Employee val = cache.get(id);

            System.out.println("Read value: " + val);

            val = cache.getAndPut(id, new Employee(id, "Isaac", "12345965"));

            System.out.println("Overwrote old value: " + val);

            val = cache.get(id);

            System.out.println("Read value: " + val);

            tx.commit();
        }

        System.out.println("Read value after commit: " + cache.get(id));

        // Clear entry from memory, but keep it in store.
        cache.clear(id);

        // Operations on this cache will not affect store.
        IgniteCache<Long, Employee> cacheSkipStore = cache.withSkipStore();

        System.out.println("Read value skipping store (expecting null): " + cacheSkipStore.get(id));

        System.out.println("Read value with store lookup (expecting NOT null): " + cache.get(id));

        // Expecting not null, since entry should be in memory since last call.
        System.out.println("Read value skipping store (expecting NOT null): " + cacheSkipStore.get(id));
    }
}
