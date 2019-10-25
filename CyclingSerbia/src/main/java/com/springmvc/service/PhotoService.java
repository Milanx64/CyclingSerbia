package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Photo;

public interface PhotoService {
	
	List<Photo> findAllPhotos();
	
	List<Photo> findPhotoOfMountain(int id);
	
	List<Photo> find4Photos();
	
	void savePhoto(Photo photo);
	
	Photo findByUser(int user_id);
	
	Photo findById(int id);
	
	void deletePhoto(Photo p);
}
