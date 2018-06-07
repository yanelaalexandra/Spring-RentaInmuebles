<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfil</title>
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
.boton{
background: #148F77;
color: white;
}
</style>
</head>
<body background="http://ubuntuhandbook.org/wp-content/uploads/2016/09/Yakkety_Yak_Wallpaper_grey.jpg">

<header>
<nav class="navbar justify-content-between" id="navegador">
 <a class="nav-link" href="<%=request.getContextPath()%>/admin/menu"><font color="white"><b><h3>Home</h3></b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/admin/usr/perfil"><font color="white"><b>Perfil</b></font></a>
  <a class="nav-link" href="#"><font color="white"><b>Historial</b></font></a>
    <a class="nav-link" href="<%=request.getContextPath()%>/admin/usr/list"><font color="white"><b>Registrar Inmueble</b></font></a>
  <a class="nav-link" href="#"><font color="white"><b>Nosotros</b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/"><font color="white"><b>Cerrar Sesión</b></font></a>
  
  <form class="form-inline">
    <input class="form-control mr-sm-3" type="search" placeholder="Search" aria-label="Search">
    <button class="btn  my-0 my-sm-0" type="submit" id="button"><font color="white"><b>Search</b></font></button>
  </form>
</nav>
</header>

<div class="container-fluid">

<div class="row">
<div class="col-4"></div>
<div class="col-4">

<center><img src="https://d32ogoqmya1dw8.cloudfront.net/images/serc/empty_user_icon_256.v2.png">
<h3>Bienvenido usuario <c:out value="${user.nombre}"></c:out></h3></center>
<br>
<h5>Username</h5>
<div class="alert alert-dark" role="alert">
  <c:out value="${user.username}"></c:out>
</div>
<h5>Nombre</h5>
<div class="alert alert-dark" role="alert">
  <c:out value="${user.nombre}"></c:out>
</div>
<h5>Apellido</h5>
<div class="alert alert-dark" role="alert">
  <c:out value="${user.apellido}"></c:out>
</div>
<h5>Correo</h5>
<div class="alert alert-dark" role="alert">
  <c:out value="${user.correo}"></c:out>
</div>
<h5>Género</h5>
<div class="alert alert-dark" role="alert">
  <c:out value="${user.genero}"></c:out>
</div>
<br>

<center><a href="<%=request.getContextPath()%>/admin/usr/editform/"
class="btn btn-success"> Editar Usuario</a></center>

</div>
<div class="col-4"></div>
</div>

</div>

								<br>
								<br>
<div id="pie">Contáctenos al teléfono 259-5361 o al correo rentainmueble@gmail.com</div>

</body>
</html>