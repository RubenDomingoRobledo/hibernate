package com.hibernate.hibernate_prueba;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity 
@Table(name="DETALLES_LIBRO")
public class DetallesLibro {
	private long id;
	@Column
	private double alto;
	@Column
    private double ancho;
	@Column
    private String editorial;
    private Libro libro;
    
	public DetallesLibro() {
	}

	@Id
    @Column(name = "ID_LIBRO")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@OneToOne(mappedBy = "detallesLibro")
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	} 
}
