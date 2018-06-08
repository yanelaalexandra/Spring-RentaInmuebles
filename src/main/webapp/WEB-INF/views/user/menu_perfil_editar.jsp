<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="icon" href="<c:url value="/resources/images/lg_empresa.png"/>">
    
    <title>Renta Inmuebles</title>

    <!-- Bootstrap core CSS -->   
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="<c:url value="/resources/css/cover.css"/>">
    
</head>
<body class="text-center" background="<c:url value="/resources/images/fondo1.jpg"/>">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">MANKOA</h3>
          <h4>Bienvenido: ${user.nombre}  ${user.apellido}</h4>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link" href="<%=request.getContextPath()%>/user/home">Home</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/user/menu">Inmuebles</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/user/menu-inmuebles">Mis Inmuebles</a>
            <a class="nav-link  active" href="<%=request.getContextPath()%>/user/perfil">Mis Datos</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/login-type">Cerrar sesion</a>
          </nav>
        </div>
      </header>

      <main role="main" class="inner cover">
      		<div class="container-fluid">

				<div class="row">
				<div class="col-3"></div>
				<div class="col-6">			
				
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
						<label for="descripcion">Descripcion: </label>
						 <form:textarea path="descripcion" class="form-control" />
 					</div>
 								
 					 					
 					<div class="form-group">
						<label for="telefono">Telefono: </label>
						 <form:input path="telefono" class="form-control"/>
 					</div>
 					 					
 					<center>			
					<div class="form-group">
						<input type="submit" value="Save Changes" class="btn btn-success" />
					</div>
					<br>
					<a href="<%=request.getContextPath()%>/user/perfil"
					class="btn btn-danger"><i class="glyphicon glyphicon-arrow-left"></i>
					Cancelar</a>
					</center>
				</form:form>
				
				
				</div>
				<div class="col-3"></div>
				</div>
				
			</div>
       
      </main>

      <footer class="mastfoot mt-auto">
        <div class="inner">
          <p>Contáctenos al teléfono 259-5361 o al correo rentainmueble@gmail.com</p>
        </div>
      </footer>
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/resources/js/jquery-3.3.1.slim.min.js"/>"></script>
    <script>window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-slim.min.js"/>"><\/script>')</script>
    <script src="<c:url value="/resources/js/popper.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
   
</body>
</html>


