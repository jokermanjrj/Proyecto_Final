package com.proyecto.entities;

public class Meses {

	String nombre;
	int dias;
	
	
	
	public Meses(String nombre, int dias) {
		this.nombre = nombre;
		this.dias = dias;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	
}
