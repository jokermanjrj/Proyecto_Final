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
	<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
	<div style="background-color:grey; margin:0px; padding: 20px;">
		<h1 style="text-align:center;">EDITAR TAREA</h1>
			<ul>
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.usuario.getId() }</s:param>
					</s:url>
			  <li><s:a namespace="/tarea" action="calendar"> Calendario</s:a></li>

			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
	
<div class="container">
<<<<<<< refs/remotes/origin/master
	<s:set var="usuario">${sessionScope.usuario.getId() }</s:set>
	<s:form methof="post" namespace="/tarea" action="update" style="width: 100%;" theme="simple">
=======
	<s:set var="usuario">${sessionScope.id }</s:set>
	<s:form methof="post" namespace="/tarea" action="update" style="width: 100%;" theme="simple">

>>>>>>> 0.0.31
	
		<s:textfield name="tarea.titulo" placeholder="Titulo" class="campo"></s:textfield>
		<s:textarea name="tarea.descripcion" placeholder="Titulo" class="campo"></s:textarea>
		<s:textfield name="tarea.fecha" placeholder="2020-05-02" class="campo"></s:textfield>
		<br>
		<s:submit value="Save" align="left" class="campo"></s:submit>
		<s:hidden name="tarea.id_usuario" value="%{#usuario}"></s:hidden>
		<s:hidden name="tarea.id"></s:hidden>
		
	</s:form>
</div>

</body>
</html>