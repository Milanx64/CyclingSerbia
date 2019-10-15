package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserProfileDao;
import com.springmvc.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao dao;
	public List<UserProfile> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public UserProfile findByType(String type) {
		// TODO Auto-generated method stub
		return dao.findByType(type);
	}

	public UserProfile findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	public UserProfile findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
