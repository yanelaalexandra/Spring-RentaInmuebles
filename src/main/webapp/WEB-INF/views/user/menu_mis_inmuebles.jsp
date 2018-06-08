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

<style>
 	.card-body{
 		color: black;
 		}
	body  {
    background-image: url("<c:url value="/resources/images/fondo1.jpg"/>");
    background-repeat: repeat;
    background-attachment: fixed;
	}
</style>



<body class="text-center">

<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand"> <img src="<c:url value="/resources/images/lg_empresa.png"/>" width="32" height="32"> MANKOA</h3>
          <h4>Bienvenido: ${user.nombre}  ${user.apellido}</h4>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link" href="<%=request.getContextPath()%>/user/home">Inicio</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/user/menu">Inmuebles</a>
            <a class="nav-link active" href="<%=request.getContextPath()%>/user/menu-inmuebles" >Mis Inmuebles</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/user/perfil">Mis Datos</a>
            <a class="nav-link" href="<%=request.getContextPath()%>/login-type">Cerrar sesión</a>
          </nav>
        </div>
      </header>
<!-- TE AMO GORDI <3  -->
      <main role="main">
      <br>
 	  <hr>
      <div class="album">
        <div class="container">
          <div class="row">
          <c:forEach var="inm" items="${MisInmuebles}">
            <div class="col-md-6"> 
              <div class="card mb-6 box-shadow">
                <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&bg=55595c&fg=eceeef&text=Thumbnail" alt="Card image cap">
                <div class="card-body">
                  <h5 class="card-title">${inm.tipo_inmueble}</h5>
                   <p class="card-text">${inm.direccion}</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="button" onclick="location.href ='<%=request.getContextPath()%>/detail/user/inmueble/${inm.idinmueble}';" class="btn btn-outline-secondary">DETALLES</button>
                    </div>
                    <small class="text-muted">Capacidad Max. : ${inm.capacidad_max}</small>
                  </div>
                </div>
              </div>
              <br>
            </div> 
            </c:forEach>        
          </div>
        </div>
      </div>
       
      </main>

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
    <script src="<c:url value="/resources/js/holder.min.js"/>"></script>
</body>
</html>


