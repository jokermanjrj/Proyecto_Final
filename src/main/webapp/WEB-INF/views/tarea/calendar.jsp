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
	width: 70%;
	border: 1px solid #ddd;
	background: #f1f1f1;
	overflow-y: scroll;
}
#mensajes {
	height: auto;
}

.container_1 {
	background-color: grey;
	min-width: 100%;
	min-height: 100px;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin: 10px;
  width: 70%;
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