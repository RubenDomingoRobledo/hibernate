package com.add.one_to_many_relation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
	private long id;
    private String nombre;
    private Set<Botella_leche> botellas;

	public Categoria() {
	}

	public Categoria(String nombre) {
		this.nombre = nombre;
	}
	
	@Id
    @Column(name = "ID_CATEGORIA")
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
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	public Set<Botella_leche> getBotellas() {
		return botellas;
	}

	public void setBotellas(Set<Botella_leche> botellas) {
		this.botellas = botellas;
	}
	
	
}
