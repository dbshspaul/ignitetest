package com.jac.travels.cassendra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.List;

public class CassandraDataUtility {
    public List<Row> getRowList(String query) {
        try (CassandraConnector client = new CassandraConnector()) {
            client.connect();
            ResultSet resultSet = client.getSession().execute(query);
            return resultSet.all();
        }
    }
}
