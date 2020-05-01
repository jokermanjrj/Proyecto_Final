<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Tarea Info</h3>
	<s:form methof="post" namespace="/tarea" action="update">
		<s:textfield label="id_usuario" name="tarea.id_usuario"></s:textfield>
		<s:textfield label="Titulo" name="tarea.titulo"></s:textfield>
		<s:textfield label="nota" name="tarea.nota"></s:textfield>
		<s:textfield label="fechaInicio" name="tarea.fechaInicio"></s:textfield>
		<s:textfield label="FEchaFinal" name="tarea.fechaFinal"></s:textfield>
	
		<s:submit value="Save" align="left"></s:submit>
		<s:hidden name="tarea.id"></s:hidden>
	</s:form>

</body>
</html>