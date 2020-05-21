package com.proyecto.entities;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int id_usuario;
	@Column
	private String titulo;
	@Column
	private String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Lob
	@Column
	private File audio;

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarea(int id, int id_usuario, String titulo, String descripcion, Date fecha, File audio) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.audio = audio;
	}
	//GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getFecha() {
		String pattern = "yyyy-M-d";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(fecha);
		System.out.println(date);
		
		return date;
	
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public File getAudio() {

		return audio;
	}

	public void setAudio(File audio2) {
		this.audio = audio2;
	}



}
