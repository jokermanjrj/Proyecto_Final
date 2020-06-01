<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clases</title>
<style>
<jsp:include page="../tarea/form.css"/>
</style>
</head>
<body>
	<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>
			  <li><a href="#news">Inicio</a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	<s:a namespace="/clase" action="add"><img src="../usuario/prueba.jpg" width="" height=""></s:a>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>nombre</th>
		</tr>
		<c:forEach var="clase" items="${clases }">
			<tr>
				<td>${clase.idClase }</td>
				<td>${clase.nombre_clase }</td>
				<td> 
				<s:url var="url_edit" namespace="/clase" action="edit"> 
						<s:param name="idClase">${clase.idClase }</s:param>
					</s:url>
					<s:a href="%{url_edit}" >Editar</s:a> | 
					<s:url var="url_delete" namespace="/clase" action="delete"> 
						<s:param name="idClase">${clase.idClase }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')">Borrar</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>