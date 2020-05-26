<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring and Struts 2 Integration</title>
<style>
body {
  background-image: url("./prueba.jpg");

}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}


* {
  box-sizing: border-box;
}

input[type=text] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}


input[type=submit] {
  background-color: grey;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: black;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  background-image: url("./prueba.jpg");
  padding: 20px;
  margin-top: 10px;
  margin-left: 25%;
  margin-right: 25%;

}



</style>
</head>
<body>



<div class="container">
	<p style="color: red; text-align: center;">${errorMessage }</p>
	<s:form method="post" namespace="/usuario" action="identificarse"  style="width: 100%;">
		<s:textfield name="correo" placeholder="correo" style="align-text: center;"></s:textfield>
		<s:textfield name="pasword" placeholder="contrase�a" style=""></s:textfield>
	<div style="text-align:center">
		<s:submit value="Identificarse" style="margin-left: 45%;" ></s:submit>
	</div>
	</s:form>
	<s:a namespace="/usuario" action="register" style="text-align: center;">�Qui�res registrarte?</s:a>
</div>


	
<!--  	<table border="1">
		<tr>
			<th>Id</th>
			<th>Correo</th>
			<th>Contrase�a</th>
			
		</tr>
		<c:forEach var="usuario" items="${usuarios }">
			<tr>
				<td>${usuario.id }</td>
				<td>${usuario.correo }</td>
				<td>${usuario.pasword }</td>
			
			</tr>
		</c:forEach>
	</table>
-->
</body>
</html>