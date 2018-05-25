<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</style>
</head>
<body>

<header>
<nav class="navbar justify-content-between" id="navegador">
  <a class="nav-link" href="<%=request.getContextPath()%>/admin/menu"><font color="white"><b><h3>Home</h3></b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/admin/usr/perfil"><font color="white"><b>Perfil</b></font></a>
  <a class="nav-link" href="#"><font color="white"><b>Historial</b></font></a>
  <a class="nav-link" href="#"><font color="white"><b>Nosotros</b></font></a>
  <a class="nav-link" href="<%=request.getContextPath()%>/"><font color="white"><b>Cerrar Sesión</b></font></a>
  
  <form class="form-inline">
    <input class="form-control mr-sm-3" type="search" placeholder="Search" aria-label="Search">
    <button class="btn  my-0 my-sm-0" type="submit" id="button"><font color="white"><b>Search</b></font></button>
  </form>
</nav></header>



<a href="<%=request.getContextPath()%>/admin/usr/editform"
								class="btn btn-primary"> Editar Usuario</a>

</body>
</html>