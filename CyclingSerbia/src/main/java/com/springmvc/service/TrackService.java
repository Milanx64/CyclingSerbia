package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Track;

public interface TrackService {
    List<Track> findAllTracks();
	
	Track findById(int id);
	
	List<Track> findAllTracksOnMountain(String mountain);
}
