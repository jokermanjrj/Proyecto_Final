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
	<s:form methof="post" namespace="/alumno" action="update">
	
		<s:textfield label="Nombre del alumno" name="alumno.nombre_alumno"></s:textfield>
		<s:textfield label="Apellido del alumno" name="alumno.apellido_alumno"></s:textfield>
	
		<s:submit value="Save" align="left"></s:submit>
		<s:hidden name="alumno.id"></s:hidden>
		
	</s:form>
</body>
</html>