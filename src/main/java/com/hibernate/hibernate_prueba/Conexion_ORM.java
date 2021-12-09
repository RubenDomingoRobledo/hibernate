package com.hibernate.hibernate_prueba;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Conexion_ORM {
	public static void main(String[] args) {
		try (Session s= HibernateUtil.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Libro libro1 = new Libro();
				libro1.setId(1);
				libro1.setTitulo("El Quijote");
				libro1.setDescripcion("Miguel de Cervantes");
				s.save(libro1);
				
				t.commit();
			}
			catch (Exception e) {
		        e.printStackTrace(System.err);
		        if (t != null) {
		          t.rollback();
		        }
			}
		}
	}
}
