<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
#titulo{
font-size: 40px;
text-align: center;
}
#formulario{
text-align: center;
}
</style>
</head>
<body>
<div id="titulo" class="jumbotron"><br><img src="http://download.seaicons.com/icons/icons8/windows-8/512/User-Interface-Login-icon.png" height="150" width="150">
<br>
 User Login</div>
	

	<div class="container-fluid">
		<div class="row-fluid">
		<div class="col-md-4"></div>
			<div class="col-md-4">
				<hr>
				<form:form method="post" action="login">
					<div class="form-group">
						<label for="username">Login: </label>
						<form:input path="username" class="form-control" />
					</div>
					<br>
					<div class="form-group">
						<label for="password">Password: </label>
						<form:password path="password" class="form-control" />
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success"/>
						
					</div>
					<a href="<%=request.getContextPath()%>/register"
					class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i>
					Register</a>
				</form:form>
				<br>
				<font color="red">${message}</font>
			</div>
			<br>
			<br>
			<div class="col-md-4"></div>
		</div>
	</div>
<br>
	
	
	
	<div id="pie">Contáctenos al teléfono 259-5361 o al correo rentainmueble@gmail.com</div>
</body>
</html>
