<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="refresh"
	url=${pageContext.request.requestURL}?savedLega=${sessionScope.savedLega}">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ page
	import="java.util.List"%>
<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
<div id="blue">
	<div class="container">
		<div class="row">
			<h3>Classifica</h3>
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
		<div class="col-xs-12">

			<h2>Lega</h2>
			<!--     Begin Form -->
			<form action="classifica" method="POST">
				<select name="legas" class="form-control" id="legas">
					<c:forEach items="${leghe}" var="l">
						<option value="${l.id}">${l.nome}</option>
					</c:forEach>
				</select> <input type="submit" value="Cerca">
			</form>

		</div>
		<!-- /col -->
	</div>
	<!-- /row-->
</div>
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
							<th>Posizione</th>
							<th>Nome</th>
							<th>Utente</th>
							<th>Giornate Vinte</th>
							<th>Gol Fatti</th>
							<th>Gol Subiti</th>
							<th>Punteggio Tot.</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="1" scope="page" />
						<c:forEach items="${rose}" var="rosa">
							<tr>
								<td>${count}</td>
								<td>${rosa.nome}</td>
								<td>${rosa.utente }</td>
								<td><span class="badge  badge-info">${rosa.vittorie}</span></td>
								<td>${rosa.golFatti}</td>
								<td>${rosa.golSubiti}</td>
								<td class="human"><span class="label  label-primary">${rosa.punteggio}</span>
								</td>
							</tr>
							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
