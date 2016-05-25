package edu.sjsu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Repository;

import edu.sjsu.util.MyCassandraTemplate;
import edu.sjsu.dao.CountryUserDao;
import edu.sjsu.entity.CountryUser;

@Repository
public class CountryUserDaoImpl implements CountryUserDao{
	
	@Autowired
	private MyCassandraTemplate myCassandraTemplate;
	
	//@Override
	public CountryUser getCountryUser(int id) {
	return myCassandraTemplate.findById(id, CountryUser.class);
	}

	public List<CountryUser> getAllCountryUser() {
		return myCassandraTemplate.findAll(CountryUser.class);
	}
	
}
