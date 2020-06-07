<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id clase</th>
			<th>Id alumno</th>
		</tr>
		<c:forEach var="cursa" items="${cursas }">
			<tr>
				<td>${cursa.clase_id }</td>
				<td>${cursa.alumno_id }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>