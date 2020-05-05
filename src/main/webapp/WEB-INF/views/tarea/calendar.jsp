<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendar</title>
</head>
<body>
	<h1>CALENDARIO</h1>
	<s:a namespace="/tarea" action="add"> Añadir Tarea</s:a>
	 <table>
      <tr><th>lunes</th><th>martes</th><th>miércoles</th><th>jueves</th><th>viernes</th><th>sábado</th><th>domingo</th></tr>
 	</table>
 	
 	<c:forEach var="calendario" items="${calendario}">
    <td>${calendario}</td>
    </c:forEach>
    
</body>
</html>