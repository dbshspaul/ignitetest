package com.jac.travels.ignite;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.jac.travels.cassendra.CassandraConnector;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Employee;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.cache.store.CacheStoreSession;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.apache.ignite.resources.CacheStoreSessionResource;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.util.List;

public class StoreDataInCache extends CacheStoreAdapter<Long, Employee> {
    /**
     * Store session.
     */
    @CacheStoreSessionResource
    private CacheStoreSession ses;
    final String ipAddress = "localhost";
    final int port = 9042;

    @Override
    public Employee load(Long aLong) throws CacheLoaderException {
        System.out.println(">>> Store load [key=" + aLong + ']');
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect(ipAddress, port);
            System.out.println("success");
            ResultSet resultSet = client.getSession().execute("SELECT id, name, mobile FROM hr.emp WHERE id=" + aLong);
            List<Row> rows = resultSet.all();
            if (rows.size() > 0) {
                Row row = rows.get(0);
                return new Employee(row.getLong("id"), row.getString("name"), row.getString("mobile"));
            }
        }
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends Long, ? extends Employee> entry) throws CacheWriterException {

        Long key = entry.getKey();
        Employee employee = entry.getValue();

        System.out.println(">>> Store write [key=" + key + ", val=" + employee + ']');

        try (CassandraConnector client = new CassandraConnector()) {
            client.connect(ipAddress, port);
            System.out.println("connection success with cassandra");
            ProducerUtil.sendMessage("kafkaCacheTopic",employee.toString());
            client.getSession().execute("insert into hr.emp(id, name, mobile) values(" + employee.getId() + ",'" + employee.getName() + "','" + employee.getMobile() + "');");
            System.out.println("One row inserted successfully.");
        }catch (Exception e){
            ProducerUtil.sendMessage("kafkaErrorTopic",employee.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void loadCache(IgniteBiInClosure<Long, Employee> clo, Object... args) {
        System.out.println(">>> loading cache");
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect(ipAddress, port);
            System.out.println("success");
            ResultSet resultSet = client.getSession().execute("SELECT id, name, mobile FROM hr.emp");
            List<Row> all = resultSet.all();
            all.stream().forEach(row -> {
                try {
                    clo.apply(row.getLong("id"), new Employee(row.getLong("id"), row.getString("name"), row.getString("mobile")));
                } catch (Exception e) {
                    ProducerUtil.sendMessage("kafkaErrorTopic",row.toString());
                    e.printStackTrace();
                }
            });
            System.out.println(">>>Cache Loaded ");
        }
    }
}
