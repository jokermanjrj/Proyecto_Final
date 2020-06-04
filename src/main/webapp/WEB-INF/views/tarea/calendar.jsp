<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import='java.*'%>
<!DOCTYPE html>
<html>
<head>
<style>
<jsp:include page="form.css"/>
<jsp:include page="calendario.css"/>
</style>
<meta charset="ISO-8859-1" >
<title>Calendar</title>
    <!--  <link href="./css/main.css" rel="stylesheet" type="text/css" />-->
</head>
<body style="margin:0px;">

	<!-- TITULO -->
		<div style="background-color:grey; margin:0px;">
			<ul>
<<<<<<< refs/remotes/origin/master
			 <li><s:a namespace="/tarea" action="add"> A�adir Tarea</s:a></li>
=======
			<s:url var="url_add" namespace="/tarea" action="add"> 
						<s:param name="id_usuario">${sessionScope.id }</s:param>
					</s:url>
			  <li><s:a namespace="/tarea" action="add"> A�adir Tarea</s:a></li>
			  <li><a href="#news">Alumnos</a></li>
<<<<<<< refs/remotes/origin/master
<<<<<<< refs/remotes/origin/master

>>>>>>> 0.0.26
=======
			  <li><s:a href="%{url_add}"> A�adir Tarea</s:a></li>
>>>>>>> 0.0.31
=======
			  <li><s:a href="%{url_add}"> A�adir Tarea</s:a></li>
>>>>>>> 0.0.32
			  <!-- Accion para cerrar sesi�n que llama a la acci�n exit de user y de vuelve el login-->
			  <li style="float:right"><s:a namespace="/user" action="exit">Cerrar Sesion</s:a></li>
			</ul>
		</div>
<!-- CALENDARIO -->	
<!-- <div class=container_1>
	<h1 style="text-align: center;">calendario</h1>

	<c:forEach var="dias" items="${calendario.getMeses()}">
		<p>${calendario.getMeses()}</p>
		<p>${calendario.meses[1].getDias()}</p>
		
	</c:forEach>
</div>-->
  <c:forEach var="tarea" items="${tareas }">
				<td class="column">${tarea.fecha }</td>
			
		</c:forEach>

<script>
var mes_text = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

var dia_text = ["Dom", "Lun", "Mar", "Mie", "Juv", "Vie", "Sab"];

var contador = 0;
estructurar();


function estructurar(contador) {
 
  for (m = 0; m <= 11; m++) {
    //Mes
    let mes = document.createElement("DIV");
    mes.className = "mes";
    
    document.body.appendChild(mes);
    //Tabla
    let tabla_mes = document.createElement("TABLE");
    tabla_mes.className = "tabla_mes";
    mes.appendChild(tabla_mes);
    //Título
    let titulo = document.createElement("CAPTION");
    titulo.className = "titulo";
    titulo.innerText = mes_text[m];
    tabla_mes.appendChild(titulo);
    //Cabecera
    let cabecera = document.createElement("THEAD");
    tabla_mes.appendChild(cabecera);
    let fila = document.createElement("TR");
    cabecera.appendChild(fila);
    for (d = 0; d < 7; d++) {
      let dia = document.createElement("TH");
      dia.className= "dias";
      dia.innerText = dia_text[d];
      fila.appendChild(dia);
    }
    //Cuerpo
    let cuerpo = document.createElement("TBODY");
    tabla_mes.appendChild(cuerpo);
    for (f = 0; f < 6; f++) {
      let fila = document.createElement("TR");
      cuerpo.appendChild(fila);
      for (d = 0; d < 7; d++) {
        let dia = document.createElement("TD");
        dia.innerText = "";
        fila.appendChild(dia);
      }     
    }    
  }
}

numerar();

function numerar() {
  for (i = 1; i < 366; i++) {
    let fecha = fechaPorDia(2020, i);
    let mes = fecha.getMonth();
    let select_tabla = document.getElementsByClassName('tabla_mes')[mes];
    let dia = fecha.getDate()
    let dia_semana = fecha.getDay();
    if (dia == 1) {var sem = 0;}
    select_tabla.children[2].children[sem].children[dia_semana].innerText = dia;
    if (dia_semana == 6) { sem = sem + 1; }
  }
}

function fechaPorDia(a�o, dia) {
  var date = new Date(a�o, 0);
  return new Date(date.setDate(dia));
}
</script>

</body>
</html>