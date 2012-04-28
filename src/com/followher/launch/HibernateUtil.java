package com.followher.launch;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

	private static final Logger logger = Logger.getLogger(HibernateUtil.class); 
	private static final SessionFactory sessionFactory;
	//private static final String resource;

	    static {
	        try {
	        	//resource = "hibernate.cfg.xml";  
	            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            // Log exception!
	        	 logger.error(ex.getMessage());
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static Session getSession() throws HibernateException {
	        return sessionFactory.openSession();
	    }
	}
