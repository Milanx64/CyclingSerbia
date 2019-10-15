package com.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_profile")
public class UserProfile implements Serializable{
	@Id @GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type", nullable = false, unique = true, length = 100)
	private String type = UserProfileType.USER.getUserProfileType();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
