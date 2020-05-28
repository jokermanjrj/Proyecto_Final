package com.proyecto.entities;

public class Meses {

	String nombre;
	int dias,mes;
	
	
	
	public Meses(String nombre, int dias,int mes) {
		this.nombre = nombre;
		this.dias = dias;
		this.mes = mes;

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
	
	public int getMes() {
		
		return mes;
	}
	public void setMes(int mes) {
		this.dias = mes;
	}
	
	
	
}
