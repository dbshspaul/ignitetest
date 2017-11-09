package com.jac.travels.cassendra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CassandraDataUtility {
    public static void main(String[] args) {
        final CassandraConnector client = new CassandraConnector();
        final String ipAddress = "localhost";
        final int port = 9042;
        System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        client.connect(ipAddress, port);
        System.out.println("success");
//        ResultSet resultSet = client.getSession().execute(" insert into hr.emp (empid, name) values(2,'Sumit')");
        Map<String, String> datMap = new HashMap<>();
        ResultSet resultSet = client.getSession().execute("select name from hr.emp where empid=?",datMap);
        List<Row> all = resultSet.all();
        all.stream().forEach(System.out::println);
        client.close();
    }

    public List<Row> getRowList(String query){
        try(CassandraConnector client = new CassandraConnector()) {
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
