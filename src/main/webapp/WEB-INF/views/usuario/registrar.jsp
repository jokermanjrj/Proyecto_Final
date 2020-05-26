<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Uusario</title>
<style>

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
  padding: 20px;
  margin-top: 15%;
  margin-left: 25%;
  width: 50%;
  

}

.boton {
	margin-right: 50px;
}

</style>
</head>
<body>
<div class="container">
	<h3 style="text-align: center;">Inserte datos</h3>
		<s:form methof="post" namespace="/usuario" action="save" style="width: 100%;">
		<s:textfield  name="usuario.correo" placeholder="correo" class="boton"></s:textfield>
		<s:textfield  name="usuario.pasword" placeholder="contraseña" class="boton"></s:textfield>
		
		<s:submit value="Save" align="left"></s:submit>
	</s:form>
</div>
</body>
</html>