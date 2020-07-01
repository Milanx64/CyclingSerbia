package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Mountain;
import com.springmvc.model.Region;

public interface MountainDao {
	List<Mountain> findAll();
	
	Mountain findById(int id);
	
	List<Mountain> findByRegion(Region region);
	
	void saveMountain(Mountain mountain);
	
	void delete(Mountain mountan);
	
	
}
