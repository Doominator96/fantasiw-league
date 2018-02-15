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
			<div class="col-md-3" style="float: inherit;">
				<select name="rose1" class="form-control" id="rose1" onchange="this.form.submit()">
					<c:forEach items="${roseG}" var="r">
						<option value="${r.id}">${r.nome} Lega: ${r.lega}</option>
					</c:forEach>
					</div>
					<div class="col-md-1" style="display:inline;">
				</select>
				</div>
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

<jsp:include page="footer.jsp"></jsp:include>
