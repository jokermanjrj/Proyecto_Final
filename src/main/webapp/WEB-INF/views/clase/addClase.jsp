<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir clase</title>
<style>
<jsp:include page="../tarea/form.css"/>

</style>

</head>
<body>
	<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">
			
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
			</s:url>
			<s:url var="usuario_url" namespace="/tarea" action="calendar">
					<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
				</s:url>
			  <li><s:a href="%{usuario_url}"> Calendario</s:a></li>
			  <li><a>Inicio</a></li>
			  
			  <li><img src="../usuario/prueba.jpg" width="" height=""></li>
			  
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
<div class="container">
	<s:form methof="post" namespace="/clase" action="save" enctype="multipart/form-data" theme="simple" style="width: 50%;">
	
		<s:file label="Seleccione archivo" name="fileUpload"></s:file>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>
</div>
</body>
</html>