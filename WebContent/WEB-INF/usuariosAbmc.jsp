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

	<form class="row g-3" action="abmc" method="get">
 		<div class="col-md-6">
    		<label for="inputEmail4" class="form-label">Email</label>
   			 <input type="email" class="form-control" id="email" name="email" placeholder="Ingrese email" required>
 		</div>
 		
  		<div class="col-md-6">
    		<label for="inputPassword4" class="form-label">Password</label>
    		<input type="password" class="form-control" id="password" name="password" placeholder="Ingrese contraseña" required>
  		</div>
  		
  		<div class="col-12">
    		<label for="inputAddress" class="form-label">Nombre</label>
    		<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese nombre" required>
  		</div>
  		
  		<div class="col-12">
    		<label for="inputAddress2" class="form-label">Apellido</label>
    		<input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese apellido" required>
  		</div>
  		
  		<div class="col-12">
   			<label for="inputAddress2" class="form-label">Direccion</label>
    		<input type="text" class="form-control" id="direccion" name="direccion" placeholder="Ingrese direccion" required>
  		</div>
  		
  		<div class="col-12">
    		<label for="inputAddress" class="form-label">Dni</label>
   		 	<input type="text" class="form-control" id="dni" name="dni" placeholder="Ingrese dni" required>
  		</div>
  		
  		<div class="col-12">
    		<label for="inputAddress" class="form-label">Telefono</label>
    		<input type="text" class="form-control" id="telefono" name="telefono" placeholder="Ingrese telefono" required>
  		</div>
  		
  		<div class="col-12">
    		<label for="inputAddress" class="form-label">Rol (1-Administrador, 2-Cliente):</label>
    		<input type="text" class="form-control" id="rol" name="rol" placeholder="Ingrese Rol" required>
  		</div>
  		
  		<div class="col-12">
    		<input type="submit" class="btn btn-primary" name="accion" value="agregar"> 
  		</div>
  		
  		<div class="d-grid gap-2 d-md-block">
  				<a href="javascript:history.back()"><button type="button" class="btn btn-danger">Cancelar</button></a>
		</div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>