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
          <h3 class="masthead-brand">MANKOA - USER</h3>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link" href="<%=request.getContextPath()%>/">Home</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/menu">Inmuebles</a>
            <a class="nav-link active" href="<%=request.getContextPath()%>/login-type">Iniciar sesion</a>
          </nav>
        </div>
      </header>

      <div class="container-fluid">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
					
				<form:form class="needs-validation" novalidate="true" method="post" action="login-user">
					<div class="col form-group">
						<label for="username"><h4>Login: </h4></label>
						<form:input path="username" class="form-control" required="true" placeholder="Username"/>
						<div class="invalid-tooltip">
				          Usuario Requerido
				        </div>				        				   
					</div>
				
					<div class="col form-group">
					  <hr>
						<label for="password"><h4>Password: </h4></label>
						<form:password path="password" class="form-control"  required="true" placeholder="Password"/>
						<div class="invalid-tooltip">
				          Contraseña Requerida
				        </div>			      
					</div>	
									
					<br>
					
					<center>
					  <hr>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success"/>
						
												
					<a href="<%=request.getContextPath()%>/user/register"
					class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i>
					Register</a>
					
					<a href="<%=request.getContextPath()%>/login-type"
					class="btn btn-info"><i class="glyphicon glyphicon-edit"></i>
					Regresar</a>
					
					</div>
				</center>
					
				</form:form>
				<br>
				<font color="red"><h4> ${message} </h4></font>
			</div>
			<div class="col-2"></div>
		</div>
	</div>

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
    
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
   
</body>
</html>


