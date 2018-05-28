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
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Delete Inmueble</h4>
				<hr>
				<form:form method="post" servletRelativeAction="/admin/emp/delete" modelAttribute="inmueble" >
					<form:hidden path="idinmueble" />
					
					<div class="form-group">
						<label for="direccion">direccion: </label>
						<form:input path="direccion" class="form-control" readonly="true" />	
					</div>
					
					<div class="form-group">
						<label for="coordenadas">coordenadas: </label>
						<form:input path="coordenadas" class="form-control" />
					</div>
					<div class="form-group">
						<label for="imagen">imagen: </label>
						<form:input path="imagen" class="form-control" />
					</div>
					<div class="form-group">
						<label for="descripcion">descripcion: </label>
						<form:input path="descripcion" class="form-control" />
					</div>
					<div class="form-group">
						<label for="tipo_costo">tipo_costo: </label>
						<form:input path="tipo_costo" class="form-control" />
					</div>
					<div class="form-group">
						<label for="costo">costo: </label>
						<form:input path="costo" class="form-control" />
					</div>
					<div class="form-group">
						<label for="capacidad_max">capacidad_max: </label>
						<form:input path="capacidad_max" class="form-control" />
					</div>
					<div class="form-group">
						<label for="tipo_inmueble">tipo_inmueble: </label>
						<form:input path="tipo_inmueble" class="form-control" />
					</div>
					<div class="form-group">
						<label for="estado">estado: </label>
						<form:input path="estado" class="form-control" />
					</div>
					<div class="form-group">
						<label for="usuarios_idusuarios">usuarios_idusuarios: </label>
						<form:input path="usuarios_idusuarios" class="form-control" />
					</div>
					<div class="form-group">
						<label for="ranking_idranking">ranking_idranking: </label>
						<form:input path="ranking_idranking" class="form-control" />
					</div>
					<div class="form-group">
						<label for="latitud">latitud: </label>
						<form:input path="latitud" class="form-control" />
					</div>
					<div class="form-group">
						<label for="longitud">longitud: </label>
						<form:input path="longitud" class="form-control" />
					</div>
						
					<div class="form-group">
						<input type="submit" value="Delete" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/usr/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
				<font color="red">${message}</font>
			</div>
		</div>
	</div>


</body>
</html>
