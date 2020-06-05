<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<style>
<jsp:include page="../tarea/inicio.css"/>
</style>
</head>
<body>
	<div class="containerLogo">
	<s:url var="usuario_url" namespace="/tarea" action="index">
			<s:param name="id_usuario" >${sessionScope.usuario.getId() }</s:param>
	</s:url>
	 <s:a href="%{usuario_url}"><img class="logo" alt="Logotipo-OrganizaT" src="../assets/uploads/logoProyecto.png"/> </s:a>
	</div>
</body>
</html>