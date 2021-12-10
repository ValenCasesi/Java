<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList" %>
<%@page import="Entities.Producto" %>
<%@page import="Entities.Categoria" %>
<%@page import="Entities.Usuario" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>UTNWEB</title>
	<link rel="stylesheet" href="style/estilo.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:ital,wght@1,200&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:ital,wght@1,200&family=Oswald:wght@200&display=swap" rel="stylesheet">
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<%
		LinkedList<Producto> lp = (LinkedList<Producto>)request.getAttribute("listaProductos");
		LinkedList<Categoria> lc =(LinkedList<Categoria>)request.getAttribute("listaCategorias");
		// int contador = (int)request.getAttribute("contador");
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
          <a class="nav-link active" aria-current="page" href="#">INICIO</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">PRODUCTOS</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#">CONTACTANOS</a>
        </li>
        <li class="nav-item"><a class="nav-link" href="abmcLdp?accion=Carrito">MI CARRITO <svg xmlns="http://www.w3.org/2000/svg" width="16"
								height="16" fill="currentColor" class="bi bi-cart2"
								viewBox="0 0 16 16">
  <path
									d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z" />
</svg>
					</a></li>
  <% if(true){ %>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ADMINISTRAR
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <li><a class="dropdown-item" href="abmc?accion=listar">Usuarios</a></li>
            <li><a class="dropdown-item" href="abmcProductos?accion=listar">Productos</a></li>
            <li><a class="dropdown-item" href="abmcCategorias?accion=listar">Categorias</a></li>
            <li><a class="dropdown-item" href="#">Pedidos</a></li>
           </ul>
            <% } %>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">CERRAR SESION</a>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item"><img src="img/usu.png" height="80" width="80"></a></li>
            <li><a class="dropdown-item"></a></li>
            <li><a class="dropdown-item"></a></li>
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
	
	<section class="central">
		<div class="contenido-central">
			<div class="text">
			<h1 >LOS MEJORES PRODUCTOS</h1>
			<p >Lorem ipsum dolor sit, amet consectetur adipisicing elit,amet consectetur adipisicing elit.</p>
			</div>
			<a href="#" class="btn-1">PEDI ACA</a>
		</div>

	</section>

<section>

<div class="cont-cards">
	<input type="radio" id="todos" name="categories" value="todos">
	<input type="radio" id="lacteos" name="categories" value="lacteos">
	<input type="radio" id="bebidas" name="categories" value="bebidas">
	<input type="radio" id="fiambres" name="categories" value="fiambres">	

	<div class="lbl">
		<label for="todos">TODOS</label>
		<label for="lacteos">LACTEOS</label>
		<label for="bebidas">BEBIDAS</label>
		<label for="fiambres">FIAMBRES</label>
	</div>
	
<% for (Producto Prod: lp){ %> 
	<div class="tarjetas"> 
			<div class="card" data-category="bebidas">
				<div class="card-header">
					<img src="" class="card-img">
				</div>
				<div class="card-body">
					<p><%= Prod.getDescripcion() %></p>
					<a href="abmcLdp?accion=AgregarCarrito&id=<%=Prod.getIdProducto() %>" class="btn-2">AÑADIR AL CARRITO</a>
					<h4 class="precio">$<%= Prod.getPrecio() %></h4>
				</div>
			</div>
	</div>	
	<% } %>
			
</div>
</section>


<footer>
	<div class="fot">
		<div class="fot-cont">
			<a href="#">QUIENES SOMOS</a>
			<ul class="list">
				<li><a href="#">CONTACTANOS</a></li>
				<li class="lg"><i class='bx bxl-facebook-circle'></i></li>
				<li class="lg"><i class='bx bxl-whatsapp'></i></li>
				<li class="lg"><i class='bx bxl-instagram'></i></li>
			</ul>
			<a href="#">SERVICIOS AL CLIENTE</a>
			<a href="#">AYUDA</a>
			<p>Copyright 2021 ©. Todos los derechos reservados.</p>
		</div>
	</div>	
</footer>
<script src="https://unpkg.com/boxicons@2.0.9/dist/boxicons.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>