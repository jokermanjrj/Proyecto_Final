<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" >
<title>Calendar</title>
    <!--  <link href="./css/main.css" rel="stylesheet" type="text/css" />-->
</head>
<body>
	<h1>CALENDARIO</h1>
	<s:a namespace="/tarea" action="add"> Añadir Tarea</s:a>
	

		
	
	<!-- LISTA DE DIAS -->
 	<c:forEach var="dias" items="${calendario.getDias()}">
    <p>${dias.dia}/${dias.mes}/${dias.año}</p>
    
    <c:forEach var="tarea" items="${tareas }">
	
					<s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tarea.id }</s:param>
					</s:url>
						
						<s:a href="%{url_edit}" >${tarea.id } ${tarea.id_usuario } ${tarea.titulo } ${tarea.descripcion } ${tarea.fecha } ${tarea.audio }</s:a> | 
						
					<s:url var="url_delete" namespace="/tarea" action="delete"> 
						<s:param name="id">${tarea.id }</s:param>
					</s:url>
						
						<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')">Borrar</s:a>
						
				
		</c:forEach>
    </c:forEach> 
    
</body>
</html>