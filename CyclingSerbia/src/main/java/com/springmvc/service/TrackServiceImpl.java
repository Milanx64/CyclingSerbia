package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.TrackDao;
import com.springmvc.model.Track;

@Service("trackService")
@Transactional
public class TrackServiceImpl implements TrackService{
	
	@Autowired
	TrackDao dao;
	
	public List<Track> findAllTracks() {
		// TODO Auto-generated method stub
		return dao.findAllTracks();
	}

	public Track findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public List<Track> findAllTracksOnMountain(String mountain) {
		// TODO Auto-generated method stub
		return dao.findAllTracksOnMountain(mountain);
	}

}
