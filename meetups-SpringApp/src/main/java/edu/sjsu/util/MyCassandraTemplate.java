package edu.sjsu.util;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class MyCassandraTemplate {
	
	
	@Autowired
	 private CassandraOperations cassandraTemplate; 
	 
	public MyCassandraTemplate() {
		System.out.println("MyCassandraTemplate()");
		} 
	 
	 
	 public <T> T findById(Object id, Class<T> claz) {
		 return cassandraTemplate.selectOneById(claz, id);
		 } 
	 
	 public <T> List<T> findAll(Class<T> claz) {
	  return (List<T>) cassandraTemplate.selectAll(claz);
	 }

	 public <T> List<T> findAll(List<Object> ids, Class<T> claz) {
	  return cassandraTemplate.selectBySimpleIds(claz, ids);
	 }
}
