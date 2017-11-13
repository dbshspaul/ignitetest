package com.jac.travels.ignite;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.jac.travels.cassendra.CassandraConnector;
import com.jac.travels.kafka.ProducerUtil;
import com.jac.travels.model.Employee;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.util.List;

public class StoreDataInCache extends CacheStoreAdapter<Long, Employee> {

    Logger logger = LoggerFactory.getLogger(StoreDataInCache.class);

    @Override
    public Employee load(Long aLong) throws CacheLoaderException {
        logger.info(">>> Store load [key=" + aLong + ']');
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
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

        logger.info(">>> Store write [key=" + key + ", val=" + employee + ']');

        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
            logger.info("connection success with cassandra");
            ResultSet resultSet = client.getSession().execute("SELECT * FROM hr.emp WHERE id=" + employee.getId());
            if (resultSet.one() != null) {
                client.getSession().execute("insert into hr.emp(id, name, mobile) values(" + employee.getId() + ",'" + employee.getName() + "','" + employee.getMobile() + "')");
                logger.info("One row inserted successfully.");
            } else {
                client.getSession().execute("update hr.emp set name='" + employee.getName() + "', mobile='" + employee.getName() + "' where id=" + employee.getId());
                logger.info("Data updated successfully.");
            }
            ProducerUtil.sendMessage("kafkaCacheTopic", employee.toString());
        } catch (Exception e) {
            ProducerUtil.sendMessage("kafkaErrorTopic", employee.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void loadCache(IgniteBiInClosure<Long, Employee> clo, Object... args) {
        logger.info(">>> loading cache");
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
            logger.info("success");
            ResultSet resultSet = client.getSession().execute("SELECT id, name, mobile FROM hr.emp");
            List<Row> all = resultSet.all();
            all.stream().forEach(row -> {
                try {
                    Employee employee = new Employee(row.getLong("id"), row.getString("name"), row.getString("mobile"));
                    clo.apply(row.getLong("id"), employee);
                    ProducerUtil.sendMessage("kafkaCacheTopic", employee.toString());
                } catch (Exception e) {
                    ProducerUtil.sendMessage("kafkaErrorTopic", row.toString());
                    e.printStackTrace();
                }
            });
            logger.info("<<<Cache Successfully Loaded ");
        }
    }
}
