package edu.sjsu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.sjsu.service.TopicService;
import edu.sjsu.dao.TopicDao;
import edu.sjsu.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicDao topicDao;

	public TopicServiceImpl() {
		super();
	}

	//@Override
	public Topic getTopic(int id) {
		return topicDao.getTopic(id);
	}
}
