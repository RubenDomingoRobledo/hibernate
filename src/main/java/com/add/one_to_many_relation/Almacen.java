package com.add.one_to_many_relation;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.add.one_to_one_relation.HibernateUtil2;

public class Almacen {
	public static void main(String[] args) {
		try (Session s= HibernateUtil2.getSessionFactory().openSession()){
			Transaction t = null;
			try {
				t = s.beginTransaction();
				Categoria categoria = new Categoria("Lacteos");
				Botella_leche botella1 = new Botella_leche("Asturiana", 6, categoria);
				Botella_leche botella2 = new Botella_leche("Hacendado", 3, categoria);
				Botella_leche botella3 = new Botella_leche("Puleva", 4, categoria);
				Botella_leche botella4 = new Botella_leche("Pascual", 4, categoria);
			
				Set<Botella_leche> botellas = new HashSet<Botella_leche>();
				botellas.add(botella1);
				botellas.add(botella2);
				botellas.add(botella3);
				botellas.add(botella4);
				
				categoria.setBotellas(botellas);
		        s.save(categoria);
		        
		        s.getTransaction().commit();
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
