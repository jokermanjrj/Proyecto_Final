<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Clase</title>
<jsp:include page="../tarea/form.css"/>
</head>
<body>

<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>
			  <li><a>Inicio</a></li>
			  
			  <li><img src="../usuario/prueba.jpg" width="" height=""></li>
			  
			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
	
	<s:form methof="post" namespace="/clase" action="update">
	
		<s:textfield label="nombre de la clase" name="clase.nombre_clase"></s:textfield>

	
		<s:submit value="Save" align="left"></s:submit>
		<s:hidden name="clase.idClase"></s:hidden>
		
	</s:form>
</body>
</html>