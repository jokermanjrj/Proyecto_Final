package com.proyecto.controller.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.entities.Tarea;
import com.proyecto.services.TareaService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/tarea")
public class TareaAction extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TareaService tareaService;

	private List<Tarea> tareas;
	private Tarea tarea;
	private int id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	@Action(value = "index", results = {
		@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/index.jsp")
	})
	public String index() {
		this.tareas = this.tareaService.findAll();
		return SUCCESS;
	}
	
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/add.jsp")
		})
		public String add() {
			this.tarea = new Tarea ();
			return SUCCESS;
		}
	
	@Action(value = "save", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"})
		})
		public String save() {
		this.tareaService.create(tarea);
			return SUCCESS;
		}
	
	@Action(value = "delete", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"})
		})
		public String delete() {
		this.tareaService.delete(this.tareaService.find(id));
			return SUCCESS;
		}
	
	@Action(value = "edit", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/edit.jsp")
		})
		public String edit() {
			this.tarea = this.tareaService.find(id);
			return SUCCESS;
		}
	
	@Action(value = "update", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"})
		})
		public String update() {
		this.tareaService.update(this.tarea);
			return SUCCESS;
		}
	
	

}
