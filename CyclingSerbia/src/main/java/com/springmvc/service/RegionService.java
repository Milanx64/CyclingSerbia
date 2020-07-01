package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Region;

public interface RegionService {
	
	Region findById(int id);
	
	Region findByName(String name);
	
	List<Region> findAll();

}
