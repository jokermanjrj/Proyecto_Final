<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Alumno</title>
</head>
<body>
<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
<h1>Rellene los campos correctamente</h1>
<s:set var="idClase">${clase.idClase}</s:set>
	<s:form methof="post" namespace="/alumno" action="update">
	
		<s:textfield label="Nombre del alumno" name="alumno.nombre_alumno"></s:textfield>
		<s:textfield label="Apellido del alumno" name="alumno.apellido_alumno"></s:textfield>
	
		<s:submit value="Guardar" align="left"></s:submit>
		<s:hidden name="alumno.id"></s:hidden>
		<s:hidden name="idClase" value="%{#idClase}"></s:hidden>
		
		
	</s:form>
</body>
</html>