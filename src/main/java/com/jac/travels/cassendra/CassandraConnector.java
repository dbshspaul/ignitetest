package com.jac.travels.cassendra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.out;

public class CassandraConnector implements AutoCloseable {
    Logger logger = LoggerFactory.getLogger(CassandraConnector.class);

    /**
     * Cassandra Cluster.
     */
    private Cluster cluster;
    /**
     * Cassandra Session.
     */
    private Session session;

    private final String node = "52.54.0.20";
//    private final String node = "localhost";
    private final int port = 9042;
    private final String username = "meyvn";
//    private final String username = "";
    private final String password = "meyvn01";
//    private final String password = "";


    public void connect() {
        this.cluster = Cluster.builder().addContactPoint(node).withPort(port).withCredentials(username,password).build();
        final Metadata metadata = cluster.getMetadata();
        logger.info("Connected to cluster: "+ metadata.getClusterName());
        for (final Host host : metadata.getAllHosts()) {
            logger.info("Datacenter: "+host.getDatacenter()+"; Host: "+host.getAddress()+"; Rack: "+host.getRack());
        }
        session = cluster.connect();
        logger.info("Connection successful.");
    }

    /**
     * Provide my Session.
     *
     * @return My session.
     */
    public Session getSession() {
        return this.session;
    }

    /**
     * Close cluster.
     */
    @Override
    public void close() {
        if (cluster!=null) {
            cluster.close();
        }
    }

}
