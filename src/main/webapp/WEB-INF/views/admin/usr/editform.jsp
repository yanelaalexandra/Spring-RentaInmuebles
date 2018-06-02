<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Editar usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

<style>
#navegador{
background-color: black;
padding-left: 30px;
padding-right: 30px;
font-size: 20px;
}
#button{
background: #1F618D;

}
.b{
color: white;
font-style: bold;
}
#button2{
color: white;
}
#pie{
color: white;
background: #1F618D;
font-style: bold;
font-size: 12px;
padding: 3px;
text-align: center;
}
</style>
</head>
<body background="http://ubuntuhandbook.org/wp-content/uploads/2016/09/Yakkety_Yak_Wallpaper_grey.jpg">

<header>
<nav class="navbar justify-content-between" id="navegador">
  <a class="nav-link" href="<%=request.getContextPath()%>/admin/menu"><font color="white"><b><h3>Home</h3></b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/admin/usr/perfil"><font color="white"><b>Perfil</b></font></a>
  <a class="nav-link" href="#"><font color="white"><b>Historial</b></font></a>
    <a class="nav-link" href="<%=request.getContextPath()%>/admin/usr/list"><font color="white"><b>Registrar Inmueble</b></font></a>
  <a class="nav-link" href="#"><font color="white"><b>Nosotros</b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/"><font color="white"><b>Cerrar Sesión</b></font></a>
  
  <form class="form-inline">
    <input class="form-control mr-sm-3" type="search" placeholder="Search" aria-label="Search">
    <button class="btn  my-0 my-sm-0" type="submit" id="button"><font color="white"><b>Search</b></font></button>
  </form>
</nav></header>


<div class="container-fluid">
		<div class="row">
		<div class="col-md-4"></div>
			<div class="col-md-4">
			<br>
				<center><img src="https://png.icons8.com/metro/1600/edit-user-male.png" width="200" height="200">
<h3>Editar usuario </h3></center>
				<hr>
				<form:form method="post" action="/rentainmuebles/editsave">
					
					<form:hidden path="idusuario" class="form-control"/>
					
					<div class="form-group">
						<label for="username">Username: </label>
						<form:input path="username" class="form-control"  />
					</div>
					<div class="form-group">
						<label for="nombre">Nombre: </label>
						<form:input path="nombre" class="form-control" />
					</div>
					<div class="form-group">
						<label for="apellido">Apellido: </label>
						<form:input path="apellido" class="form-control" />
					</div>
					<div class="form-group">
						<label for="correo">Correo: </label>
						<form:input path="correo" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="genero">Género: </label>
						 <form:radiobutton path="genero" value="M"/>Masculino
						<form:radiobutton path="genero" value="F"/>Femenino 
 					</div>
					
 					<div class="form-group">
						<label for="genero">Descripcion: </label>
						 <form:textarea path="Descripcion" class="form-control" />
 					</div>
 								
 					 					
 					<div class="form-group">
						<label for="genero">Telefono: </label>
						 <form:input path="telefono" class="form-control"/>
 					</div>
 					 					
 					<center>			
					<div class="form-group">
						<input type="submit" value="Save Changes" class="btn btn-success" />
					</div>
					<br>
					<a href="<%=request.getContextPath()%>/admin/usr/perfil"
					class="btn btn-danger"><i class="glyphicon glyphicon-arrow-left"></i>
					Cancelar</a>
					</center>
				</form:form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
	<div id="pie">Contáctenos al teléfono 259-5361 o al correo rentainmueble@gmail.com</div>
	
</body>
</html>