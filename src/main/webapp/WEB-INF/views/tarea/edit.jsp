<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
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
	<div style="background-color:grey; margin:0px;">
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

	<s:set var="usuario">${sessionScope.usuario.getId() }</s:set>
	<s:form methof="post" namespace="/tarea" action="update" style="width: 100%;" theme="simple">

	
		<s:textfield name="tarea.titulo" placeholder="Titulo" class="campo"></s:textfield>
		<s:textarea name="tarea.descripcion" placeholder="Titulo" class="campo"></s:textarea>
		<br>
		<input type="date"  name="tarea.fecha" ></input>
		<br>
		<br>
		<s:file label="Seleccione imagen" name="fileUpload" accept="image/*" class="campo"></s:file>
		<s:submit value="Guardar" align="left" class="campo"></s:submit>
		<s:hidden name="tarea.id_usuario" value="%{#usuario}"></s:hidden>
		<s:hidden name="tarea.id"></s:hidden>
		
	</s:form>
</div>

</body>
</html>