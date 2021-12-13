package com.add.one_to_one_relation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.hibernate_prueba.Autor;
import com.hibernate.hibernate_prueba.Libro;

public class Prueba_one_to_one_foreign_key {
	public static void main(String[] args) {
		try (Session s= HibernateUtil2.getSessionFactory().openSession()){
			Transaction t = null;
			
			try {
				t = s.beginTransaction();
				Libro libro1 = new Libro();
				libro1.setTitulo("El Quijote");
				libro1.setDescripcion("En un lugar de la mancha");
				libro1.setAutor(new Autor("Miguel de Cervantes", "Cervantes@gmail.com"));
					
				long idLibro = (long) s.save(libro1);
					
				Libro libro = (Libro) s.get(Libro.class, idLibro);
		        System.out.println("Titulo: " + libro.getTitulo());
		        System.out.println("Descripcion: " + libro.getDescripcion());
		         
		        Autor autor = libro.getAutor();
		        System.out.println("Nombre: " + autor.getNombre());
		        System.out.println("Email: " + autor.getEmail());
		        
			    t.commit();
				s.close();
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
