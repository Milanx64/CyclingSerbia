package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.User;

public interface UserDao {
	
	List<User> findAllUsers();
	
	User findById(int id);
	
	User findByEmail(String email);
	
	void updateUser(User user);
	
	void saveUser(User user);
	
	void deleteUser(User user);
	
	
}
