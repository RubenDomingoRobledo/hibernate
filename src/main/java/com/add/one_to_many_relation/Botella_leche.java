package com.add.one_to_many_relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOTELLA DE LECHE")
public class Botella_leche {
	private long id;
	private String descripcion;
	private float precio;
	private Categoria categoria;
	
	public Botella_leche() {
	}

	public Botella_leche(String descripcion, float precio, Categoria categoria) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}

	@Id
    @Column(name = "ID_BOTELLA")
    @GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
