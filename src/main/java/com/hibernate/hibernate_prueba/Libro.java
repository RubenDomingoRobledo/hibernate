package com.hibernate.hibernate_prueba;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="LIBRO")
public class Libro {
	int id;
	@Column
	String titulo;
	@Column
	String descripcion;
	DetallesLibro detallesLibro;
	
	public Libro() {
		super();
	}

	@Id
    @GeneratedValue
    @Column(name = "ID_LIBRO")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public DetallesLibro getDetallesLibro() {
		return detallesLibro;
	}
	
	public void setDetallesLibro(DetallesLibro detallesLibro) {
		this.detallesLibro = detallesLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
