<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Alumno</title>
<style>
<jsp:include page="../tarea/form.css"/>
</style>
</head>
<body>
<<<<<<< refs/remotes/origin/master
<<<<<<< refs/remotes/origin/master
=======
>>>>>>> 0.0.31

		<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			<s:url var="usuario_url" namespace="/tarea" action="calendar">
					<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
				</s:url>
			  <li><s:a href="%{usuario_url}"> Calendario</s:a></li>
			  <li><a href="#news">Alumnos</a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	<s:set var="idClase">${id}</s:set>
	<s:form methof="post" namespace="/alumno" action="save" enctype="multipart/form-data" theme="simple">
	
=======
	<h3>Añadir alumno  ${id}</h3>
	<s:set var="idClase">${id}</s:set>
	<s:form method="post" namespace="/alumno" action="save" enctype="multipart/form-data" style="width: 100%;">
		
>>>>>>> 0.0.26
		<s:file label="Seleccione archivo" name="fileUpload"></s:file>
		
		<s:submit value="Save" align="left"></s:submit>
		<s:hidden name="id" value="%{#idClase}"></s:hidden>
	</s:form>
<<<<<<< refs/remotes/origin/master
=======
	
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
					<s:a href="%{url_delete}" onclick="return confirm('ï¿½ESTAS SEGURO?')">Borrar</s:a>
				</td>
			</tr>
		</c:forEach>
	</table>
>>>>>>> 0.0.31

</body>
</html>