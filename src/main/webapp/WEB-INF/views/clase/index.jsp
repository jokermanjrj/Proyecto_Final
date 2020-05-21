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
</head>
<body>
	<h1>Lista de clases</h1>
	
	<s:a namespace="/clase" action="add"> Añadir Tarea</s:a>
	
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