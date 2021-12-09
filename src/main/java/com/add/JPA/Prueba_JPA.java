package com.add.JPA;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hibernate.hibernate_prueba.Libro;

public class Prueba_JPA {
 
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = factory.createEntityManager();
         
        entityManager.getTransaction().begin();
        
         
        //Insertamos nuevo libro
        Libro libro = new Libro();
        libro.setId(2);
        libro.setTitulo("El Quijote");
        libro.setDescripcion("En un lugar de la mancha");
         
        entityManager.persist(libro);
        
        //Update
        Libro libroActualizado = new Libro();
        libroActualizado.setId(2);
        libroActualizado.setTitulo("Cenicienta");
        libroActualizado.setDescripcion("El zapato de cristal");
         
        entityManager.merge(libroActualizado);
        
        //Encontrar libro a partir de la clave primaria
        Integer idLibroBuscado = 2;
        Libro libroBuscado = entityManager.find(Libro.class, idLibroBuscado);
         
        System.out.println(libroBuscado.getId());
        System.out.println(libroBuscado.getTitulo());
        System.out.println(libroBuscado.getDescripcion());
        
        //Realizar una consulta en la base de datos
        String sql = "SELECT l from Libro l where l.titulo = 'Cenicienta'";
        Query query = entityManager.createQuery(sql);
        Libro libroBuscado2 = (Libro) query.getSingleResult();
         
        System.out.println(libroBuscado2.getId());
        System.out.println(libroBuscado2.getTitulo());
        System.out.println(libroBuscado2.getDescripcion());
        
        //Eliminar libro a partir de la clave primaria
        Integer idLibroBorrado = 2;
        Libro libroBorrado = entityManager.getReference(Libro.class, idLibroBorrado);
        entityManager.remove(libroBorrado);
        

        
        entityManager.getTransaction().commit();
         
        entityManager.close();
        factory.close();
    }
}