package com.proyecto.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	private byte[] audio;

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarea(int id, int id_usuario, String titulo, String descripcion, Date fecha, byte[] audio) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.audio = audio;
	}

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public byte[] getAudio() {

		return audio;
	}

	public void setAudio(byte[] audio) {
		this.audio = audio;
	}

	@Override
	public String toString() {
		String x = new String(audio);
		return "Agenda [id=" + id + ", titulo=" + titulo + ", nota=" + descripcion + ", fechaInicio=" + fecha
				+ ", imagen=" + x + "]";
	}

}
