<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Clase</title>
</head>
<body>
	<s:form methof="post" namespace="/clase" action="update">
	
		<s:textfield label="nombre de la clase" name="clase.nombre_clase"></s:textfield>

	
		<s:submit value="Save" align="left"></s:submit>
		<s:hidden name="clase.idClase"></s:hidden>
		
	</s:form>
</body>
</html>