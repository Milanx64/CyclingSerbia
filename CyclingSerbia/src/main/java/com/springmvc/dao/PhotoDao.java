package com.springmvc.dao;



import java.util.List;

import com.springmvc.model.Mountain;
import com.springmvc.model.Photo;

public interface PhotoDao {
	
	List<Photo> findAllPhotos() ;
	
	List<Photo> findPhotoOfMountain(Mountain m);
	
	List<Photo> find4Mountains();
	
	Photo findByUser(int user_id);
	
	Photo findById(int id);
	
	void deletePhoto(Photo photo);
	
	void savePhoto(Photo photo);
}
