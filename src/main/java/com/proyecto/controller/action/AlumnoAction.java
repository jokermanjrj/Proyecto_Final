package com.proyecto.controller.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Alumno;
import com.proyecto.entities.Clase;
import com.proyecto.services.AlumnoService;
import com.proyecto.services.ClaseService;
import com.proyecto.services.ReportService;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/alumno")
public class AlumnoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private ClaseService claseService;
	@Autowired
	private ReportService reportService;

	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	private List<Alumno> alumnos;
	private List <Integer> ids = new ArrayList<Integer>();
	private List<Clase> clases;
	
	private Alumno alumno;
	private int id;
	private String nombre;
	private Clase clase;

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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
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

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
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
		this.clases = this.claseService.findAll();
			this.alumnos = this.alumnoService.findAll();
			return SUCCESS;
		}
	

	@Action(value = "listarClases", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/AlumnosPorClase.jsp") })
	public String listarClases() {
		this.clases = this.claseService.findAll();
		this.alumnos = this.alumnoService.FiltroClase(id);
		//this.cursas = this.cursaService.findAll(id);

		List <Alumno> a = this.alumnos;
	       
	       for (Alumno a2 : a) {
	    	   System.out.println(a2.getNombre_alumno() + "\n" + a2.getApellido_alumno());
	       }
		return SUCCESS;
	}

	
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/addAlumno.jsp")
		})
		public String add() {
			this.alumno = new Alumno ();
			this.clases = this.alumnoService.findClases();
			return SUCCESS;
		}
	//GUARDA LA TAREA ANTES CREADA

	@Action(value = "save", results = {
			@Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/tarea", "actionName",
					"index" }),
			@Result(name = INPUT, type = "redirectAction", params = { "namespace", "/tarea", "actionName",
					"index" }) }, interceptorRefs = { @InterceptorRef(value = "fileUpload"),
							@InterceptorRef("defaultStack") })

		public String save() throws Exception {

		if (this.fileUploadFileName != null) {
			System.out.println("File Name: " + this.fileUploadFileName);
			System.out.println("File Size(bytes): " + this.fileUpload.length());
			System.out.println("File Type: " + this.fileUploadContentType);
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileUpload), "UTF8"));
				String str;
				System.out.println("id pasado es " + id);
				this.clase = this.claseService.find(id);
				while ((str = in.readLine()) != null) {
					
					String nombres[] = str.split(",");
					System.out.println(nombres.length);
					System.out.println(nombres[0]);
					System.out.println(nombres[1]);
					this.alumno = new Alumno();
					this.alumno.setNombre_alumno(nombres[0]);
					this.alumno.setApellido_alumno(nombres[1]);
					this.alumno.addClases(clase);
					this.alumnoService.create(alumno);

				}


				in.close();
			} catch (Exception e) {
				System.out.println("error al leer el fichero alumnos");
			}

		}
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
		
		@Action(value = "Multidelete", results = {
				@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}),
				@Result(name = INPUT, type="redirectAction", params = { "namespace","/clase",  "actionName",  "listar"}),
			})
			public String Multidelete() {
			for( int idx : ids) {
				System.out.println(idx);
				this.alumnoService.delete(this.alumnoService.find(idx));
			}
			//this.tareaService.delete(this.tareaService.find(id));
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
		
		@Action(value = "reportAlumno", results = {
				@Result(name = SUCCESS, type="redirectAction", params = { "namespace","/alumno",  "actionName",  "listar"}),
				@Result(name=INPUT, location = "/WEB-INF/views/alumno/index.jsp")
			})
			public String reportAlumno() throws JRException, FileNotFoundException {
				this.alumnos = this.alumnoService.FiltroClase(id);
				this.clase = this.claseService.find(id);
				this.reportService.exportReport(this.alumnos, this.clase.getNombre_clase());
				return SUCCESS;
			}
	
	


}
