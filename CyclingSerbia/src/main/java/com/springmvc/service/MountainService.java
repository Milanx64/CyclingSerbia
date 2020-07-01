package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Mountain;
import com.springmvc.model.Region;

public interface MountainService {
	List<Mountain> findAll();
	
	Mountain findById(int id);
	
	List<Mountain> findByRegion(Region region);
	
	void save(Mountain mountain);
	
	void delete(Mountain mountain);
	
	void updateMountain(Mountain mountain);
}
