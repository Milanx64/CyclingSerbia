package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Region;

public interface RegionDao {
	
	Region findById(int id);
	
	Region findByName(String name);
	
	List<Region> findAll();
	
	

}
