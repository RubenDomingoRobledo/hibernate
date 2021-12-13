package com.add.one_to_one_relation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernate.hibernate_prueba.DetallesLibro;
import com.hibernate.hibernate_prueba.Libro;

public class Prueba_one_to_one_primary_key {
	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();  
		      
		SessionFactory factory=meta.getSessionFactoryBuilder().build();  
		Session s = factory.openSession();  
		
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			Libro libro1 = new Libro();
			libro1.setTitulo("El Quijote");
			libro1.setDescripcion("Miguel de Cervantes");
				
			DetallesLibro detallesLibro1 = new DetallesLibro();
			detallesLibro1.setAlto(45.5);
			detallesLibro1.setAncho(25.3);
			detallesLibro1.setEditorial("El barco de vapor");
				
			libro1.setDetallesLibro(detallesLibro1);
			detallesLibro1.setLibro(libro1);
				
			s.save(libro1);
				
			List<Libro> listaLibros = s.createQuery("from Libro").list();
		    for (Libro libro : listaLibros) {
		    	String info = "\tLibro: " + libro.getTitulo() + "\n";
		        info += "\tDescripcion: " + libro.getDescripcion() + "\n";
		             
		        DetallesLibro detallesLibro = libro.getDetallesLibro();
		        info += "\tAncho: " + detallesLibro.getAncho() + "\n";
		        info += "\tAlto: " + detallesLibro.getAlto() + "\n";
		        info += "\tEditorial: " + detallesLibro.getEditorial() + "\n";
		             
		        System.out.println(info);
		     }

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
