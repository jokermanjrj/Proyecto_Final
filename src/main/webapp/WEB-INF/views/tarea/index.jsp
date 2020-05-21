<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notas</title>

</head>
<body>

	<h3>tareas List</h3>
	<s:a namespace="/tarea" action="calendar"> Calendario</s:a>
	<s:a namespace="/tarea" action="add"> Añadir Tarea</s:a>
	<s:a namespace="/clase" action="listar">Clases</s:a>
	<s:a namespace="/alumno" action="listar">Alumnos</s:a>
	<table border="1">
	<!--COMENTARIO DE FECHT -->
		<tr>
			<th>Id</th>
			<th>Id_usuario</th>
			<th>titulo</th>
			<th>Nota</th>
			<th>Fecha</th>
			<th>Audio</th>
		</tr>
		<c:forEach var="tarea" items="${tareas }">
			<tr>
				<td>${tarea.id }</td>
				<td>${tarea.id_usuario }</td>
				<td>${tarea.titulo }</td>
				<td>${tarea.descripcion }</td>
				<td>${tarea.fecha }</td>
				<td>${tarea.audio }</td>
				<td> 
					<s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tarea.id }</s:param>
					</s:url>
					<s:a href="%{url_edit}" >Editar</s:a> | 
					<s:url var="url_delete" namespace="/tarea" action="delete"> 
						<s:param name="id">${tarea.id }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')">Borrar</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>