package com.proyecto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
	@Id
	@Column(name = "idAlumno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre_alumno;
	@Column
	private String apellido_alumno;
	
	
	public Alumno() {
		super();
	}
	
	public Alumno(int id, String nombre_alumno, String apellido_alumno) {
		super();
		this.id = id;
		this.nombre_alumno = nombre_alumno;
		this.apellido_alumno = apellido_alumno;
	}
	
	@JoinTable(name = "cursa", joinColumns = @JoinColumn(name = "Alumno_id",  nullable = false), inverseJoinColumns = @JoinColumn(name = "Clase_id",  nullable = false))
	@ManyToMany
	private List<Clase> clases;
	
	public void addClases(Clase clase) {
		if (this.clases == null) {
			this.clases = new ArrayList<Clase>();
		}

		this.clases.add(clase);
	}
	
	//GETTERS Y SETTERS
	
	public List<Clase> getAlumnos() {
		return clases;
	}

	public void setAlumnos(List<Clase> clases) {
		this.clases = clases;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_alumno() {
		return nombre_alumno;
	}
	public void setNombre_alumno(String nombre_alumno) {
		this.nombre_alumno = nombre_alumno;
	}
	public String getApellido_alumno() {
		return apellido_alumno;
	}
	public void setApellido_alumno(String apellido_alumno) {
		this.apellido_alumno = apellido_alumno;
	}
}
