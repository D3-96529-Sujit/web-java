package com.app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public static void closeFactory()
	{
		if(sessionFactory !=null)
			sessionFactory.close();
	}
}
