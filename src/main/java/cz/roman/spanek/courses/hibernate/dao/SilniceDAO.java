package cz.roman.spanek.courses.hibernate.dao;

import java.util.List;

import cz.roman.spanek.courses.hibernate.model.Silnice;

public interface SilniceDAO {
		Silnice findByKey(String key);
		void save(Silnice silnice);
}
