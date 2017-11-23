package com.jac.travels.spring.configuration;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = {"classpath:META-INF/cassandra.properties"})
@EnableCassandraRepositories("com.jac.travels.spring.repositories")
public class AppConfiguration extends AbstractCassandraConfiguration {
    @Autowired
    private Environment environment;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    @Override
    protected String getKeyspaceName() {
        return environment.getProperty("cassandra.keyspace");
    }

    @Override
    protected AuthProvider getAuthProvider() {
        AuthProvider provider = new PlainTextAuthProvider(environment.getProperty("cassandra.username"), environment.getProperty("cassandra.password"));
        return provider;
    }

    @Override
    protected String getContactPoints() {
        return environment.getProperty("cassandra.contactpoints");
    }

    @Override
    protected int getPort() {
        return Integer.parseInt(environment.getProperty("cassandra.port"));
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.jac.travels.model"};
    }
}
