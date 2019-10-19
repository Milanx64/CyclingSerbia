package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.MountainDao;
import com.springmvc.model.Mountain;

@Service("mountainService")
@Transactional
public class MountainServiceImpl implements MountainService{
	
	@Autowired
	MountainDao dao;

	public List<Mountain> findAll() {
		// TODO Auto-generated method stub
		return (List<Mountain>) dao.findAll();
	}

	public Mountain findById(int id) {
		// TODO Auto-generated method stub
		return (Mountain) dao.findById(id);
	}

	public void save(Mountain mountain) {
		// TODO Auto-generated method stub
		dao.saveMountain(mountain);
	}

	public void delete(Mountain mountain) {
		// TODO Auto-generated method stub
		dao.delete(mountain);
	}
}
