package com.springmvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDao;
import com.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
    
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = dao.findByEmail(email);
		return user;
	}

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.saveUser(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		dao.deleteUser(user);
	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAllUsers();
	}

}
