<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head >
<title>Crear Inmuebles</title>
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
.boton{
background: #148F77;
color: white;
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
</nav>
</header>

	<div class="container-fluid">
		<div class="row">
		<div class="col-4"></div>
			<div class="col-4">
				<h4 class="text-center">Create Inmueble</h4>
				<hr><form:errors path = "salary" />
				<form:form method="post" action="create" modelAttribute="inmueble">
				
					<div class="form-group">
						<label for="direccion">Direccion: </label>
						<form:input path="direccion" class="form-control" />
						<form:errors path="coordenadas" cssClass="error" />	
					</div>
					
					<div class="form-group">
						<label for="coordenadas">Coordenadas: </label>
						<form:input path="coordenadas" class="form-control" />
						<form:errors path="coordenadas" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="imagen">Imagen: </label>
						<form:input path="imagen" class="form-control" />
						<form:errors path="imagen" cssClass="error" />			
					</div>
					<div class="form-group">
						<label for="descripcion">Descripcion: </label>
						<form:input path="descripcion" class="form-control" />
						<form:errors path="descripcion" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="tipo_costo">Pago: </label>
						<form:input path="tipo_costo" class="form-control" />
						<form:errors path="tipo_costo" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="costo">Costo: </label>
						<form:input path="costo" class="form-control" />
						<form:errors path="costo" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="capacidad_max">Capacidad: </label>
						<form:input path="capacidad_max" class="form-control" />
						<form:errors path="capacidad_max" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="tipo_inmueble">Inmueble: </label>
						<form:input path="tipo_inmueble" class="form-control" />
						<form:errors path="tipo_inmueble" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="estado">Estado: </label>
						<form:input path="estado" class="form-control" />
						<form:errors path="estado" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="usuarios_idusuarios">id usuarios: </label>
						<form:input path="usuarios_idusuarios" class="form-control" />
						<form:errors path="usuarios_idusuarios" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="ranking_idranking">ranking: </label>
						<form:input path="ranking_idranking" class="form-control" />
						<form:errors path="ranking_idranking" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="latitud">Latitud: </label>
						<form:input path="latitud" class="form-control" />
						<form:errors path="latitud" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="longitud">Longitud: </label>
						<form:input path="longitud" class="form-control" />
						<form:errors path="longitud" cssClass="error" />
					</div>
					
					<div class="form-group">
						<input type="submit" value="Create" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/usr/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
				<font color="red">${message}</font>
			</div>
			<div class="col-4"></div>
		</div>
	</div>
</body>
</html>
