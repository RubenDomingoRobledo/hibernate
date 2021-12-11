package com.add.one_to_one_relation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.hibernate_prueba.DetallesLibro;
import com.hibernate.hibernate_prueba.HibernateUtil;
import com.hibernate.hibernate_prueba.Libro;

public class Prueba_one_to_one_relation {
	public static void main(String[] args) {
		try (Session s= HibernateUtil.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Libro libro1 = new Libro();
				libro1.setId(1);
				libro1.setTitulo("El Quijote");
				libro1.setDescripcion("Miguel de Cervantes");
				
				DetallesLibro detallesLibro1 = new DetallesLibro();
				detallesLibro1.setAlto(45.5);
				detallesLibro1.setAncho(25.3);
				detallesLibro1.setEditorial("El barco de vapor");
				
				libro1.setDetallesLibro(detallesLibro1);
				detallesLibro1.setLibro(libro1);
				
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
