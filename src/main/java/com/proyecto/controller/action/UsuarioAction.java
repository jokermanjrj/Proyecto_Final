package com.proyecto.controller.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.proyecto.entities.Usuario;
import com.proyecto.services.UsuarioService;

@Namespace("/usuario")
public class UsuarioAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String errorMessage = "";
	private String username;
	private String password;
	private Usuario usuario;
	private List<Usuario> usuarios;
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Action(value = "edit", results = {
			@Result(name = SUCCESS, location = "/WEB-INF/views/cuenta/welcome.jsp")
		})
		public String edit() {
			this.usuario = this.usuarioService.identificarse(username, password);
			return SUCCESS;
		}

}
