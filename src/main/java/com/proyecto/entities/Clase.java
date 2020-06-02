package com.proyecto.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "clase")
public class Clase {
	
	@Id
	@Column(name = "idClase")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClase;

	@Column
	private String nombre_clase;

	public Clase() {
		super();
	}

	public Clase(int idClase, String nombre_clase) {
		super();
		this.idClase = idClase;
		this.nombre_clase = nombre_clase;
	}

	/*@JoinTable(name = "imparte", joinColumns = @JoinColumn(name = "id_clase"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	@ManyToMany
	private List<Usuario> usuarios;

	public void addUsuario(Usuario usuario) {
		if (this.usuarios == null) {
			this.usuarios = new ArrayList<Usuario>();
		}

		this.usuarios.add(usuario);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@JoinTable(name = "cursa", joinColumns = @JoinColumn(name = "id_clase"), inverseJoinColumns = @JoinColumn(name = "id_alumno"))
	@ManyToMany
	private List<Alumno> alumnos;
	
	public void addAlumnos(Alumno alumno) {
		if (this.alumnos == null) {
			this.alumnos = new ArrayList<Alumno>();
		}

		this.alumnos.add(alumno);
	}
	
	//GETTERS Y SETTER
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}*/
	@ManyToMany(mappedBy = "clases")
	private List<Alumno> alumnos;
	

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public String getNombre_clase() {
		return nombre_clase;
	}

	public void setNombre_clase(String nombre_clase) {
		this.nombre_clase = nombre_clase;
	}

}
