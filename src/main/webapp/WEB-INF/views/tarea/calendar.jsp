<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<style>
#global {
	height: 800px;
	width: 50%;
	border: 1px solid #ddd;
	background: #f1f1f1;
	overflow-y: scroll;
}
#mensajes {
	height: auto;
}
.texto {
	padding:4px;
	background:#fff;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}

</style>
<meta charset="ISO-8859-1" >
<title>Calendar</title>
    <!--  <link href="./css/main.css" rel="stylesheet" type="text/css" />-->
</head>
<body style="margin:0px;">

	<!-- TITULO -->
		<div style="background-color:grey; margin:0px; padding: 20px;">
		<h1 style="text-align:center;">EDITAR TAREA</h1>
			<ul>
			  <li><s:a namespace="/tarea" action="add"> Añadir Tarea</s:a></li>
			  <li><a href="#news">News</a></li>
			  <li><a href="#contact">Contact</a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
	
	<!-- LISTA DE DIAS -->
	<div id="global" style="display: flex; flex-wrap: wrap;"> 	
	 	<c:forEach var="dias" items="${calendario.getDias()}">
	 	<div  id="mensaje" style="background-color: grey; margin: 10px; padding: 5px; min-width: 100%;">
		 	<p>${dias.dia}/${dias.mes}/${dias.año}</p>
		 	
		 	<c:set var="dia" value="${dias.año}-${dias.mes}-${dias.dia}" />
		    
		    <c:forEach var="tarea" items="${tareas }">
				    <!--<p>${dia}</p>
				    <p>${tarea.fecha}</p>-->
		    	<c:if test="${dia == tarea.fecha }">
					<ul>
					  <li><s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tarea.id }</s:param>
							</s:url>						
							<s:a href="%{url_edit}" >${tarea.id } ${tarea.titulo } ${tarea.descripcion } ${tarea.fecha } ${tarea.audio }</s:a> 
						</li>
						<li>
						<s:url var="url_delete" namespace="/tarea" action="delete"> 
							<s:param name="id">${tarea.id }</s:param>
							</s:url>
							<s:a href="%{url_delete}" onclick="return confirm('ï¿½ESTAS SEGURO?')">Borrar</s:a>	
						</li>
					</ul>
							
				</c:if>
			</c:forEach>
		</div>
	    </c:forEach> 
		
    </div>
    
</body>
</html>