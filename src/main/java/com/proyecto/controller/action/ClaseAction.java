package com.proyecto.controller.action;

import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Clase;
import com.proyecto.entities.Tarea;
import com.proyecto.services.ClaseService;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/clase")
public class ClaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClaseService claseService;
	
	private List <Clase>clases;
	private Clase clase;
	private int idClase;

	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	@Action(value = "listar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/clase/index.jsp")
		})
		public String listar() {
			this.clases = this.claseService.findAll();
			return SUCCESS;
		}
	
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/clase/addClase.jsp")
		})
		public String add() {
			this.clase = new Clase ();
			return SUCCESS;
		}
	//GUARDA LA TAREA ANTES CREADA
	@Action(value = "save", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}),
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"})
		})
		public String save() throws Exception {
		
		this.claseService.create(clase);
			return SUCCESS;
		}
	
	//ELIMINA LA TAREA ACTUAL
		@Action(value = "delete", results = {
				@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"})
			})
			public String delete() {
			this.claseService.delete(this.claseService.find(idClase));
				return SUCCESS;
			}
		//ESTABLECE LA TAREA DE LA CLASE EL VALOR DE LA TAREA QUE HA SIDO BUSCADA.
		@Action(value = "edit", results = {
				@Result(name = SUCCESS, location = "/WEB-INF/views/clase/editClase.jsp")
			})
			public String edit() {
				this.clase = this.claseService.find(idClase);
				return SUCCESS;
			}
		//MODIFICA LA TAREA ANTES BUSCADA
		@Action(value = "update", results = {
				@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}),
				@Result(name=INPUT, location = "/WEB-INF/views/clase/index.jsp")
			})
			public String update() {
			this.claseService.update(this.clase);
				return SUCCESS;
			}
	
}
