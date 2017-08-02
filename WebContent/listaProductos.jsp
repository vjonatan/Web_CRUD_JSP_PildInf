<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Productos</title>

<!-- CSS de Bootstrap -->
   <link href="libs/css/bootstrap.min.css" rel="stylesheet" media="screen">
   <link href="libs/css/style.css" rel="stylesheet" media="screen">

</head>
	
<body>

<div class="container-fluid-main">

	<div class="row">
		<button  class="btn btn-primary" onclick="window.location.href='insertar_registro.jsp'">Insertar Registro</button>
		<button  class="btn btn-default">Reestablecer</button>
	</div>

	
	<table class="table table-bordered">
		<tr>
			<th>Codigo Articulo</th>
			<th>Seccion</th>
			<th>Nombre Articulo</th>
			<th>Precio</th>
			<th>Fecha</th>
			<th>Importado</th>
			<th>Accion</th>
		</tr>
		
		<c:forEach var="tempProd" items="${LISTAPRODUCTOS}">
			
			<c:url var="linkTemp" value="ControladorProductos">
			
				<c:param name="instruccion" value="cargar"></c:param>
				<c:param name="CArticulo" value="${tempProd.codArticulo}"></c:param>
			
			</c:url>
		
			<tr>
				<td>${tempProd.codArticulo}</td>
				<td>${tempProd.seccion}</td>
				<td>${tempProd.nombreArticulo}</td>
				<td>${tempProd.precio}</td>
				<td>${tempProd.fecha}</td>
				<td>${tempProd.importado}</td>
				<td>
					<button class="btn btn-primary" onclick="window.location.href='${linkTemp}'">Edit</button>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</div>	

<!-- Librería jQuery requerida por los plugins de JavaScript -->
  <script src="http://code.jquery.com/jquery.js"></script>

<!-- JS de Bootstrap -->
  <script src="libs/js/bootstrap.min.js"></script>
</body>
</html>