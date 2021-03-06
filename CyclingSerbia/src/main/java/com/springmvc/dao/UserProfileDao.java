package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.UserProfile;

public interface UserProfileDao {
	
	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByUsername(String username);
	
	UserProfile findById(int id);
}
