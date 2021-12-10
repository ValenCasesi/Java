<%@page import="Entities.Categoria" %>
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
		String idCategoria=request.getParameter("idCategoria");
		String descripcion=request.getParameter("descripcion");
	%>
	  <form class="row g-3" action="abmcCategorias" method="get">
	  
  <div class="col-12">
    <label for="inputAddress" class="form-label">Id Categoria</label>
    <input type="text" class="form-control" id="idCategoria" name="idCategoria" readonly value="<%=idCategoria%>" placeholder="Ingrese IdCategoria" required>
  </div>
  
  
  <div class="col-12">
    <label for="inputAddress" class="form-label">Descripcion</label>
    <input type="text" class="form-control" id="descripcion" name="descripcion" value="<%=descripcion%>" placeholder="Ingrese categoria" required>
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