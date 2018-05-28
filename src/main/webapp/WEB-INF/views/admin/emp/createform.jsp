<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC CRUD</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<style>
	.error {color: #ff0000; }
</style>
	
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
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
		</div>
	</div>


</body>
</html>
