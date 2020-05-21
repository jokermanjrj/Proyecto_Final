<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir clase</title>
</head>
<body>
	<h3>Clase Info</h3>
	<s:form methof="post" namespace="/clase" action="save">
	
		<s:textfield label="Nombre de la clase" name="clase.nombre_clase"></s:textfield>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>

</body>
</html>