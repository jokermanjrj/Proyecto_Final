<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:include value="/WEB-INF/views/Inicio/home.jsp"></s:include>
	<c:forEach var="clase" items="${clases }">
		<ul>
			<li>
				<s:url var="url_clase" namespace="/alumno" action="add">
					<s:param name="id">${clase.idClase} </s:param>
				</s:url>
				<s:a href="%{url_clase}">${clase.nombre_clase }</s:a>
			</li>
		</ul>
	</c:forEach>
	
	<s:form method="post" namespace="/clase" action="guardarRelacion">
	<c:forEach var="clase" items="${clases }">
		<input type="checkbox" id="clase" name="nombre" value="${clase.nombre_clase }">
  		<label for="clase"> ${clase.nombre_clase }</label><br>
  		
  	</c:forEach>
  	<c:forEach var="alumno" items="${alumnos }">
  		<input type="checkbox" id="alumno" name="alumno" value="${alumno.nombre_alumno }">
  		<label for="clase"> ${alumno.nombre_alumno } ${alumno.apellido_alumno }</label><br>
  	</c:forEach>
  	<input type="submit" value="save">
	</s:form>
	
	
</body>
</html>