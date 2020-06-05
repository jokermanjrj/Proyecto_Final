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
			  <li><s:a namespace="/tarea" action="add"> A�adir Tarea</s:a></li>
			  <li><s:a namespace="/clase" action="listar">Clases</s:a></li>
			 <li><s:a namespace="/alumno" action="listar">Alumnos</s:a></li>
			 <s:set var="usuario">${sessionScope.usuario.getId() }</s:set>
			<s:url var="usuario_url" namespace="/tarea" action="index">
				<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
			</s:url>
			 <li><s:a href="%{usuario_url}"> ver Tareas</s:a></li>
			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
	

	<table border="1" id="tabla">
	<!--COMENTARIO DE FECHA -->
		<tr>
			<th class="column">Id</th>
			<th class="column">Id_usuario</th>
			<th class="column">titulo</th>
			<th class="column">Nota</th>
			<th class="column">Fecha</th>
			<th class="column">Imagen</th>
		</tr>
		<c:if test="${tareas.size() > 0 }">
		<c:forEach begin="0" end="${tareas.size() -1}" var="cur">
			<tr>
				<td class="column">${tareas[cur].getId() }</td>
				<td class="column">${tareas[cur].getId_usuario() }</td>
				<td class="column">${tareas[cur].getTitulo() }</td>
				<td class="column">${tareas[cur].getDescripcion() }</td>
				<td class="column">${tareas[cur].getFecha() }</td>
				<c:if test="${imagenes[cur] != null }">
					<td><img class="imagenes" src="${ imagenes[cur]}"/></td>
				</c:if>
				<c:if test="${imagenes[cur] == null }">
					<td></td>
				</c:if>
				<td> 
					<s:url var="url_edit" namespace="/tarea" action="edit"> 
							<s:param name="id">${tareas[cur].getId() }</s:param>
					</s:url>
					<s:a href="%{url_edit}" ><img class="icon" src="../assets/uploads/editar.png"/></s:a>
					<s:url var="url_delete" namespace="/tarea" action="delete"> 
						<s:param name="id">${tareas[cur].getId() }</s:param>
					</s:url>
					<s:a href="%{url_delete}" onclick="return confirm('�ESTAS SEGURO?')"><img class="icon" src="../assets/uploads/eliminar.png"/></s:a>
				</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>


	

</body>
</html>