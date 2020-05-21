<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Alumno</title>
</head>
<body>
	<h3>Alumno Info</h3>
	<s:form methof="post" namespace="/alumno" action="save">
	
		<s:textfield label="Nombre del alumno" name="alumno.nombre_alumno"></s:textfield>
		<s:textfield label="Apellido del alumno" name="alumno.apellido_alumno"></s:textfield>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>

</body>
</html>