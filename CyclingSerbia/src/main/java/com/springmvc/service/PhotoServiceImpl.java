package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.PhotoDao;
import com.springmvc.model.Photo;

@Service("photoService")
@Transactional
public class PhotoServiceImpl implements PhotoService{
	@Autowired
	PhotoDao dao;

	public List<Photo> findAllPhotos() {
		// TODO Auto-generated method stub
		return dao.findAllPhotos();
	}

	public List<Photo> findPhotoOfMountain(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo findByUser(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Photo findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public List<Photo> find4Photos() {
		// TODO Auto-generated method stub
		return dao.find4Mountains();
	}

	public void savePhoto(Photo photo) {
		// TODO Auto-generated method stub
		dao.savePhoto(photo);
	}

	public void deletePhoto(Photo p) {
		// TODO Auto-generated method stub
		dao.deletePhoto(p);
	}
}
