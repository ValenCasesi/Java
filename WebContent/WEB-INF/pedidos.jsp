<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entities.Pedido"%>
<%@page import="Entities.Usuario"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:ital,wght@1,200&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:ital,wght@1,200&family=Oswald:wght@200&display=swap" rel="stylesheet">
	<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">	

<title>UTNWEB</title>


<%
LinkedList<Pedido> pedidos = (LinkedList<Pedido>) request.getAttribute("listaPedidos");
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
            <h2 class="text-center">Gracias por tu compra, usuario</h2>
            <h4 class="text-center">Recibiras tu orden via mail</h4>
            <h6 class="text-center"><a href="mailto:valecasesi@gmail.com?subjet=Pedido UTN WEB&body=Muchas Gracias por la compra!">Enviar mail</a></h6>
            
            <div class="row">            
                <table class="table tab-pane">
                    <thead class="thead-light">
                        <tr class="text-center">
                            <th>CODIGO DE PEDIDO</th>                               
                            <th>Fecha de Compra</th>
                            <th>Monto</th>                                                   
                            <th>Estado</th> 
                            <th>DNI<th>                                                  
                            <th></th>                                                   
                        </tr>
                    </thead>
                    <tbody>
                       
                       <%
						for (Pedido ped : pedidos) {
					%>
                       
                            <tr class="text-center">
                                <td><%= ped.getIdPedido()%></td>  
                                <td><%= ped.getFechaPedido()%></td>
                                <td><%= ped.getMonto() %></td>                                
                                <td><%= ped.getEstado()%></td>                                                                                                       
                                <td><%= ped.getUsu().getDni() %></td>                                                                                                      
                                <td>
                                    <a href="abmcLdp?accion=verDetalle&idpedido=<%= ped.getIdPedido() %>">Ver Detalle</a>
                                </td>                                                                                                       
                            </tr>
                      <% } %>
                    </tbody>
                </table>             
            </div>          
        </div> 
        
        <div class="col-sm-4">
				<div class="card">
					<div class="card-footer">
						<a href="abmc?accion=inicio" class="btn btn-info btn-block">Seguir Comprando</a>
					</div>
				</div>
			</div>

       
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>