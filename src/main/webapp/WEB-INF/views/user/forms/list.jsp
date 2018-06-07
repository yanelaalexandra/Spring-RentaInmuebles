<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Inmuebles</title>
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
    <a class="nav-link" href="<%=request.getContextPath()%>/admin/emp/createform"><font color="white"><b>Registrar Inmueble</b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/"><font color="white"><b>Cerrar Sesión</b></font></a>
</nav>
</header>


	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-8">
				<br/> 
				<table class="table table-bordered table-striped table-hover">
					<thead class="thead-dark">
						<tr>
							<th>Direccion</th>
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
