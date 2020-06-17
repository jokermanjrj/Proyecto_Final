package com.proyecto.controller.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.entities.Calendario;
import com.proyecto.entities.Tarea;
import com.proyecto.entities.Usuario;
import com.proyecto.services.ReportService;
import com.proyecto.services.TareaService;

import net.sf.jasperreports.engine.JRException;
import sun.misc.BASE64Encoder;

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
	@Autowired
	private ReportService reportService;

	private String errorMessage = "";
	private List<Tarea> tareas;
	private Tarea tarea;
	private List<String> imagenes = new ArrayList<String>();
	
	private String image;
	private int id_usuario;
	private int id;
	private List <Integer> ids = new ArrayList<Integer>();
	
	private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    private HttpServletRequest servletRequest;
	
	
    public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
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
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
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
	

	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

	//ACCION QUE TE ENVIA AL CALENDARIO
	@Action(value = "calendar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/calendar.jsp")
		})
		public String calendar() {
			this.calendario = new Calendario();
			this.calendario.getMeses();
			//System.out.println(calendario.getMeses());
			this.tareas = this.tareaService.findAll(id_usuario);
			return SUCCESS;
		}
	
	
	
	//LISTADO DE TODAS LAS TAREAS, SE EJECUTA NADA MÁS SE REDIRIGE AL INDEX.
	@Action(value = "index", results = {
		@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/index.jsp")
	})
	public String index() {
		this.tareas = this.tareaService.findAll(id_usuario);
		for(Tarea a : tareas) {
			System.out.println(a.getAudio());
			if(a.getAudio() != null) {
				BASE64Encoder base64Encoder = new BASE64Encoder();
				StringBuilder imageString = new StringBuilder();
				imageString.append("data:image/png;base64,");
				imageString.append(base64Encoder.encode(a.getAudio()));
				image = imageString.toString();
				this.imagenes.add(image);
				
			}else {
				image = null;
				this.imagenes.add(image);
			}
			
		}
		return SUCCESS;
	}
	
	@Action(value = "home", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/tarea/index.jsp")
		})
		public String home() {
			this.tareas = this.tareaService.findAll(id_usuario);
			System.out.println(tareas.size());
			for(Tarea a : tareas) {
				System.out.println(a.getAudio());
				if(a.getAudio() != null) {
					BASE64Encoder base64Encoder = new BASE64Encoder();
					StringBuilder imageString = new StringBuilder();
					imageString.append("data:image/png;base64,");
					imageString.append(base64Encoder.encode(a.getAudio()));
					image = imageString.toString();
					this.imagenes.add(image);
					
				}else {
					image = null;
					this.imagenes.add(image);
				}
				
			}
			System.out.println(imagenes.size());
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
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"}),
			@Result(name = ERROR, location = "/WEB-INF/views/tarea/add.jsp")
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
		this.tareas = this.tareaService.findAll(id_usuario);
		// informacion d
		try {
		if(this.fileUploadFileName != null) {
			System.out.println("File Name: " + this.fileUploadFileName);
			System.out.println("File Size(bytes): " + this.fileUpload.getAbsolutePath());
			System.out.println("File Type: "+ this.fileUploadContentType);
			
			BufferedImage image = ImageIO.read(new File(this.fileUpload.getAbsolutePath()));
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
		       ImageIO.write(image, "jpg", bos );
		       byte [] array = bos.toByteArray();
			       this.tarea.setAudio(array);
			
		}
				
		this.tareaService.create(tarea);
			return SUCCESS;
			
		}catch(Exception e) {
			System.out.println("Archivo demasiado grande");
			this.errorMessage = "Archivo demasiado grande";

			return ERROR;
		}
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
	
	@Action(value = "Multidelete", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"}),
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"}),
		})
		public String Multidelete() {
		for( int idx : ids) {
			System.out.println(idx);
			this.tareaService.delete(this.tareaService.find(idx));
		}
		//this.tareaService.delete(this.tareaService.find(id));
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
		public String update() throws IOException {
		this.tareas = this.tareaService.findAll(id_usuario);
		if(this.fileUploadFileName != null) {
			System.out.println("File Name: " + this.fileUploadFileName);
			System.out.println("File Size(bytes): " + this.fileUpload.getAbsolutePath());
			System.out.println("File Type: "+ this.fileUploadContentType);
			
			BufferedImage image = ImageIO.read(new File(this.fileUpload.getAbsolutePath()));
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
		       ImageIO.write(image, "jpg", bos );
		       byte [] array = bos.toByteArray();
			       this.tarea.setAudio(array);
			
		}
		this.tareaService.update(this.tarea);
			return SUCCESS;
		}
	
	
	@Action(value = "reportTarea", results = {
			@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/tarea",  "actionName",  "index"}),
			@Result(name=INPUT, location = "/WEB-INF/views/tarea/index.jsp")
		})
		public String reportTarea() throws JRException, FileNotFoundException {
			this.tareas = this.tareaService.findAll(id_usuario);
			this.reportService.ReportTarea(this.tareas);
			return SUCCESS;
		}
	
	

}
