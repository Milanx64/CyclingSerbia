package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Track;

public interface TrackDao {
	
	List<Track> findAllTracks();
	
	Track findById(int id);
	
	List<Track> findAllTracksOnMountain(String mountain);
	
	Track findByCoste(double couste);
	
	void deleteTrack(Track track);
	
	void savetrack(Track track);
	
}
