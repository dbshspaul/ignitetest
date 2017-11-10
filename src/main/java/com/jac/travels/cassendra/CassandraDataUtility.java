package com.jac.travels.cassendra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.List;

public class CassandraDataUtility {
    public List<Row> getRowList(String query) {
        try (CassandraConnector client = new CassandraConnector()) {
            final String ipAddress = "localhost";
            final int port = 9042;
            System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
            client.connect(ipAddress, port);
            System.out.println("success");
            ResultSet resultSet = client.getSession().execute(query);
            return resultSet.all();
        }
    }
}
