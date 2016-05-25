package edu.sjsu.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories("dao")
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints("localhost");
        cluster.setPort(9042);
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {
        return "CS286";
    }

    @Bean
    @Override
    public CassandraMappingContext cassandraMapping() throws  ClassNotFoundException {
         return new BasicCassandraMappingContext();
    }

}
