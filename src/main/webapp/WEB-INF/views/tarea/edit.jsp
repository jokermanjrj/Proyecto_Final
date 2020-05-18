<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
</head>
<body style="margin: 0px;">

		<div style="background-color:grey; margin:0px; padding: 20px;">
		<h1 style="text-align:center;">EDITAR TAREA</h1>
			<ul>
  <li><s:a namespace="/tarea" action="add"> Añadir Tarea</s:a></li>
  <li><a href="#news">News</a></li>
  <li><a href="#contact">Contact</a></li>
  <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>
		</div>
	
	<div style="align-content: center;">		
		<s:form methof="post" namespace="/tarea" action="update">
			<s:textfield label="id_usuario" name="tarea.id_usuario"></s:textfield>
			<s:textfield label="Titulo" name="tarea.titulo"></s:textfield>
			<s:textfield label="nota" name="tarea.nota"></s:textfield>
			<s:textfield label="fechaInicio" name="tarea.fechaInicio"></s:textfield>
			<s:textfield label="FEchaFinal" name="tarea.fechaFinal"></s:textfield>
		
			<s:submit value="Save" align="left"></s:submit>
			<s:hidden name="tarea.id"></s:hidden>
		</s:form>
	</div>
</body>
</html>