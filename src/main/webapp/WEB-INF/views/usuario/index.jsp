<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring and Struts 2 Integration</title>
</head>
<body>

	<h3>Product List</h3>
	${errorMessage }
	<s:form method="post" namespace="/usuario" action="identificarse">
		<s:textfield label="Correo" name="correo"></s:textfield>
		<s:password label="Contraseña" name="pasword"></s:password>
		<s:submit value="Identificarse" align="left"></s:submit>
	</s:form>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Correo</th>
			<th>Contraseña</th>
			
		</tr>
		<c:forEach var="usuario" items="${usuarios }">
			<tr>
				<td>${usuario.id }</td>
				<td>${usuario.correo }</td>
				<td>${usuario.pasword }</td>
			
			</tr>
		</c:forEach>
	</table>

</body>
</html>