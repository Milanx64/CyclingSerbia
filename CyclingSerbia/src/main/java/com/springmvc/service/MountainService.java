package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Mountain;

public interface MountainService {
	List<Mountain> findAll();
	
	Mountain findById(int id);
	
	void save(Mountain mountain);
	
	void delete(Mountain mountain);
}
