package edu.sjsu.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Topic {
	
	@PrimaryKey("topicId")
	private long topicId;

	@Column("topicName")
	private String topicName;

	@Column("categoryName")
	private String categoryName; 
	
	public Topic() {
		super();
		}
	

	public Topic(long topicId, String topicName, String categoryName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.categoryName = categoryName;
	}

	public long getTopicId() {
		return topicId;
	}


	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}


	public String getTopicName() {
		return topicName;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
