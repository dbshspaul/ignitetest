package com.jac.travels.ignite;

import com.jac.travels.idclass.ContractPK;
import com.jac.travels.idclass.RatePK;
import com.jac.travels.idclass.RoomPK;
import com.jac.travels.ignite.cache.store.*;
import com.jac.travels.model.Contract;
import com.jac.travels.model.Property;
import com.jac.travels.model.Rate;
import com.jac.travels.model.Room;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

import javax.cache.configuration.FactoryBuilder;
import java.util.Arrays;

public class IgniteDemo {

    private static IgniteCache<RoomPK, Room> roomCache;
    private static IgniteCache<ContractPK, Contract> contractCache;
    private static IgniteCache<RatePK, Rate> rateCache;
    private static IgniteCache<Integer, Property> propertyCache;

    public static void startCache() {
        Ignition.setClientMode(true);
        IgniteConfiguration cfg = new IgniteConfiguration();

        DataStorageConfiguration storageCfg = new DataStorageConfiguration();
        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
        cfg.setDataStorageConfiguration(storageCfg);

        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47502"));
        tcpDiscoverySpi.setIpFinder(ipFinder);
        cfg.setDiscoverySpi(tcpDiscoverySpi);

        Ignite ignite = Ignition.start(cfg);
        ignite.active(true);
//        Ignite ignite = Ignition.start();

        createCache(ignite, "boardBasisAllocationCacheStore", BoardBasisAllocationCacheStore.class);
        createCache(ignite, "boardBasisAllocationCacheStore", RateCacheStore.class);
        createCache(ignite, "contractAllocationCacheStore", ContractAllocationCacheStore.class);
        contractCache = createCache(ignite, "contractCacheStore", ContractCacheStore.class);
        createCache(ignite, "globalStopSellCacheStore", GlobalStopSellCacheStore.class);
        createCache(ignite, "propertyAllocationCacheStore", PropertyAllocationCacheStore.class);
        propertyCache = createCache(ignite, "propertyCacheStore", PropertyCacheStore.class);
        createCache(ignite, "rateBoardBasisUpgradeCacheStore", RateBoardBasisUpgradeCacheStore.class);
        rateCache = createCache(ignite, "roomCacheStore", RateCacheStore.class);
        createCache(ignite, "ratePlanAllocationCacheStore", RatePlanAllocationCacheStore.class);
        createCache(ignite, "ratePlanCacheStore", RatePlanCacheStore.class);
        createCache(ignite, "rateSearchCacheStore", RateSearchCacheStore.class);
        createCache(ignite, "rateSupplementCacheStore", RateSupplementCacheStore.class);
        createCache(ignite, "rateSupplementSearchCacheStore", RateSupplementSearchCacheStore.class);
        createCache(ignite, "roomAllocationCacheStore", RoomAllocationCacheStore.class);
        roomCache = createCache(ignite, "roomCacheStore", RoomCacheStore.class);
        createCache(ignite, "specialOfferCacheStore", SpecialOfferCacheStore.class);
        createCache(ignite, "specialOfferDiscountCacheStore", SpecialOfferDiscountCacheStore.class);
        createCache(ignite, "supplementCacheStore", SupplementCacheStore.class);

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

    public IgniteCache<RoomPK, Room> getRoomCache() {
        return roomCache;
    }

    public IgniteCache<ContractPK, Contract> getContractCache() {
        return contractCache;
    }

    public IgniteCache<RatePK, Rate> getRateCache() {
        return rateCache;
    }

    public IgniteCache<Integer, Property> getPropertyCache() {
        return propertyCache;
    }

    public static void main(String[] args) {
        startCache();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>working");
    }
}
