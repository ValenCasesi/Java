<%@page import="Entities.Producto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>UTNWEB</title>
</head>
<body>
	<%
		String idProducto=request.getParameter("idProducto");
		String idCategoria=request.getParameter("idCategoria");
		String descripcion=request.getParameter("descripcion");
		String precio=request.getParameter("precio");
		String stock=request.getParameter("stock");
		// String img=request.getParameter("img");
	%>
	  <form class="row g-3" action="abmcProductos" method="get">
  <div class="col-12">
    <label for="inputAddress" class="form-label">idProducto</label>
    <input type="text" class="form-control" id="idProducto" name="idProducto" readonly value="<%=idProducto%>" placeholder="Ingrese IdProducto" required>
  </div>
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">idCategoria</label>
    <input type="text" class="form-control" id="idCategoria" name="idCategoria" value="<%=idCategoria%>" placeholder="Ingrese idCategoria" required>
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">Descripcion</label>
    <input type="text" class="form-control" id="descripcion" name="descripcion" value="<%=descripcion%>" placeholder="Ingrese descripcion" required>
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">Precio</label>
    <input type="text" class="form-control" id="precio" name="precio" value="<%=precio%>" placeholder="Ingrese precio" required>
  </div>
  <div class="col-12">
    <label for="inputAddress2" class="form-label">Stock</label>
    <input type="text" class="form-control" id="stock" name="stock" value="<%=stock%>" placeholder="Ingrese stock" required>
  </div>
  
  <div class="col-12">
    <input type="submit" class="btn btn-primary" name="accion" value="actualizar"> 
  </div>
  <div class="d-grid gap-2 d-md-block">
  		<a href="javascript:history.back()"><button type="button" class="btn btn-danger">Cancelar</button></a>
	</div>
</form>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>