package com.proyecto.controller.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Cursa;
import com.proyecto.services.CursaService;
@Namespace("/cursa")
public class CursaAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CursaService cursaService;
	
	private List <Cursa> cursas;
	private Cursa cursa;
	private int clase_id;
	

	public int getClase_id() {
		return clase_id;
	}

	public void setClase_id(int clase_id) {
		this.clase_id = clase_id;
	}

	public Cursa getCursa() {
		return cursa;
	}

	public void setCursa(Cursa cursa) {
		this.cursa = cursa;
	}

	public List<Cursa> getCursas() {
		return cursas;
	}

	public void setCursas(List<Cursa> cursas) {
		this.cursas = cursas;
	}
	
	@Action(value = "listar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/clase/AlumnosPorClase.jsp")
		})
		public String listar() {
			this.cursas = this.cursaService.findAll(clase_id);
			return SUCCESS;
		}
}
