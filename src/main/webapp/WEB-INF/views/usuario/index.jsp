<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<style>
<jsp:include page="estilo.css"/>

</style>

</head>
<body style="background: url(./assets/uploads/FondoOrganizaT2.png) no-repeat center center fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;">

<div class="container">
	<h1 style="text-align: center;">LOGIN</h1>
	<p style="color: red; text-align: center;">${errorMessage }</p>
	
	<s:form method="post" namespace="/usuario" action="identificarse"  style="width: 100%;">
		<s:textfield name="correo" placeholder="correo" style="align-text: center;"></s:textfield>
		<s:password name="pasword" placeholder="contraseña" style=""></s:password>
	<div style="margin-left: 25%;">
		<s:submit value="Identificarse" ></s:submit>
	</div>
	</s:form>
	<s:a namespace="/usuario" action="register" style="text-align: center;">¿Quieres registrarte?</s:a>
</div>

</body>
</html>