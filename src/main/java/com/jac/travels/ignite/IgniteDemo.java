package com.jac.travels.ignite;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.ignite.cache.store.*;
import com.jac.travels.model.Contract;
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

import javax.annotation.PostConstruct;
import javax.cache.configuration.FactoryBuilder;
import java.util.Arrays;

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

        CacheConfiguration rateCacheConfig = new CacheConfiguration();
        rateCacheConfig.setName("myCacheRate");
        rateCacheConfig.setReadThrough(true);
        rateCacheConfig.setWriteThrough(true);
        rateCacheConfig.setWriteBehindEnabled(true);
        rateCacheConfig.setBackups(1);
        rateCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        rateCacheConfig.setIndexedTypes(LocalDate.class, Rate.class);
        rateCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStoreForRate.class));
        rateCache = ignite.getOrCreateCache(rateCacheConfig);

        CacheConfiguration roomCacheConfig = new CacheConfiguration();
        roomCacheConfig.setName("myCacheRoom");
        roomCacheConfig.setReadThrough(true);
        roomCacheConfig.setWriteThrough(true);
        roomCacheConfig.setWriteBehindEnabled(true);
        roomCacheConfig.setBackups(1);
        roomCacheConfig.setCacheMode(CacheMode.PARTITIONED);
        roomCacheConfig.setIndexedTypes(Integer.class, Room.class);
        roomCacheConfig.setCacheStoreFactory(FactoryBuilder.factoryOf(CacheStoreForRoom.class));
        roomCache = ignite.getOrCreateCache(roomCacheConfig);

        contractCache=createCache(ignite,"myCacheContract",CacheStroreForContract.class);
        createCache(ignite,"boardBasisAllocationCacheStore",BoardBasisAllocationCacheStore.class);
        createCache(ignite,"boardBasisAllocationCacheStore",CacheStoreForRate.class);
        createCache(ignite,"contractAllocationCacheStore",ContractAllocationCacheStore.class);
        createCache(ignite,"contractCacheStore",ContractCacheStore.class);
        createCache(ignite,"globalStopSellCacheStore",GlobalStopSellCacheStore.class);
        createCache(ignite,"propertyAllocationCacheStore",PropertyAllocationCacheStore.class);
        createCache(ignite,"propertyCacheStore",PropertyCacheStore.class);
        createCache(ignite,"rateBoardBasisUpgradeCacheStore",RateBoardBasisUpgradeCacheStore.class);
        createCache(ignite,"ratePlanAllocationCacheStore",RatePlanAllocationCacheStore.class);
        createCache(ignite,"ratePlanCacheStore",RatePlanCacheStore.class);
        createCache(ignite,"rateSearchCacheStore",RateSearchCacheStore.class);
        createCache(ignite,"rateSupplementCacheStore",RateSupplementCacheStore.class);
        createCache(ignite,"rateSupplementSearchCacheStore",RateSupplementSearchCacheStore.class);
        createCache(ignite,"roomAllocationCacheStore",RoomAllocationCacheStore.class);
        createCache(ignite,"roomCacheStore",RoomCacheStore.class);
        createCache(ignite,"specialOfferCacheStore",SpecialOfferCacheStore.class);
        createCache(ignite,"specialOfferDiscountCacheStore",SpecialOfferDiscountCacheStore.class);
        createCache(ignite,"supplementCacheStore",SupplementCacheStore.class);

    }

    private IgniteCache createCache(Ignite ignite,String cacheName,Class clazz) {
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

    public static void main(String[] args) {
        IgniteDemo.getInstance();
    }
}
