<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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