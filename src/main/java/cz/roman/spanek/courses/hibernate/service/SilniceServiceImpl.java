package cz.roman.spanek.courses.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import cz.roman.spanek.courses.hibernate.dao.SilniceDAO;
import cz.roman.spanek.courses.hibernate.dao.SilniceDAOImpl;
import cz.roman.spanek.courses.hibernate.model.Silnice;

@Service("silniceServise")
public class SilniceServiceImpl implements SilniceService{

	@Autowired
	SilniceDAO silniceDAO;
	
	@Override
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public Silnice findById(String id) {
		return silniceDAO.findByKey(id);

	}
	
}
