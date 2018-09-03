package edu.iepi.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class YaviSession {

	private Session session;

	public YaviSession() {

		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public Session getSession() {

		return session;
	}

}
