package edu.sjsu.dao;

import edu.sjsu.entity.Topic;

	
	public interface TopicDao{

	   // @Query("select * from Topic where topicName = ?0")
	    public  Topic getTopic(int id);

	}

