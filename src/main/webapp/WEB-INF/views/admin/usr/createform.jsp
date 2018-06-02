<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Crear usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Passion+One" rel="stylesheet">
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
#titulo{
font-size: 55px;
text-align: center;
height: 47%;
opacity: 0.8;
background: #148F77;
font-family: 'Passion One', cursive;
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

<div id="titulo" class="jumbotron">
<img src="https://png.icons8.com/metro/1600/add-user-male.png" height="100" width="100">
<br>
 User Register</div>

<div class="container-fluid">
		<div class="row-fluid">
		<div class="col-md-4"></div>
			<div class="col-md-4">
				<hr>
				<form:form method="post" action="/rentainmuebles/save">
					
					<form:hidden path="idusuario" class="form-control"/>
					
					<div class="form-group">
						<label for="username"><h4>Username: </h4></label>
						<form:input path="username" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password"><h4>Password: </h4></label>
						<form:password path="password" class="form-control" />
					</div>
					<div class="form-group">
						<label for="nombre"><h4>Nombre: </h4></label>
						<form:input path="nombre" class="form-control" />
					</div>
					<div class="form-group">
						<label for="apellido"><h4>Apellido: </h4></label>
						<form:input path="apellido" class="form-control" />
					</div>
					<div class="form-group">
						<label for="correo"><h4>Correo: </h4></label>
						<form:input path="correo" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="genero"><h4>Género: </h4></label>
						 <form:radiobutton path="genero" value="M"/>Masculino
						<form:radiobutton path="genero" value="F"/>Femenino 
 					</div>
 					<center>
					<div class="form-group">
						
						<a href="<%=request.getContextPath()%>/" class="btn btn-danger"><i class="glyphicon glyphicon-arrow-left"></i> Cancelar</a>
						<input type="submit" value="Register" class="btn btn-success" />
					
					</center></div>
				</form:form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	
	<div id="pie">Contáctenos al teléfono 259-5361 o al correo rentainmueble@gmail.com</div>
	
</body>
</html>