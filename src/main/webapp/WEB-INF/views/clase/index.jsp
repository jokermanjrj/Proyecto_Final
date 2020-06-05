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
<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
	<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			<s:url var="usuario_url" namespace="/tarea" action="calendar">
					<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
				</s:url>
			  <li><s:a href="%{usuario_url}"> Calendario</s:a></li>
			  <s:url var="usuario_url" namespace="/tarea" action="index">
				<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
			</s:url>
	 		<li><s:a href="%{usuario_url}">Inicio</s:a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	<s:a namespace="/clase" action="add"><img alt="Añadir ciclos formativos"src="../usuario/prueba.jpg" width="" height=""></s:a>
	<s:a namespace="/clase" action="alumnoClase">Añadir alumnos a ciclos formativos</s:a>
	<c:if test="${clases.size() == 0 }">
		<div class="noData">
			<h1>No existen ciclos formativos registrados</h1>
			<s:include value="/WEB-INF/views/resultado/noData.jsp"></s:include>
		</div>
	</c:if>
	<c:if test="${clases.size() > 0 }">
		<table border="1" id="tabla">
			<tr>
				<th class="column">Id</th>
				<th class="column">nombre</th>
				<th class="column">Editar | Eliminar</th>
			</tr>
			<c:forEach var="clase" items="${clases }">
				<tr>
					<td>${clase.idClase }</td>
					<td>${clase.nombre_clase }</td>
					<td> 
					<s:url var="url_edit" namespace="/clase" action="edit"> 
							<s:param name="idClase">${clase.idClase }</s:param>
						</s:url>
						<s:a href="%{url_edit}" ><img class="icono" src="../assets/uploads/editar.png"></s:a>
						<s:url var="url_delete" namespace="/clase" action="delete"> 
							<s:param name="idClase">${clase.idClase }</s:param>
						</s:url>
						<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')"><img class="icono" src="../assets/uploads/eliminar.png"></s:a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>