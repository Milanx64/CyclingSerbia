package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Mountain;
import com.springmvc.model.Track;

@Repository("trackDao")
public class TrackDaoImpl extends AbstractDao<Integer, Track> implements TrackDao {

	@SuppressWarnings("unchecked")
	public List<Track> findAllTracks() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		return (List<Track>)crit.list();
	}

	public Track findById(int id) {
		// TODO Auto-generated method stub
		return (Track) getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Track> findAllTracksOnMountain(Mountain mountain) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("mountain", mountain));
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return (List<Track>) crit.list();
	}

	public Track findByCoste(double couste) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteTrack(Track track) {
		// TODO Auto-generated method stub
		delete(track);
	}

	public void saveTrack(Track track) {
		// TODO Auto-generated method stub
		persist(track);
	}

}
