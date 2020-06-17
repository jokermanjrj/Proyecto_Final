<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alumnos </title>
<style>
<jsp:include page="../tarea/form.css"/>
</style>
</head>
<body>
		<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
		<c:if test="${alumnos.size() == 0 }">
			<div class="noData">
			<h1>No existen alumnos en este ciclo</h1>
			<s:include value="/WEB-INF/views/resultado/noData.jsp"></s:include>
		</div>
		</c:if>
		<c:if test="${alumnos.size() > 0 }">
		<h1>Almunos de ${clase.nombre_clase }</h1>
		<s:form namespace="/alumno" action="Multidelete" methof="post">
		<table border="1" id="tabla">
			<tr>
				<th ></th>
				<th >Nombre</th>
				<th>Apelldios</th>
				<th >Opciones</th>
			</tr>
			
			<c:forEach var="alumno" items="${alumnos }">
			<tr>
				<td>${alumno.id }</td>
				<td>${alumno.nombre_alumno }</td>
				<td>${alumno.apellido_alumno }</td>
				
				<td> 
					<s:url var="url_edit" namespace="/alumno" action="edit"> 
							<s:param name="id">${alumno.id }</s:param>
							<s:param name="idClase">${clase.idClase }</s:param>
					</s:url>
					<s:a href="%{url_edit}" ><img class="icono" src="../assets/uploads/editar.png"></s:a>
					<s:url var="url_delete" namespace="/alumno" action="delete"> 
						<s:param name="id">${alumno.id }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')"><img class="icono" src="../assets/uploads/eliminar.png"></s:a>
					<input type="checkbox" name="ids" value="${alumno.id  }">
       				<label> Eliminar</label><br>
				</td>
			</tr>
		</c:forEach>
		</table>
		<br>
  		<input type="submit" value="Eliminar">
		</s:form>
		</c:if>
</body>
</html>