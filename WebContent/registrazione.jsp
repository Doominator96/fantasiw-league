<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="img/favicon.ico">

<title>Fantasiw League</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<script src="https://unpkg.com/sweetalert2@7.12.12/dist/sweetalert2.all.js"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css"
	rel="stylesheet" />

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans|Sedgwick+Ave+Display"
	rel="stylesheet">


<script src="js/login.js"></script>

<link rel="stylesheet" href="css/login2.css">

</head>

<body class="align">

	<div class="grid" class="center">

		<h1>FantaSiw League</h1>


		<form action="registrazione" method="POST" class="form login">

			<div class="form_field">
				<label for="login_email"><i class="fa fa-envelope"></i><span
					class="hidden">Email</span></label> <input id="login_email" type="text"
					name="email" class="form_input" placeholder="Email" required>
			</div>

			<div class="form_field">
				<label for="login_username"><i class="fa fa-user"></i><span
					class="hidden">Username</span></label> <input id="login_username"
					type="text" name="username" class="form_input"
					placeholder="Username" required>
			</div>

			<div class="form_field">
				<label for="login_password"><i class="fa fa-lock"></i><span
					class="hidden">Password</span></label> <input id="login_password"
					type="password" name="password" class="form_input"
					placeholder="Password" required>
			</div>

			<div class="form_field">
				<input type="submit" value="Sign In" />
			</div>


		</form>

		<p class="text--center">
			Sei Gi� Registrato? <a href="index.jsp">Accedi</a>
		</p>

	</div>

	<c:if test="${esistente}">
		<script>
			swal({
				type : 'error',
				title : 'Username Gi� Esistente!',
				text : 'Sceglierne Un Altro',
				confirmButtonText : 'Riprova'

			})
		</script>
	</c:if>
</body>
</html>
