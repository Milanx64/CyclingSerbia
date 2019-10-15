package com.springmvc.service;

import java.util.List;

import com.springmvc.model.User;

public interface UserService {
	
	User findUserByEmail(String email);
	
	User findUserById(int id);
	
	void deleteUser(User user);
	
	List<User> findAllUsers();
	
	void saveUser(User user);
	
	
	

}
