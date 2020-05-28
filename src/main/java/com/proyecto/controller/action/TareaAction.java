package com.proyecto.controller.action;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.entities.Calendario;
import com.proyecto.entities.Tarea;
import com.proyecto.entities.Usuario;
import com.proyecto.services.TareaService;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/tarea")
public class TareaAction extends ActionSupport implements ServletRequestAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    
    private Calendario calendario;

	@Autowired
	private TareaService tareaService;

	private List<Tarea> tareas;
	private Tarea tarea;
	
	private int id_usuario;
	private int id;
	
	private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    private HttpServletRequest servletRequest;
	
	
    public String getFileUploadContentType() {
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
    }
	
	

	public int getId() {
		return id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	
	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	//ACCION QUE TE ENVIA AL CALENDARIO
	@Action(value = "calendar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/calendar.jsp")
		})
		public String calendar() {
			this.calendario = new Calendario();
			//System.out.println(calendario.getMeses());
			this.tareas = this.tareaService.findAll();
			return SUCCESS;
		}
	
	
	
	//LISTADO DE TODAS LAS TAREAS, SE EJECUTA NADA MÁS SE REDIRIGE AL INDEX.
	@Action(value = "index", results = {
		@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/index.jsp")
	})
	public String index() {
		this.tareas = this.tareaService.findAll();
		return SUCCESS;
	}
	
	//CREA UNA NUEVA TAREA
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/add.jsp")
		})
		public String add() {
			this.tarea = new Tarea ();
			return SUCCESS;
		}
	//GUARDA LA TAREA ANTES CREADA
	@Action(value = "save", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"}),
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"})
		},interceptorRefs = {
				@InterceptorRef(
						params = {
							"allowedTypes", "image/png,image/gif,image/jpeg,image/jpg",
							"maximumSize", "2097152"
			            },
			            value = "fileUpload"
			        ),
					@InterceptorRef("defaultStack")
				})
	
		public String save() throws Exception {
		// informacion d
				System.out.println("File Name: " + this.fileUploadFileName);
				System.out.println("File Size(bytes): " + this.fileUpload.length());
				System.out.println("File Type: "+ this.fileUploadContentType);
				this.tarea.setAudio(fileUpload);
		this.tareaService.create(tarea);
			return SUCCESS;
		}
	
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	//ELIMINA LA TAREA ACTUAL
	@Action(value = "delete", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"})
		})
		public String delete() {
		this.tareaService.delete(this.tareaService.find(id));
			return SUCCESS;
		}
	//ESTABLECE LA TAREA DE LA CLASE EL VALOR DE LA TAREA QUE HA SIDO BUSCADA.
	@Action(value = "edit", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/edit.jsp")
		})
		public String edit() {
			this.tarea = this.tareaService.find(id);
			return SUCCESS;
		}
	//MODIFICA LA TAREA ANTES BUSCADA
	@Action(value = "update", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"}),
			@Result(name=INPUT, location = "/WEB-INF/views/tarea/index.jsp")
		})
		public String update() {
		this.tareaService.update(this.tarea);
			return SUCCESS;
		}
	
	
	
	

}
