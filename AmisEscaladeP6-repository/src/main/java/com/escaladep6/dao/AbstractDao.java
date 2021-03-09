package com.escaladep6.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.escaladep6.hiber.HibernateUtils;

public abstract class AbstractDao {
	
	SessionFactory factory = HibernateUtils.getSessionFactory();
	
	protected Session session() {
		return factory.getCurrentSession();
	}
}
