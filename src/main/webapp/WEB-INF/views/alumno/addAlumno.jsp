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

		<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>
			  <li><a href="#news">Alumnos</a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	<s:form methof="post" namespace="/alumno" action="save" theme="simple">
	
		<s:textfield label="Nombre del alumno" name="alumno.nombre_alumno"></s:textfield>
		<s:textfield label="Apellido del alumno" name="alumno.apellido_alumno"></s:textfield>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>

</body>
</html>