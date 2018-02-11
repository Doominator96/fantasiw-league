<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FantaSiw</title>
</head>
<body>
<link href="https://fonts.googleapis.com/css?family=Open+Sans|Sedgwick+Ave+Display" rel="stylesheet">
<link rel="stylesheet" href="css/login2.css">
<link href="css/font-awesome.min.css" rel="stylesheet">



</head>

<body class="align">

	<div class="grid"  class="center">

		<h1>FantaSiw League</h1>


		<form class="form login" method="GET" action="login">

			<div class="form_field">
				<label for="login_username"><i class="fa fa-user"></i><span
					class="hidden">Username</span></label> <input id="login_username"
					type="text" name="login_username" class="form_input"
					placeholder="Username" required>
			</div>

			<div class="form_field">
				<label for="login_password"><i class="fa fa-lock"></i><span
					class="hidden">Password</span></label> <input id="login_password"
					type="password" name="login_password" class="form_input"
					placeholder="Password" required>
			</div>

			<div class="form_field">
				<input id="button" type="submit" name="accesso" value="Sign In" href="sendData"  onclick="<c:set var="page" value="home.jsp" scope="session"/">
			</div>


		</form>

		<p class="text--center">
			Non sei registrato? <a href="registrazione.html">Registrati</a>
		</p>

	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/login.js"></script>

</body>
</html>