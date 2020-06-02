<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alumnos </title>
</head>
<body>
		
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
					<s:a href="%{url_edit}" >Editar</s:a> | 
					<s:url var="url_delete" namespace="/alumno" action="delete"> 
						<s:param name="id">${alumno.id }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')">Borrar</s:a>
				</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>