package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User>  implements UserDao{

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("firstname")).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		List<User> users = (List<User>)crit.list();
		return users;
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		User user = getByKey(id);
		if(user != null) {
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", email));
		User user = (User) crit.uniqueResult();
		if(user != null) {
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		persist(user);
		
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		delete(user);
	}

}
