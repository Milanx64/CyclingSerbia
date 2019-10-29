package com.springmvc.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Mountain;
import com.springmvc.model.Photo;

@Repository("photoDao")
public class PhotoDaoImpl extends AbstractDao<Integer, Photo>  implements PhotoDao{

	@SuppressWarnings("unchecked")
	public List<Photo> findAllPhotos() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		 List<Photo> photos = crit.list();
		 for(Photo photo: photos) {
			 byte[] imageBytes = photo.getContent();
		 }
		 
		 return photos;
	}

	public Photo findByUser(int user_id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("user_id", user_id));
		crit.uniqueResult();
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return (Photo) crit;
	}

	public Photo findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	public void deletePhoto(Photo photo) {
		// TODO Auto-generated method stub
		delete(photo);
	}

	public void savePhoto(Photo photo) {
		// TODO Auto-generated method stub
		persist(photo);
	}

	@SuppressWarnings("unchecked")
	public List<Photo> findPhotoOfMountain(Mountain m) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("mountain", m));
		return (List<Photo>)crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Photo> find4Mountains() {
		Criteria crit = createEntityCriteria();
		crit.addQueryHint("SELECT * FROM photos LIMIT 4");
		return (List<Photo>)crit.list();
	}

}
