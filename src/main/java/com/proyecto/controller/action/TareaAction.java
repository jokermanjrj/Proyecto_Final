package com.proyecto.controller.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.entities.Tarea;
import com.proyecto.services.TareaService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/tarea")
public class TareaAction extends ActionSupport implements ServletRequestAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File fileUpload;
    //private String fileUploadContentType;
    //private String fileUploadFileName;

    private HttpServletRequest servletRequest;


	@Autowired
	private TareaService tareaService;

	private List<Tarea> tareas;
	private Tarea tarea;
	private int id;
	
	
	/*public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }*/
    
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

	//ACCION QUE TE ENVIA AL CALENDARIO
	

	@Action(value = "calendar", results = {
		@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/calendar.jsp")
	})
	public String calendar() {
		return SUCCESS;
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
		public String save() throws Exception {
		
		this.tareaService.create(tarea);
			return SUCCESS;
		}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
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
