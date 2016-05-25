package edu.sjsu.util;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.core.env.Environment;
	import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
	import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
	import org.springframework.data.cassandra.config.SchemaAction;
	import org.springframework.data.cassandra.convert.CassandraConverter;
	import org.springframework.data.cassandra.convert.MappingCassandraConverter;
	import org.springframework.data.cassandra.core.CassandraOperations;
	import org.springframework.data.cassandra.core.CassandraTemplate;
	import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
	import org.springframework.data.cassandra.mapping.CassandraMappingContext;

	/**
	* Utility class for getting the CassandraOperations object.
	* @author Ranga Reddy
	* @version 1.0
	*/

	@Configuration
	public class CassandraUtil {

	/**
	* Constant String for Keyspace
	*/
	private static final String KEYSPACE = "cs286";
	/**
	* Constant String for ContactPoints
	*/
	private static final String CONTACTPOINTS = "127.0.0.1";
	/**
	* Constant String for Port
	*/
	private static final String PORT = "9042";

	@Autowired
	private Environment environment;

	public CassandraUtil() {
	System.out.println("CassandraUtil()");
	}

	private String getKeyspaceName() {
	return environment.getProperty(KEYSPACE);
	}

	private String getContactPoints() {
	return environment
	.getProperty(CONTACTPOINTS);
	}

	private int getPortNumber() {
	return Integer.parseInt(environment
	.getProperty(PORT));
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
	CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
	cluster.setContactPoints("localhost");
	cluster.setPort(9042);
	return cluster;
	}

	@Bean
	public CassandraMappingContext mappingContext() {
	return new BasicCassandraMappingContext();
	}

	@Bean
	public CassandraConverter converter() {
	return new MappingCassandraConverter(mappingContext());
	}

	@Bean
	public CassandraSessionFactoryBean session() throws Exception {
	CassandraSessionFactoryBean cassandraSessionFactoryBean = new CassandraSessionFactoryBean();
	cassandraSessionFactoryBean.setCluster(cluster().getObject());
	cassandraSessionFactoryBean.setKeyspaceName("cs286");
	cassandraSessionFactoryBean.setConverter(converter());
	cassandraSessionFactoryBean.setSchemaAction(SchemaAction.NONE);
	return cassandraSessionFactoryBean;
	}

	@Bean
	public CassandraOperations cassandraTemplate() throws Exception {
	return new CassandraTemplate(session().getObject());
	} 
}
