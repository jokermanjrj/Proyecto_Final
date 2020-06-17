<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Alumno</title>
<style>
<jsp:include page="../tarea/form.css"/>
</style>
</head>
<body>
<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
<h1>Rellene los campos correctamente</h1>
<s:set var="idClase">${clase.idClase}</s:set>
	<s:form methof="post" namespace="/alumno" action="update">
<div style="background-color:grey; margin:0px;">
			<ul>
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.usuario.getId() }</s:param>
					</s:url>
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>

			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
	

	<s:form methof="post" namespace="/alumno" action="update" theme="simple">
	
		<s:textfield label="Nombre del alumno" name="alumno.nombre_alumno" class="campo" width="250px"></s:textfield>
		<s:textfield label="Apellido del alumno" name="alumno.apellido_alumno" class="campo"></s:textfield>
	<br>
		<br>
		<s:submit value="Guardar" align="left"></s:submit>
		
		<s:hidden name="alumno.id"></s:hidden>
		<s:hidden name="idClase" value="%{#idClase}"></s:hidden>
		
		
	</s:form>
</body>
</html>