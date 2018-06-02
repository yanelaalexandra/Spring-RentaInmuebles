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
font-size: 55px;
text-align: center;
height: 47%;
opacity: 0.8;
background: #148F77;
font-family: 'Passion One', cursive;
}
#formulario{
text-align: center;
}
</style>
</head>
<body background="http://ubuntuhandbook.org/wp-content/uploads/2016/09/Yakkety_Yak_Wallpaper_grey.jpg">
<div id="titulo" class="jumbotron"><img id="logoemp" src="http://static.tumblr.com/9525478e941a1e6e1890feb052dc8390/slqhnp0/JB8mm528u/tumblr_static_ml_logo.png" height="150" width="150">
<br> User Login
</div>
	

	<div class="container-fluid">
		<div class="row-fluid">
		<div class="col-md-4"></div>
			<div class="col-md-4">
				<form:form method="post" action="login">
					<div class="form-group">
						<label for="username"><h4>Login: </h4></label>
						<form:input path="username" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password"><h4>Password: </h4></label>
						<form:password path="password" class="form-control" />
					</div>
					<br>
					
					<center>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success"/>
						
					
									
					<a href="<%=request.getContextPath()%>/register"
					class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i>
					Register</a></div>
				</center>
					
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
