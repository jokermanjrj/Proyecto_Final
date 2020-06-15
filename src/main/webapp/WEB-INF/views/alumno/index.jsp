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
<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
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
			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	<!--<s:a namespace="/alumno" action="add"> A�adir Alumno</s:a>-->

<h1>Selecciona el ciclo de la cual quieres obtener los alumnos</h1>


	<c:forEach var="clase" items="${clases }">
		<ul>
			<li>
				<s:url var="url_clase" namespace="/alumno" action="listarClases">
					<s:param name="id">${clase.idClase} </s:param>
				</s:url>
				<s:a href="%{url_clase}">${clase.nombre_clase }</s:a>
			</li>
			<li>
				<s:url var="url_Report" namespace="/alumno" action="reportAlumno">
					<s:param name="id">${clase.idClase}</s:param>
				</s:url>
				<s:a href="%{url_Report}"><img class="icono" src="../assets/uploads/print.png"></s:a>
			</li>
		</ul>
	</c:forEach>

</body>
</html>