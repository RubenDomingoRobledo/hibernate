package com.hibernate.hibernate_prueba;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="LIBRO")
public class Libro {
	private long id;
	@Column
	private String titulo;
	@Column
	private String descripcion;
	private DetallesLibro detallesLibro;
	private Autor autor;
	
	public Libro() {
		super();
	}

	@Id
    @GeneratedValue
    @Column(name = "ID_LIBRO")
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AUTOR")
	public Autor getAutor(){
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
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
