<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
	<div id="blue">
	    <div class="container">
			<div class="row">
				<h3>Calcola Giornata</h3>
			</div><!-- /row -->
	    </div> <!-- /container -->
	</div><!-- /blue -->
	
	<h2 class="centered">Scegli Lega</h2>
<select id="leghe" class="js-example-basic-single col-md-12" name="state">
  <option value="AL">Alabama</option>
  <option value="WY">Wyoming</option>
</select>
</br>
</br>

	<h2 class="centered">Scegli Rosa</h2>



<select id="rose" class="js-example-basic-single col-md-12" name="state">
  <option value="AL">Alabama</option>
  <option value="WY">Wyoming</option>
</select>

</br>
</br>

<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12">

			<div class="table-responsive">
				<table class="table  table-hover" id="table">
					<thead>
						<tr class="info">
							<th>Numero</th>
							<th>Cognome</th>
							<th>Squadra</th>
							<th>Gol</th>
							<th>Rigore</th>
							<th>Rigore Sbagliato</th>
							<th>Voto </th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="1" scope="page" />
						<c:forEach items="${rose}" var="r">
							<tr>
								<td>${count}</td>
								<td>${g.cognome}</td>
								<td>${g.squadra}</td>
								<td><span class="badge  badge-info"></span></td>
								<td>${r.golFatti}</td>
								<td>${r.golSubiti}</td>
								<td class="human"><span class="label  label-primary">${r.punteggio}</span>
								</td>
							</tr>
							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/calcolaVoto.js"></script>
</html>