<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- CSS de Bootstrap -->
<link href="libs/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="libs/css/style.css" rel="stylesheet" media="screen">
   
<body>
<h3>Actualizar producto</h3>


	<div class="container-fluid">
		<form name="formActualizarProducto" method="get" action="ControladorProductos">
		  <input type="hidden" name="instruccion" value="actualizarBBDD">
		  <input type="hidden" name="codArticulo" value="${ProductoActualizar.codArticulo}">
		  
		  <!--
		  <div class="form-group">
		    <label for="codArticulo">Cod. Articulo</label>
		    <input type="text" class="form-control" name="codArticulo" id="codArticulo" placeholder="Cod.Articulo">
		  </div>
		    -->
		  <div class="form-group">
		    <label for="seccion">Seccion</label>
		    <input type="text" class="form-control" name="seccion" id="seccion" placeholder="Seccion" value="${ProductoActualizar.seccion}">
		  </div>
		  <div class="form-group">
		    <label for="nombreArticulo">Nombre Articulo</label>
		    <input type="text" class="form-control" name="nombreArticulo" id="nombreArticulo" placeholder="Nombre Articulo" value="${ProductoActualizar.nombreArticulo}">
		  </div>
		  <div class="form-group">
		    <label for="precio">Precio</label>
		    <input type="text" class="form-control" name="precio" id="precio" placeholder="Precio" value="${ProductoActualizar.precio}">
		  </div>
		  <div class="form-group">
		    <label for="fecha">Fecha</label>
		    <input type="text" class="form-control" name="fecha" id="fecha" placeholder="Fecha" value="${ProductoActualizar.fecha}">
		  </div>
		  <div class="form-group">
		    <label for="importado">Importado</label>
		    <input type="text" class="form-control" name="importado" id="importado" placeholder="Importado" value="${ProductoActualizar.importado}">
		  </div>		  
		  <button type="submit" class="btn btn-primary">Actualizar</button>
		</form>
		
	</div>


<!-- Librería jQuery requerida por los plugins de JavaScript -->
<script src="http://code.jquery.com/jquery.js"></script>

<!-- JS de Bootstrap -->
<script src="libs/js/bootstrap.min.js"></script>

</body>
</html>