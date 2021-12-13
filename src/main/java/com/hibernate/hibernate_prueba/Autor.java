package com.hibernate.hibernate_prueba;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "AUTOR")
public class Autor {
    private long id;
    private String nombre;
    private String email;
     
    public Autor() {
    }
             
    public Autor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
 
    @Id
    @Column(name = "ID_AUTOR")
    @GeneratedValue
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }  
}
