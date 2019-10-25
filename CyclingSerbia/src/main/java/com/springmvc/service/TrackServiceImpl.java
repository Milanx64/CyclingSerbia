package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.TrackDao;
import com.springmvc.model.Mountain;
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

	public List<Track> findAllTracksOnMountain(Mountain mountain) {
		// TODO Auto-generated method stub
		return dao.findAllTracksOnMountain(mountain);
	}

	public void saveTrack(Track track) {
		// TODO Auto-generated method stub
		dao.saveTrack(track);
	}

	public void updateTrack(Track track) {
		// TODO Auto-generated method stub
		Track t = dao.findById(track.getId());
		if(t != null) {
			t.setName(track.getName());
			t.setDescription(track.getDescription());
			t.setDifficulty(track.getDifficulty());
			t.setCost(track.getCost());
			t.setDuration(track.getDuration());
			t.setLength(track.getLength());
		}
	}

}
