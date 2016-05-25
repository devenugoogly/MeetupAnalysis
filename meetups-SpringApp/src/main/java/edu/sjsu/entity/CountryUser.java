package edu.sjsu.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class CountryUser {
	
	@PrimaryKey("countryId")
	private long countryId;

	@Column("country")
	private String country;

	@Column("userCount")
	private int userCount; 
	
	public CountryUser() {
		super();
		}
	

	public CountryUser(long countryId, String country, int userCount) {
		super();
		this.countryId = countryId;
		this.country = country;
		this.userCount = userCount;
	}

	public long getCountryId() {
		return countryId;
	}


	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getUserCount() {
		return userCount;
	}


	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

}
