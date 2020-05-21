package com.proyecto.controller.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Alumno;
import com.proyecto.entities.Clase;
import com.proyecto.services.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/alumno")
public class AlumnoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AlumnoService alumnoService;
	
	private List<Alumno> alumnos;
	private Alumno alumno;
	private int id;
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Action(value = "listar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/index.jsp")
		})
		public String listar() {
			this.alumnos = this.alumnoService.findAll();
			return SUCCESS;
		}
	
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/addAlumno.jsp")
		})
		public String add() {
			this.alumno = new Alumno ();
			return SUCCESS;
		}
	//GUARDA LA TAREA ANTES CREADA
	@Action(value = "save", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/alumno",  "actionName",  "listar"}),
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/alumno",  "actionName",  "listar"})
		})
		public String save() throws Exception {
		
		this.alumnoService.create(alumno);
			return SUCCESS;
		}
	
	//ELIMINA LA TAREA ACTUAL
		@Action(value = "delete", results = {
				@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/alumno",  "actionName",  "listar"})
			})
			public String delete() {
			this.alumnoService.delete(this.alumnoService.find(id));
				return SUCCESS;
			}
		//ESTABLECE LA TAREA DE LA CLASE EL VALOR DE LA TAREA QUE HA SIDO BUSCADA.
		@Action(value = "edit", results = {
				@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/editAlumno.jsp")
			})
			public String edit() {
				this.alumno = this.alumnoService.find(id);
				return SUCCESS;
			}
		//MODIFICA LA TAREA ANTES BUSCADA
		@Action(value = "update", results = {
				@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/alumno",  "actionName",  "listar"}),
				@Result(name=INPUT, location = "/WEB-INF/views/alumno/index.jsp")
			})
			public String update() {
			this.alumnoService.update(this.alumno);
				return SUCCESS;
			}
	
	

}
