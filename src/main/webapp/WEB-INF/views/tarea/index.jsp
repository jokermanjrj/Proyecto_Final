<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notas</title>
<style>
<jsp:include page="inicio.css"/>
</style>
</head>
<body>
	<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
	<!-- TITULO -->
		<div style="background-color:grey; margin:0px;">
			<ul style="padding: 20px;">
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
					</s:url>
				<s:url var="usuario_url" namespace="/tarea" action="calendar">
					<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
				</s:url>
			  <li><s:a href="%{usuario_url}"> Calendario</s:a></li>
			  <li><s:a namespace="/tarea" action="add"> Añadir Tarea</s:a></li>
			  <li><s:a namespace="/clase" action="listar">Clases</s:a></li>
			 <li><s:a namespace="/alumno" action="listar">Alumnos</s:a></li>
			 <s:set var="usuario">${sessionScope.usuario.getId() }</s:set>
			<s:url var="usuario_url" namespace="/tarea" action="index">
				<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
			</s:url>
			 <li><s:a href="%{usuario_url}"> ver Tareas</s:a></li>
			  <!-- Accion para cerrar sesión que llama a la acciï¿½n exit de user y de vuelve el login-->

			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>

<div class="scrollbar">	

<s:url var="url_Report" namespace="/tarea" action="reportTarea">
<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
</s:url>
<s:a href="%{url_Report}">Reporte</s:a>
				
<s:form namespace="/tarea" action="Multidelete" methof="post">
	<table border="1" id="tabla">
	<!--COMENTARIO DE FECHA -->
		<tr>
			<th class="column">titulo</th>
			<th class="column">Nota</th>
			<th class="column">Fecha</th>
			<th class="column">Hora</th>
			<th class="column">Imagen</th>
			<th class="column">Dirección</th>
			
		</tr>
		<c:if test="${tareas.size() > 0 }">
		
		<c:forEach begin="0" end="${tareas.size() -1}" var="cur">
			<tr>
		
				<td class="column">${tareas[cur].getTitulo() }</td>
				<td class="column">${tareas[cur].getDescripcion() }</td>
				<td class="column">${tareas[cur].getFecha() }</td>
				<td class="column">${tareas[cur].getHora() }</td>
				<c:if test="${ imagenes[cur] !=null}">
					<td><img class="imagen" src="${ imagenes[cur]}"></td>
				</c:if >
				<c:if test="${ imagenes[cur] ==null}">
					<td></td>
				</c:if>
				<td class="column"><a href="https://www.google.com/search?q=${tareas[cur].getDireccion() }" target="popup">${tareas[cur].getDireccion() }</a></td>
				<td> 
					<s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tareas[cur].getId() }</s:param>
					</s:url>
					<s:a href="%{url_edit}" ><img class="icono" src="../assets/uploads/editar.png"></s:a>
					<s:url var="url_delete" namespace="/tarea" action="delete"> 
						<s:param name="id">${tareas[cur].getId() }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('¿ESTAS SEGURO?')"><img class="icono" src="../assets/uploads/eliminar.png"></s:a>
					<input type="checkbox" name="ids" value="${tareas[cur].getId() }">
       			 <label> Eliminar</label><br>
				</td>
			</tr>
		</c:forEach>
		
		</c:if>
	</table>
	
	<br>
  				<input type="submit" value="Submit">
</s:form>
</div>

</body>
</html>