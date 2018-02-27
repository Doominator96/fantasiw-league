<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
<div id="blue">
	<div class="container">
		<div class="row">
			<h3>Le Tue Rose</h3>
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</div>
<!-- /blue -->

<!-- *****************************************************************************************************************
	DROP DOWN LEGA
	 ***************************************************************************************************************** -->
<div class="container">
	<div class="row">
			<h2>Scegli la Squadra</h2>
			<!--     Begin Form -->
			<form action="giocatoriRosa" method="POST">
				<select name="rose1" class="form-control" id="rose1" onchange="this.form.submit()">
				<option >Scegli una Squadra</option>
					<c:forEach items="${roseG}" var="r">
						<option value="${r.id}">${r.nome} Lega: ${r.lega.nome}</option>
					</c:forEach>
				</select>
			</form>

		</div>
		<!-- /col -->
	</div>
	<!-- /row-->
<!-- /container -->
<span> </span>

<!-- *****************************************************************************************************************
	 TABLE
	 ***************************************************************************************************************** -->
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12">

			<div class="table-responsive">
				<table class="table  table-hover" id="table">
					<thead>
						<tr class="info">
							<th>Cognome</th>
							<th>Squadra</th>
							<th>Ruolo</th>
							<th>Costo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${giocatori}" var="g">
							<tr>
								<td>${g.cognome}</td>
								<td>${g.squadra }</td>
								<td>${g.ruolo}</span></td>
								<td>${g.costo}</td>
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<button onclick="cacone();">prova</button>
<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript" src="js/calcolaVoto.js"></script>

</body>
</html>
