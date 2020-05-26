<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notas</title>
<style>
	.contenedor {
	background-image: url("./prueba.jpg");
		justify-content: center;
		
		
	}
	.boton {
		background-color: grey;
		opacity: 95%;
		border-radius: 20px;
		font-size: 40px;
		text-align: center;
		width: 50%;
		height: 500px;
		
	}
	
	
	.boton:hover{
		background-color: black;
	}
	
	.link{
		color: white;
		text-decoration: none;
		width: 100%;
		height: 100%;
	}
	
	#titulo {
		color: white;
		text-align: center;
		background-color: grey;
		opacity: 80px;
		padding: 20px;
		border-radius: 20px;
		font-size: 80px;
	}
</style>
</head>
<body>

	<h3>tareas List</h3>
	<s:a namespace="/tarea" action="calendar"> Calendario</s:a>
	<s:a namespace="/tarea" action="add"> A�adir Tarea</s:a>
	<s:a namespace="/clase" action="listar">Clases</s:a>
	<s:a namespace="/alumno" action="listar">Alumnos</s:a>
	<s:a namespace="/tarea" action="index"> ver Tarea</s:a>
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
				
				<td><img src="${tarea.audio }" width="120" height="100"></td>
				<td> 
					<s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tarea.id }</s:param>
					</s:url>
					<s:a href="%{url_edit}" >Editar</s:a> | 
					<s:url var="url_delete" namespace="/tarea" action="delete"> 
						<s:param name="id">${tarea.id }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('�ESTAS SEGURO?')">Borrar</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>
		
	

</body>
</html>