<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring and Struts 2 Integration</title>
<style>
<jsp:include page="estilo.css"/>

</style>

</head>
<body>



<div class="container">
	<p style="color: red; text-align: center;">${errorMessage }</p>
	<s:form method="post" namespace="/usuario" action="identificarse"  style="width: 100%;">
		<s:textfield name="correo" placeholder="correo" style="align-text: center;"></s:textfield>
		<s:textfield name="pasword" placeholder="contraseña" style=""></s:textfield>
	<div style="margin-left: 25%;">
		<s:submit value="Identificarse" style="margin-left: 45%;" ></s:submit>
	</div>
	</s:form>
	<s:a namespace="/usuario" action="register" style="text-align: center;">¿Quieres registrarte?</s:a>
</div>

</body>
</html>