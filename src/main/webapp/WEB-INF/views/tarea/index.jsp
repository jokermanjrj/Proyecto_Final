<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notas</title>
<style>

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

.row {
	display: flex;
}
.column_title {
border-radius: 15px;
text-align: center;
background-color: grey;
min-width: 150px;
height: 100px;
font-size: 25px;

}

.column {
font-size: 20px;
text-align: center;

}
</style>
</head>
<body>

	<!-- TITULO -->
		<div style="background-color:grey; margin:0px; padding: 20px;">
		<h1 style="text-align:center;">INICIO</h1>
			<ul>
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
					</s:url>
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>
			  <li><s:a namespace="/tarea" action="add"> Añadir Tarea</s:a></li>
			  <li><s:a namespace="/clase" action="listar">Clases</s:a></li>
			 <li><s:a namespace="/alumno" action="listar">Alumnos</s:a></li>
			 <li><s:a namespace="/tarea" action="index"> ver Tarea</s:a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
	

	<table border="1">
	<!--COMENTARIO DE FECHT -->
		<tr>
			<th class="column_title">Id</th>
			<th class="column_title">Id_usuario</th>
			<th class="column_title">titulo</th>
			<th class="column_title">Nota</th>
			<th class="column_title">Fecha</th>
			<th class="column_title">Audio</th>
		</tr>
		<c:forEach var="tarea" items="${tareas }">
			<tr>
				<td class="column">${tarea.id }</td>
				<td class="column">${tarea.id_usuario }</td>
				<td class="column">${tarea.titulo }</td>
				<td class="column">${tarea.descripcion }</td>
				<td class="column">${tarea.fecha }</td>
				
				<td><img src="${tarea.audio }" width="120" height="100"></td>
				<td> 
					<s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tarea.id }</s:param>
					</s:url>
					<s:a href="%{url_edit}" >Editar</s:a> | 
					<s:url var="url_delete" namespace="/tarea" action="delete"> 
						<s:param name="id">${tarea.id }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('ï¿½ESTAS SEGURO?')">Borrar</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>

	

</body>
</html>