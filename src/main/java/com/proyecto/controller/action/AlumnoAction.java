package com.proyecto.controller.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
<<<<<<< refs/remotes/origin/master
	
=======
	@Autowired
	private CursaService cursaService;

>>>>>>> 0.0.26
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private List<Alumno> alumnos;
	private Alumno alumno;
	private int id;
	private String nombre;
	private List<Clase> clases;
	private Clase clase;
<<<<<<< refs/remotes/origin/master
	
=======
	private List<Cursa> cursas;
	private Cursa cursa;

>>>>>>> 0.0.26
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
<<<<<<< refs/remotes/origin/master
	
=======

	public Cursa getCursa() {
		return cursa;
	}

	public void setCursa(Cursa cursa) {
		this.cursa = cursa;
	}

>>>>>>> 0.0.26
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
<<<<<<< refs/remotes/origin/master
	
=======

	public List<Cursa> getCursas() {
		return cursas;
	}

	public void setCursas(List<Cursa> cursas) {
		this.cursas = cursas;
	}

>>>>>>> 0.0.26
	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
<<<<<<< refs/remotes/origin/master
	
=======

>>>>>>> 0.0.26
	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
<<<<<<< refs/remotes/origin/master
	
=======

>>>>>>> 0.0.26
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
<<<<<<< refs/remotes/origin/master
	
	@Action(value = "listar", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/index.jsp")
		})
		public String listar() {
		this.clases = this.claseService.findAll();
			this.alumnos = this.alumnoService.findAll();
			return SUCCESS;
		}
	
=======

	@Action(value = "listar", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/alumno/index.jsp") })
	public String listar() {

		this.clases = this.claseService.findAll();
		this.alumnos = this.alumnoService.findAll();
		// this.cursas = this.cursaService.findAll(id);
		// Author a = em.createQuery("SELECT a FROM Author a JOIN FETCH a.books WHERE
		// a.id = 1", Author.class).getSingleResult();
		return SUCCESS;
	}

	/*
	 * @Action(value = "listar2", results = {
	 * 
	 * @Result(name = SUCCESS, location = "/WEB-INF/views/alumno/AlumnosClase.jsp"),
	 * 
	 * @Result(name = INPUT, location = "/WEB-INF/views/alumno/AlumnosClase.jsp") })
	 * public String listar2() { this.clases = this.claseService.findAll();
	 * this.alumnos = this.alumnoService.findFiltro(id); //Author a =
	 * em.createQuery("SELECT a FROM Author a JOIN FETCH a.books WHERE a.id = 1",
	 * Author.class).getSingleResult(); return SUCCESS; }
	 */

>>>>>>> 0.0.26
	@Action(value = "listarClases", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/AlumnosPorClase.jsp") })
	public String listarClases() {
		this.clases = this.claseService.findAll();
		this.alumnos = this.alumnoService.FiltroClase(id);
<<<<<<< refs/remotes/origin/master
		//this.cursas = this.cursaService.findAll(id);
=======
		this.cursas = this.cursaService.findAll(id);
>>>>>>> 0.0.26
		List <Alumno> a = this.alumnoService.FiltroClase(id);
	       
	       for (Alumno a2 : a) {
	    	   System.out.println(a2.getNombre_alumno() + "\n" + a2.getApellido_alumno());
	       }
		return SUCCESS;
	}
<<<<<<< refs/remotes/origin/master
	
	@Action(value = "add", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/alumno/addAlumno.jsp")
		})
		public String add() {
			this.alumno = new Alumno ();
			this.clases = this.alumnoService.findClases();
			return SUCCESS;
		}
	//GUARDA LA TAREA ANTES CREADA
=======

	@Action(value = "add", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/alumno/addAlumno.jsp") })
	public String add() {
		this.alumno = new Alumno();
		this.clases = this.alumnoService.findClases();
		return SUCCESS;
	}

	// GUARDA LA TAREA ANTES CREADA
>>>>>>> 0.0.26
	@Action(value = "save", results = {
			@Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/tarea", "actionName",
					"index" }),
			@Result(name = INPUT, type = "redirectAction", params = { "namespace", "/tarea", "actionName",
					"index" }) }, interceptorRefs = { @InterceptorRef(value = "fileUpload"),
							@InterceptorRef("defaultStack") })
<<<<<<< refs/remotes/origin/master
		public String save() throws Exception {
		
=======

	public String save() throws Exception {
		// System.out.println(clase.getNombre_clase()+ "sadasda");

>>>>>>> 0.0.26
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
<<<<<<< refs/remotes/origin/master

				}

=======

				}

>>>>>>> 0.0.26
				in.close();
			} catch (Exception e) {
				System.out.println("error al leer el fichero alumnos");
			}

		}
		return SUCCESS;
	}
<<<<<<< refs/remotes/origin/master
	
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
	
	
=======

	// ELIMINA LA TAREA ACTUAL
	@Action(value = "delete", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/alumno", "actionName", "listar" }) })
	public String delete() {
		this.alumnoService.delete(this.alumnoService.find(id));
		return SUCCESS;
	}

	// ESTABLECE LA TAREA DE LA CLASE EL VALOR DE LA TAREA QUE HA SIDO BUSCADA.
	@Action(value = "edit", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/alumno/editAlumno.jsp") })
	public String edit() {
		this.alumno = this.alumnoService.find(id);
		return SUCCESS;
	}

	// MODIFICA LA TAREA ANTES BUSCADA
	@Action(value = "update", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/alumno", "actionName", "listar" }), @Result(name = INPUT, location = "/WEB-INF/views/alumno/index.jsp") })
	public String update() {
		this.alumnoService.update(this.alumno);
		return SUCCESS;
	}
>>>>>>> 0.0.26

}
