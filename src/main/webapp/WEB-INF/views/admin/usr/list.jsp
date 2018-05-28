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
			<div class="col-md-8">
				<h4 class="text-center">Inmuebles</h4>
				<hr>
					<a href="<%=request.getContextPath()%>/admin/emp/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Create Inmuebles</a>
					<a href="<%=request.getContextPath()%>/user/menu"
					class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>
					Menu</a>
				<br/> 
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Direccion</th>
							<th>Coordenadas</th>
							<th>Imagen</th>
							<th>Descripcion</th>
							<th>Tipo Pago</th>
							<th>Costo</th>
							<th>Capacidad</th>
							<th>Inmueble</th>
							<th>Estado</th>
							<th>Latitud</th>
							<th>Longitud</th>
							
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="inm" items="${inmuebles}">
							<tr>
								<td>${inm.direccion}</td>
								<td>${inm.coordenadas}</td>
								<td>${inm.imagen}</td>
								<td>${inm.descripcion}</td>
								<td>${inm.tipo_costo}</td>
								<td>${inm.costo}</td>
								<td>${inm.capacidad_max}</td>
								<td>${inm.tipo_inmueble}</td>
								<td>${inm.estado}</td>
								<td>${inm.latitud}</td>
								<td>${inm.longitud}</td>
								<td><a
									href="<%=request.getContextPath()%>/admin/emp/editform/${inm.idinmueble}"
									class="btn btn-info btn-xs"> <i
										class="glyphicon glyphicon-check"></i>Edit
								</a></td>
								<td><a
									href="<%=request.getContextPath()%>/admin/emp/deleteform/${inm.idinmueble}"
									class="btn btn-danger btn-xs"> <i
										class="glyphicon glyphicon-trash"></i> Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<font color="red">${message}</font>
		</div>
	</div>
</body>
</html>
