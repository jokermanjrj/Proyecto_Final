<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alumnos</title>
<style>
<jsp:include page="../tarea/form.css"/>
</style>

</head>
<body>
	<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px";>
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			<s:url var="usuario_url" namespace="/tarea" action="calendar">
					<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
				</s:url>
			  <li><s:a href="%{usuario_url}"> Calendario</s:a></li>
			  <li><a href="#news">Alumnos</a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	<div>
		<h1>Selecciona la clase de la que quieras ver los alumnos</h1>
	</div>
	<!--<s:a namespace="/alumno" action="add"> Añadir Alumno</s:a>-->
	<c:forEach var="clase" items="${clases }">
		<ul>
			<li>
				<s:url var="url_clase" namespace="/alumno" action="listarClases">
					<s:param name="id">${clase.idClase} </s:param>
				</s:url>
				<s:a href="%{url_clase}">${clase.nombre_clase }</s:a>
			</li>
		</ul>
	</c:forEach>
	
	<table border="1">
		<tr>
			<th colspan="4">${clase.nombre_clase}</th>
		</tr>
		<c:forEach var="alumno" items="${alumnos }">
			<tr>
				<td>${alumno.id }</td>
				<td>${alumno.nombre_alumno }</td>
				<td>${alumno.apellido_alumno }</td>
				
				<td> 
					<s:url var="url_edit" namespace="/alumno" action="edit"> 
							<s:param name="id">${alumno.id }</s:param>
					</s:url>
					<s:a href="%{url_edit}" ><img class="icon" src="../assets/uploads/editar.png"/></s:a> 
					<s:url var="url_delete" namespace="/alumno" action="delete"> 
						<s:param name="id">${alumno.id }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')"><img class="icon" src="../assets/uploads/eliminar.png"/></s:a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>