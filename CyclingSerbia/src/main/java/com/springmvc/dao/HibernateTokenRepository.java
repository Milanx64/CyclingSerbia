package com.springmvc.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.springmvc.model.PersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepository extends AbstractDao<String, PersistentLogin> implements PersistentTokenRepository{
	
	//static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepository.class);
	
	public void createNewToken(PersistentRememberMeToken token) {
		// TODO Auto-generated method stub
		//logger.info("create Token for user : {}", token.getUsername());
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		persist(persistentLogin);
	}
	
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		// TODO Auto-generated method stub
		//logger.info("updating token for seriesId: {}", series);
		PersistentLogin ps = getByKey(series);
		ps.setToken(tokenValue);
		ps.setLast_used(lastUsed);
	}
	
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		//logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("series", seriesId));
            PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
 
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            //logger.info("Token not found...");
            return null;
        }
	}
	
	public void removeUserTokens(String username) {
		// TODO Auto-generated method stub
		//logger.info("removing token for user {}", username);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		PersistentLogin persistentLogin = (PersistentLogin) crit.uniqueResult();
		if(persistentLogin != null) {
			delete(persistentLogin);
		}
	}

}
