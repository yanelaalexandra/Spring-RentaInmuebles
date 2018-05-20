<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-4">
				<h4 class="text-center">User Login</h4>
				<hr>
				<form:form method="post" action="login">
					<div class="form-group">
						<label for="login">Login: </label>
						<form:input path="login" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label>
						<form:password path="password" class="form-control" />
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn btn-success" />
					</div>
				</form:form>
				<font color="red">${message}</font>
			</div>
		</div>
	</div>

</body>
</html>