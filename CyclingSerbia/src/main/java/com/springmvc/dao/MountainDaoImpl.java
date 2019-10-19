package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Mountain;

@Repository("mountainDao")
public class MountainDaoImpl extends AbstractDao<Integer, Mountain> implements MountainDao{

	@SuppressWarnings("unchecked")
	public List<Mountain> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		return (List<Mountain>) crit.list();
	}

	public Mountain findById(int id) {
		Mountain mountain = getByKey(id);
		return mountain;
	}

	public void saveMountain(Mountain mountain) {
		persist(mountain);
		
	}

	public void delete(Mountain mountain) {
		delete(mountain);
		
	}

}
