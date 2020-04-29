package com.proyecto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "agenda")
public class Tarea {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String titulo;
	@Column
	private String nota;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinal;
	@Column
	private byte[] imagen;

	public Tarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarea(int id, String titulo, String nota, Date fechaInicio, Date fechaFinal, byte[] imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nota = nota;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public byte[] getImagen() {

		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		String x = new String(imagen);
		return "Agenda [id=" + id + ", titulo=" + titulo + ", nota=" + nota + ", fechaInicio=" + fechaInicio
				+ ", fechaFinal=" + fechaFinal + ", imagen=" + x + "]";
	}

}
