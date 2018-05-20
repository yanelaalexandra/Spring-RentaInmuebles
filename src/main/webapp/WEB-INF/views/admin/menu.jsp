<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Menu</h4>
				<hr>
				<table class="table table-bordered table-striped">
					<tbody>
						<tr>
							<td>
								<a href="<%=request.getContextPath()%>/admin/emp/list"
								class="btn btn-primary"> Manager Employees</a>
							</td>
							<td>
								<a href="#"
								class="btn btn-primary"> Logout</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</body>
</html>