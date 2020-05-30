<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<style>
<jsp:include page="form.css"/>
</style>
<meta charset="ISO-8859-1" >
<title>Calendar</title>
    <!--  <link href="./css/main.css" rel="stylesheet" type="text/css" />-->
</head>
<body style="margin:0px;">

	<!-- TITULO -->
		<div style="background-color:grey; margin:0px;">
			<ul>
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
					</s:url>
			  <li><s:a href="%{url_add}"> Añadir Tarea</s:a></li>
			  <li><a href="#news">Alumnos</a></li>

			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
		
		
<!-- CALENDARIO -->	
<div class=container_1>
	<h1 style="text-align: center;">calendario</h1>

	<c:forEach var="dias" items="${calendario.getMeses()}">
		<p>${calendario.getMeses()}</p>
		<p>${calendario.meses[1].getDias()}</p>
		
	</c:forEach>
</div>


</body>
</html>