package com.springmvc.service;

import java.util.List;

import com.springmvc.model.UserProfile;

public interface UserProfileService {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findByUsername(String username);
	
	UserProfile findById(int id);
}
