<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
<jsp:include page="../tarea/form.css"/>

</style>

</head>
<body>

	<!-- TITULO -->
	<div style="background-color:grey; margin:0px; ">
			<ul style="padding: 20px;">

			
<<<<<<< refs/remotes/origin/master
			<s:url var="url_add" namespace="/tarea" action="add"> 
							<s:param name="id_usuario">${sessionScope.usuario.getId() }</s:param>
			</s:url>
			<s:url var="usuario_url" namespace="/tarea" action="calendar">
					<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
				</s:url>
			
			  <li><s:a href="%{usuario_url}"> Calendario</s:a></li>
=======
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>
>>>>>>> 0.0.31
			  <li><a>Inicio</a></li>
			  <!-- Accion para cerrar sesiï¿½n que llama a la acciï¿½n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
	</div>
		
<div class="container">
		<s:set var="usuario">${sessionScope.usuario.getId()}</s:set>
		<s:property value="#usuario"/>
	<s:form method="post" namespace="/tarea" action="save" enctype="multipart/form-data" style="width: 100%;" theme="simple">
		<s:textfield  name="tarea.titulo" placeholder="Titulo" class="campo"></s:textfield>
		<s:textarea  name="tarea.descripcion" placeholder="Descripción" style="height:200px;" class="campo"></s:textarea>
		<s:date  name="tarea.fecha"  format = "dd/MM/yyyy"></s:date>
		<br>
		<s:file label="Seleccione imagen" name="fileUpload" accept="image/*" class="campo"></s:file>
		<br>
		<s:submit value="Save" class="campo"></s:submit>
		<s:hidden name="tarea.id_usuario" value="%{#usuario}"></s:hidden>
	</s:form>
</div>

</body>
</html>