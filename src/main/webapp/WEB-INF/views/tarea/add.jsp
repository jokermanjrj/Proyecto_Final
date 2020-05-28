<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<jsp:include page="form.css"/>

</style>

</head>
<body>

	<!-- TITULO -->
		<div style="background-color:grey; margin:0px; padding: 20px;">
		<h1 style="text-align:center;">A�ADIR TAREA</h1>
			<ul>
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
					</s:url>
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>
			  <li><a href="#news">Alumnos</a></li>

			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>

	
<div class="container">
		<s:set var="usuario">${sessionScope.id }</s:set>
		<s:property value="#usuario"/>
	<s:form method="post" namespace="/tarea" action="save" enctype="multipart/form-data" style="width: 100%;">
		<s:textfield label="Titulo" name="tarea.titulo" placeholder="Titulo"></s:textfield>
		<s:textarea label="descripcion" name="tarea.descripcion" placeholder="Descripci�n" style="height:200px;"></s:textarea>
		<s:textfield label="fecha" name="tarea.fecha" placeholder="Fecha"></s:textfield>
		<s:file label="Seleccione imagen" name="fileUpload"></s:file>
		<s:submit value="Save" align="left"></s:submit>
		<s:hidden name="tarea.id_usuario" value="%{#usuario}"></s:hidden>
	</s:form>
</div>

</body>
</html>