package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Mountain;
import com.springmvc.model.Region;

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
		Session session = sessionFactory.getCurrentSession();
		Mountain mountainToDelete = (Mountain) session.byId(Mountain.class).load(mountain.getId());
		session.delete(mountainToDelete);
		/*delete(mountain) is throwing StackOverflowError code above is solving that exception but it generates org.hibernate.LazyInitializationException
		 * to solve that problem fetch = FetchType.EAGER, must be added to all OneToMany mappings involved with Mountain entity*/
		//delete(mountain);
		
	}

	@SuppressWarnings("unchecked")
	public List<Mountain> findByRegion(Region region) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("regionId", region.getId()));
		return (List<Mountain>) crit.list();
	}

}
