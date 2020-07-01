package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Region;

@Repository("regionDao")
public class RegionDaoImpl extends AbstractDao<Integer, Region> implements RegionDao {

	public Region findById(int id) {
		return getByKey(id);
	}

	public Region findByName(String name) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Region region = (Region)crit.uniqueResult();
		return region ;
	}

	@SuppressWarnings("unchecked")
	public List<Region> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("id"));
		return (List<Region>) crit.list();
	}

}
