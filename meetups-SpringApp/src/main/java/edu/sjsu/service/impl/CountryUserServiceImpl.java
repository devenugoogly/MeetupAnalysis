package edu.sjsu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.sjsu.service.CountryUserService;
import edu.sjsu.dao.CountryUserDao;
import edu.sjsu.dao.TopicDao;
import edu.sjsu.entity.CountryUser;
import edu.sjsu.entity.Topic;

@Service
public class CountryUserServiceImpl implements CountryUserService {

	@Autowired
	private CountryUserDao countryUserDao;

	public CountryUserServiceImpl() {
		super();
	}

	//@Override
	public CountryUser getCountryUser(int id) {
		return countryUserDao.getCountryUser(id);
	}

	public List<CountryUser> getAllCountryUser() {
		return countryUserDao.getAllCountryUser();
	}
}
