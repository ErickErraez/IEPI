<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

</head>
<body>
	<h1>Hola Mundo</h1>
	<form action="login" method="Post">
		<div class="form-group">
			<label>Name:</label> <input type="text" class="form-control"
				name="name" placeholder="Enter name">
		</div>
		<div class="form-group">
			<label>Password</label> <input type="password" class="form-control"
				name="password" placeholder="Password">
		</div>

		<button type="submit" class="btn btn-primary" value="login">Submit</button>
	</form>

</body>
</html>