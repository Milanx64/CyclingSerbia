package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Mountain;

public interface MountainDao {
	List<Mountain> findAll();
	
	Mountain findById(int id);
	
	void saveMountain(Mountain mountain);
	
	void delete(Mountain mountan);
	
	
}
