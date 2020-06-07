package com.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursa")
public class Cursa {
	
	@Column(name = "Clase_id")
	private int clase_id;
	@Id
	@Column(name = "Alumno_id")
	private int alumno_id;

	public Cursa() {
		super();
	}

	public int getClase_id() {
		return clase_id;
	}

	public void setClase_id(int clase_id) {
		this.clase_id = clase_id;
	}

	public int getAlumno_id() {
		return alumno_id;
	}

	public void setAlumno_id(int alumno_id) {
		this.alumno_id = alumno_id;
	}

	
}
