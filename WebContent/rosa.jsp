<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/creaRosa.css" rel="stylesheet">
<jsp:include page="header.jsp"></jsp:include>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
	<div id="blue">
		<div class="container">
			<div class="row">
				<h3>Crea la Tua Rosa</h3>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /blue -->
	<div class="container">
		<div class="nav-tabs-custom">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#tab_1" data-toggle="tab"
					aria-expanded="false">Portieri</a></li>
				<li class=""><a href="#tab_2" data-toggle="tab"
					aria-expanded="false">Difensori</a></li>
				<li class=""><a href="#tab_3" data-toggle="tab"
					aria-expanded="true">Centrocampisti</a></li>
				<li class=""><a href="#tab_4" data-toggle="tab"
					aria-expanded="true">Attaccanti</a></li>
					<li class="pull-right"><H1 id="budget">Budget: 250 CR</H1></li>
			</ul>


			<div class="tab-content">
				<div class="col-md-4 tab-pane active" id="tab_1">
					<h2>Portieri</h2>
					<div id="gk" class="giocatori">
						<c:forEach items="${portieri}" var="p">
							<div id="${p.id}" class="giocatore" value="${p.costo}">${p.cognome} - ${p.squadra} ${p.costo} CR</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 tab-pane " id="tab_2">
					<h2>Difensori</h2>
					<div id="def" class="giocatori">
						<c:forEach items="${difensori}" var="dif">
							<div class="giocatore">${dif.cognome}</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 tab-pane " id="tab_3">
					<h2>Centrocampisti</h2>
					<div id="mid" class="giocatori">
						<c:forEach items="${centrocampisti}" var="c">
							<div class="giocatore" value="${c.id}">${c.cognome}</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 tab-pane " id="tab_4">
					<h2>Attaccanti</h2>
					<div id="str" class="giocatori">
						<c:forEach items="${attaccanti}" var="a">
							<div class="giocatore" value="${a.id}">${a.cognome}</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<h2>I Tuoi Giocatori</h2>
				<div id="rosaG" class="tuoiGiocatori" onmouseover="calcolaCrediti();"></div>
				
			</div>
		</div>
		<div class="col-md-2">
			<h3>Portieri: </h3>
			<h3>Difensori: </h3>
			<h3>Centrocampisti: </h3>
			<h3>Attaccanti: </h3>
			<h3>Giocatori Totali: </h3>
		</div>
	</div>



</br>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/dragAndDrop.js"></script>
<script type="text/javascript" src="js/creaRosa.js"></script>

</html>