package com.add.one_to_one_relation;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil2 {
	private static final SessionFactory sessionFactory;	
	static {
	    try {
	    	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    	Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();  
	      
	    	sessionFactory =meta.getSessionFactoryBuilder().build();  
	    }
	    catch (Throwable ex) {
	        // Log the exception. 
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
	}
	
	 public static SessionFactory getSessionFactory() {
		    return sessionFactory;
		  }
}