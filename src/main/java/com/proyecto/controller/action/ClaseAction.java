package com.proyecto.controller.action;

import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Alumno;
import com.proyecto.entities.Clase;
import com.proyecto.entities.Tarea;
import com.proyecto.services.AlumnoService;
import com.proyecto.services.ClaseService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
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
<<<<<<< refs/remotes/origin/master
	@Autowired
	private AlumnoService alumnoService;
	
	private List <Clase>clases;
	private List<Alumno> alumnos;
=======
	
	@Autowired
	private AlumnoService alumnoService;

	private List<Clase> clases;
	private List<Alumno> alumnos;

>>>>>>> 0.0.26
	private Clase clase;
	private int idClase;
	private String nombre;
	private String alumno;

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

	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
<<<<<<< refs/remotes/origin/master
	
=======

>>>>>>> 0.0.26
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	public String getAlumno() {
		return alumno;
	}

<<<<<<< refs/remotes/origin/master
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
=======
	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

>>>>>>> 0.0.26
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
			this.alumnos = this.alumnoService.findAll();
			return SUCCESS;
		}
	
	@Action(value = "alumnoClase", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/clase/asociarAlumno.jsp") })
	public String alumnoClase() {
		this.clases = this.claseService.findAll();
		this.alumnos = this.alumnoService.findAll();
		return SUCCESS;
	}
	@Action(value = "guardarRelacion", results = {  @Result(name = SUCCESS,type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}),
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}) })
	public String guardarRelacion() {
		System.out.println(nombre);
		System.out.println("-----");
		String nombres[] = nombre.split(",");
		for (String x : nombres) {
			System.out.println(x);
		}
		System.out.println(alumno);
		System.out.println("-----");
		String alum[] = alumno.split(",");
		for (String x : alum) {
			System.out.println(x);
		}
		return SUCCESS;
	}
	
<<<<<<< refs/remotes/origin/master
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/clase/addClase.jsp")
		})
		public String add() {
			
			return SUCCESS;
		}
	//GUARDA LA TAREA ANTES CREADA
=======
	@Action(value = "alumnoClase", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/clase/asociarAlumno.jsp") })
	public String alumnoClase() {
		this.clases = this.claseService.findAll();
		this.alumnos = this.alumnoService.findAll();
		return SUCCESS;
	}
	@Action(value = "guardarRelacion", results = {  @Result(name = SUCCESS,type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}),
			@Result(name = INPUT, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}) })
	public String guardarRelacion() {
		System.out.println(nombre);
		System.out.println("-----");
		String nombres[] = nombre.split(",");
		for (String x : nombres) {
			System.out.println(x);
		}
		System.out.println(alumno);
		System.out.println("-----");
		String alum[] = alumno.split(",");
		for (String x : alum) {
			System.out.println(x);
		}
		return SUCCESS;
	}

	// GUARDA LA TAREA ANTES CREADA
>>>>>>> 0.0.26
	@Action(value = "save", results = {
			@Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/clase", "actionName",
					"listar" }),
			@Result(name = INPUT, type = "redirectAction", params = { "namespace", "/clase", "actionName",
					"listar" }) }, interceptorRefs = { @InterceptorRef(value = "fileUpload"),
							@InterceptorRef("defaultStack") })
	public String save() throws Exception {

		if (this.fileUploadFileName != null) {
			System.out.println("File Name: " + this.fileUploadFileName);
			System.out.println("File Size(bytes): " + this.fileUpload.length());
			System.out.println("File Type: " + this.fileUploadContentType);
			Scanner sc = new Scanner(fileUpload, "UTF8");
			sc.useDelimiter(",");
			String nombre;
			while (sc.hasNext()) {
				nombre = sc.next();
				System.out.print(nombre);
				this.clase = new Clase();
				this.clase.setNombre_clase(nombre);
				this.claseService.create(clase);

			}
			sc.close();
		}

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
