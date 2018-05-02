package cz.roman.spanek.courses.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.roman.spanek.courses.hibernate.model.Silnice;

@Repository("silniceDAO")
public class SilniceDAOImpl implements SilniceDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Silnice findByKey(String key) {
		return sessionFactory.getCurrentSession().get(Silnice.class, key);
	}

	@Override
	public void save(Silnice silnice) {
		sessionFactory.getCurrentSession().persist(silnice);
	}

}
