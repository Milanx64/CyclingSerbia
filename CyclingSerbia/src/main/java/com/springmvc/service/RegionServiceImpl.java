package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.RegionDao;
import com.springmvc.model.Region;

@Service("regionService")
@Transactional
public class RegionServiceImpl implements RegionService{
	
	@Autowired
	RegionDao dao;
	
	public Region findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public Region findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
