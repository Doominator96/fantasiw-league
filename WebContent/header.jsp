<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
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


<link rel="stylesheet" href="css/popup.css">
</head>

<body>

	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home.jsp">FANTASIW LEAGUE</a>
			</div>
			<div class="navbar-collapse collapse navbar-right">
				<ul class="nav navbar-nav">
					<li ><a href="home.jsp">HOME</a></li>
					<li><a href="leghe">CLASSIFICA</a></li>
					<li><a href="formazione.jsp">FORMAZIONE</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">UTENTE <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="account.jsp">ACCOUNT</a></li>
							<li><a href="roseUtente">SQUADRA</a></li>
							<li><a href="storico-scontri.jsp">STORICO SCONTRI</a></li>
							<li><a href="logout">LOGOUT</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
<c:if test="${not loggato}">
<script>
window.location = "index.jsp";
</script>
</c:if>
	