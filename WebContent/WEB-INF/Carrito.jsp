<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="Entities.LineaDePedido"%>
 <%@page import="Entities.Usuario"%>
 <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>UTNWEB</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:ital,wght@1,200&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:ital,wght@1,200&family=Oswald:wght@200&display=swap" rel="stylesheet">
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">	

<%
ArrayList<LineaDePedido> ldp = (ArrayList<LineaDePedido>) request.getAttribute("carrito");
Double tp = (Double) request.getAttribute("totalPagar");
Usuario u = (Usuario) session.getAttribute("usuario");
%>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><box-icon type='solid' name='store-alt'></box-icon></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="abmc?accion=inicio">INICIO</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">PRODUCTOS</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#">CONTACTANOS</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="abmc?accion=inicio">Seguir Comprando</a>
        </li>
  <% if(true){ %>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Administrar
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="abmc?accion=listar">Usuarios</a></li>
            <li><a class="dropdown-item" href="abmcProductos?accion=listar">Productos</a></li>
            <li><a class="dropdown-item" href="abmcCategorias?accion=listar">Categorias</a></li>
            <li><a class="dropdown-item" href="#">Pedidos</a></li>
           </ul>
            <% } %>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Cerrar Sesion</a>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item"><img src="img/usu.png" height="80" width="80"></a></li>
            <li><a class="dropdown-item">Ejemplo</a></li>
            <li><a class="dropdown-item">ejemplo@gmail.com</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="Signin?salida=salir">Salir</a></li>
    </ul>
  </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="buscar" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>

<div class="container mt-4">
	<h3>Carrito</h3>
	<br>
	<div class="row">
			<div class="col-sm-8">
			<% // ACA IRIA EL BOTON DE BORRAR TODO %>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ITEM</th>
							<th>DESCRIPCION</th>
							<th>PRECIO</th>
							<th>CANTIDAD</th>
							<th>SUBTOTAL</th>
							<th>ACCION</th>
						</tr>
					</thead>
					<tbody>
					<%
						for (LineaDePedido car : ldp) {
					%>
						<tr>
							<td><%= car.getNroldp() %></td>
							<td><%= car.getProd().getDescripcion() %></td>
							<td><%= car.getProd().getPrecio() %></td>
							<td>
								<input type="hidden" id="idprod" value="<%= car.getProd().getIdProducto() %>">
								<input type="number" min="1" id="Cantidad" class=" form-control text-center" value="<%= car.getCant()%>">
							</td>
							<td><%= car.getSubTot() %></td>
							<td><a id="btnDelete"
					href="abmcLdp?accion=delete&id=<%= car.getProd().getIdProducto() %>"><button
							type="button" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
</svg></button></a></td>
						</tr>
					<% } %>
					</tbody>
				
				
				</table>
			</div>
			<div class="col-sm-4">
				<div class="card">
					<div class="card-header">
					 <h3>Generar Compra</h3>
					</div>
					<div class="card-body">
						<label>Total Pagar:</label>
						<br>
						<input type="text" value="<%= tp %>" readonly class="from-control">
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-info btn-block">Realizar Pago</a>
						<a href="abmcPedido?accion=generarCompra"  class="btn btn-danger btn-block">Generar Compra</a>
					</div>
				</div>
			</div>
	</div>

</div>

<script src="js/funciones.js" type="text/javascript"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://unpkg.com/boxicons@2.0.9/dist/boxicons.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>