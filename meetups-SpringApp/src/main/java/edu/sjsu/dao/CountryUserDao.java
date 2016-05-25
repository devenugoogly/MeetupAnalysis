package edu.sjsu.dao;

import java.util.List;

import edu.sjsu.entity.CountryUser;

	
	public interface CountryUserDao{

	   // @Query("select * from Topic where topicName = ?0")
	    public  CountryUser getCountryUser(int id);
	    
	    public List<CountryUser> getAllCountryUser();

	}

