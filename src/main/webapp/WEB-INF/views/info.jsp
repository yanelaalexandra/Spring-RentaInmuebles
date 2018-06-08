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
<body background="<c:url value="/resources/images/fondo1.jpg"/>">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand"> <img src="<c:url value="/resources/images/lg_empresa.png"/>" width="32" height="32"> MANKOA</h3>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link" href="<%=request.getContextPath()%>/">Inicio</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/menu">Inmuebles</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/login-type">Iniciar sesión</a>
          </nav>
        </div>
      </header>

      <div class="container marketing">

        <!-- START THE FEATURETTES -->
	
        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
          <br>
            <h2 class="featurette-heading">Casas y departamentos cómodos y accesibles<span class="text-muted"></span></h2>
            <p class="lead">Podrás encontrar diferentes casa y departamentos asi tambien como cuartos individuales, son accesibles y viables para diferentes usuarios.</p>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="https://1.bp.blogspot.com/-5gg2CObKBgo/WUv0JnTqn6I/AAAAAAAAke0/zYl4dip5xH47-kStGUajmiIDWUaUWvE9QCLcBGAs/s1600/casa.png" alt="Generic placeholder image" width="250" height="250">
          </div>
        </div>

        <hr class="featurette-divider">
        <div class="row featurette">
          <div class="col-md-7 order-md-2">
          <br>
            <h2 class="featurette-heading">Inmuebles familiares.<span class="text-muted"></span></h2>
            <p class="lead">Puedes encontrar inmuebles para tu familia y pasar un momento agradable sin la necesidad de tomarte mucho tiempo para alquilar una casa.</p>
          </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="http://www.primerolafamilia.com.ar/images/familia-3.png" alt="Generic placeholder image" width="250" height="250">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
          <br>
          <br>
            <h2 class="featurette-heading">Precios generosos.<span class="text-muted"></span></h2>
            <p class="lead">Mostramos diferentes precios para todo tipo de clientes y los pagos diarios, semanales y mensuales del alquiler.</p>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="http://emprendete.sv/wp-content/uploads/2017/06/cash_icon-icons.com_51090-300x300.png" alt="Generic placeholder image" width="250" height="250">
          </div>
        </div>

        <hr class="featurette-divider">
        

        <!-- /END THE FEATURETTES -->


      
        <center><p>
          <a href="<%=request.getContextPath()%>/" class="btn btn-lg btn-secondary">Regresar</a>
        </p></center>
      </div>

      <footer class="mastfoot mt-auto">
        <div class="inner">
          <p>Contáctenos al teléfono 259-5361 o al correo rentainmueble@gmail.com Perú-Lima</p>
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
