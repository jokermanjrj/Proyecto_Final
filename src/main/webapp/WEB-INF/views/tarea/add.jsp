<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: red;">

	<h3>Tareas Info</h3>
		<s:form methof="post" namespace="/tarea" action="save">
		<s:textfield label="id_usuario" name="tarea.id_usuario"></s:textfield>
		<s:textfield label="Titulo" name="tarea.titulo"></s:textfield>
		<s:textfield label="descripcion" name="tarea.descripcion"></s:textfield>
		<s:textfield label="fecha" name="tarea.fecha"></s:textfield>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>

</body>
</html>