<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Uusario</title>
</head>
<body>

	<h3>Inserte datos</h3>
		<s:form methof="post" namespace="/usuario" action="save">
		<s:textfield label="Correo" name="usuario.correo"></s:textfield>
		<s:textfield label="Contraseña" name="usuario.pasword"></s:textfield>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>

</body>
</html>