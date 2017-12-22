package com.jac.travels.ignite;

import com.jac.travels.idclass.*;
import com.jac.travels.ignite.cache.store.*;
import com.jac.travels.model.*;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;

import javax.cache.configuration.FactoryBuilder;

public class IgniteClientNode {

    private IgniteCache<RoomPK, Room> roomCache;
    private IgniteCache<ContractPK, Contract> contractCache;
    private IgniteCache<RatePK, Rate> rateCache;
    private IgniteCache<PropertyPK, Property> propertyCache;
    private IgniteCache<RatePlanPK, RatePlan> ratePlanIgniteCache;
    private IgniteCache<RatePlanAllocationPK, RatePlanAllocation> ratePlanAllocationIgniteCache;

    public void startCache() {
//        Ignition.setClientMode(true);
//        IgniteConfiguration cfg = new IgniteConfiguration();
//
//        DataStorageConfiguration storageCfg = new DataStorageConfiguration();
//        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
//        cfg.setDataStorageConfiguration(storageCfg);
//
//        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
//        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
//        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47502"));
//        tcpDiscoverySpi.setIpFinder(ipFinder);
//        cfg.setDiscoverySpi(tcpDiscoverySpi);
//
//        Ignite ignite = Ignition.start(cfg);
//        ignite.active(true);
        Ignite ignite = Ignition.start();

        rateCache = createCache(ignite, "boardBasisAllocationCacheStore", RateCacheStore.class);
        contractCache = createCache(ignite, "contractCacheStore", ContractCacheStore.class);
        propertyCache = createCache(ignite, "propertyCacheStore", PropertyCacheStore.class);
        roomCache = createCache(ignite, "roomCacheStore", RoomCacheStore.class);
        ratePlanIgniteCache = createCache(ignite, "ratePlanCacheStore", RatePlanCacheStore.class);
        ratePlanAllocationIgniteCache = createCache(ignite, "ratePlanAllocationCacheStore", RatePlanAllocationCacheStore.class);

    }

    private static IgniteCache createCache(Ignite ignite, String cacheName, Class clazz) {
        CacheConfiguration contractCacheConfig = new CacheConfiguration();
        contractCacheConfig.setName(cacheName);
        contractCacheConfig.setReadThrough(true);
        contractCacheConfig.setWriteThrough(true);
        contractCacheConfig.setWriteBehindEnabled(true);
        contractCacheConfig.setBackups(1);
        contractCacheConfig.setCacheMode(CacheMode.PARTITIONED);
//        contractCacheConfig.setIndexedTypes(Integer.class, Contract.class);
        contractCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(clazz));
        return ignite.getOrCreateCache(contractCacheConfig);
    }

    public IgniteCache<RatePlanPK, RatePlan> getRatePlanIgniteCache() {
        return ratePlanIgniteCache;
    }

    public IgniteCache<RoomPK, Room> getRoomCache() {
        return roomCache;
    }

    public IgniteCache<ContractPK, Contract> getContractCache() {
        return contractCache;
    }

    public IgniteCache<RatePK, Rate> getRateCache() {
        return rateCache;
    }

    public IgniteCache<PropertyPK, Property> getPropertyCache() {
        return propertyCache;
    }

    public IgniteCache<RatePlanAllocationPK, RatePlanAllocation> getRatePlanAllocationIgniteCache() {
        return ratePlanAllocationIgniteCache;
    }
}
