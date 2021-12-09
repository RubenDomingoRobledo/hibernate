package com.hibernate.hibernate_prueba;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Biblioteca {
	public static void main(String[] args) {
		create();
		read();
		update();
		delete();
	}

	private static void create() {
		try (Session s =HibernateUtil.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Libro libro1 = new Libro();
				libro1.setId(1);
				libro1.setTitulo("Alicia");
				libro1.setDescripcion("En el pais de las maravillas");
				s.save(libro1);
				
				Libro libro2 = new Libro();
				libro2.setId(2);
				libro2.setTitulo("El gato");
				libro2.setDescripcion("Con botas");
				s.save(libro2);
				
				t.commit();		
				s.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private static void read() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Libro libro1 = s.get(Libro.class, 1);
				System.out.println("ID: "+ libro1.getId());
				System.out.println("TÍTULO: "+ libro1.getTitulo());
				System.out.println("DESCRIPCIÓN: "+ libro1.getDescripcion());
				
				Libro libro2 = s.get(Libro.class, 2);
				System.out.println("ID: "+ libro2.getId());
				System.out.println("TÍTULO: "+ libro2.getTitulo());
				System.out.println("DESCRIPCIÓN: "+ libro2.getDescripcion());
				
				t.commit();
				s.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	private static void update() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Libro libro = s.get(Libro.class, 1);
				libro.setTitulo("La Bella");
				libro.setDescripcion("Durmiente");
				
				s.update(libro);
				
				t.commit();
				s.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private static void delete() {
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Libro libro = s.get(Libro.class, 2);
				
				s.delete(libro);
				
				t.commit();
				s.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
