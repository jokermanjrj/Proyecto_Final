<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Usario</title>
<style>
<jsp:include page="estilo.css"/>
</style>
</head>
<body class="fondo">

<div class="container">

	<h1 style="text-align: center;">Inserte datos</h1>
	<s:form method="post" namespace="/usuario" action="save" style="width: 100%;">
		<s:textfield  name="usuario.correo" placeholder="correo" class="boton"></s:textfield>
		<s:password  name="usuario.pasword" placeholder="contraseña" class="boton"></s:password>
		<s:submit value="Save"></s:submit>
	</s:form>
	
</div>
</body>
</html>