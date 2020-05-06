
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" >
<title>Calendar</title>
    <link href="./css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>CALENDARIO</h1>
	<s:a namespace="/tarea" action="add"> Añadir Tarea</s:a>
	 <table>
      <tr><th>lunes</th><th>martes</th><th>miercoles</th><th>jueves</th><th>viernes</th><th>sabado</th><th>domingo</th></tr>
 	</table>
 	
 	<c:forEach var="dias" items="${calendario.getDias()}">
    <p>${dias.dia}/${dias.mes}/${dias.año}</p>
    
    </c:forEach>
    
</body>
</html>