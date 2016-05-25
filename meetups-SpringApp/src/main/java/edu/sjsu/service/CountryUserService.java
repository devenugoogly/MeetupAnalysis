package edu.sjsu.service;

import java.util.List;

import edu.sjsu.entity.CountryUser;

public interface CountryUserService {
	
	 public CountryUser getCountryUser(int id);
	 
	 public List<CountryUser> getAllCountryUser();

}
