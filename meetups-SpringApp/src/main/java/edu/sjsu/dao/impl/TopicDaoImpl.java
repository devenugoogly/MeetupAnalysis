package edu.sjsu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Repository;

import edu.sjsu.util.MyCassandraTemplate;
import edu.sjsu.dao.TopicDao;
import edu.sjsu.entity.Topic;

@Repository
public class TopicDaoImpl implements TopicDao{
	
	@Autowired
	private MyCassandraTemplate myCassandraTemplate;
	
	//@Override
	public Topic getTopic(int id) {
	return myCassandraTemplate.findById(id, Topic.class);
	}
	
}
