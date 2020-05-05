package com.proyecto.controller.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Calendario;

@Namespace("/calendario")
public class CalendarioAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private Calendario calendario;
	
	//ACCION QUE TE ENVIA AL CALENDARIO
		@Action(value = "calendar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/calendar.jsp")
		})
		public String calendar() {
			this.calendario = new Calendario();
			this.calendario.getMeses();
			return SUCCESS;
		}
		
}
