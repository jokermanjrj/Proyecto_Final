package com.proyecto.controller.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Tarea;
import com.proyecto.entities.Usuario;
import com.proyecto.services.UsuarioService;

@Namespace("/usuario")
public class UsuarioAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	private String errorMessage = "";
	private String correo;
	private String pasword;
	private Usuario usuario;
	private int id;
	private List<Usuario> usuarios;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public String getPasword() {
		return pasword;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Action(value = "index", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/usuario/index.jsp") })
	public String index() {
		this.usuarios = this.usuarioService.findAll();
		return SUCCESS;
	}

	@Action(value = "identificarse", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/tarea/index.jsp"),
			@Result(name = ERROR, location = "/WEB-INF/views/usuario/index.jsp") })
	public String identificarse() {
		this.usuarios = this.usuarioService.identificarse(correo, pasword);
		System.out.println(this.usuarios.size());

		if (this.usuarios.size() == 1) {
			this.usuario = this.usuarios.get(0);
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("usuario", this.usuario);
			return SUCCESS;
		} else {
			this.errorMessage = "Usuario no encontrado";

			return ERROR;
		}

	}
	
	@Action(value = "logout", results = {
			@Result(name = SUCCESS, type = "redirectAction", params = { "namespace", "/usuario", "actionName", "index" })
		})
		public String logout() {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.remove("usuario");
			return SUCCESS;
		}

	@Action(value = "register", results = { @Result(name = SUCCESS, location = "/WEB-INF/views/usuario/registrar.jsp"),
			@Result(name = ERROR, location = "/WEB-INF/views/usuario/registrar.jsp") })
	public String register() {
		try {
			this.usuario = new Usuario();
			return SUCCESS;
		} catch (Exception e) {
			this.errorMessage = "Usuario existente";

			return ERROR;
		}

	}

	@Action(value = "save", results = { @Result(name = SUCCESS, type = "redirectAction", params = { "namespace",
			"/usuario", "actionName", "index" }),@Result(name = ERROR, location = "/WEB-INF/views/usuario/registrar.jsp")
			})
	public String save() throws Exception {
		try {
			this.usuarioService.create(usuario);
			return SUCCESS;
		} catch (Exception e) {
			this.errorMessage = "Usuario existente";

			return ERROR;
		}
	}

}