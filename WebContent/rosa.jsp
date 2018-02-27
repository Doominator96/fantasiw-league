<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="css/creaRosa.css" rel="stylesheet">
<link rel="stylesheet" href="css/popup.css">

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
				<li class="active" id="p"><a href="#tab_1" data-toggle="tab"
					aria-expanded="false">Portieri</a></li>
				<li class="" id="d"><a href="#tab_2" data-toggle="tab"
					aria-expanded="false">Difensori</a></li>
				<li class="" id="c"><a href="#tab_3" data-toggle="tab"
					aria-expanded="true">Centrocampisti</a></li>
				<li class="" id="a"><a href="#tab_4" data-toggle="tab"
					aria-expanded="true">Attaccanti</a></li>
					<li class="pull-right"><H1 id="budget">Budget: 180 CR</H1></li>
			</ul>


			<div class="tab-content">
				<div class="col-md-4 tab-pane active" id="tab_1">
					<h2>Portieri</h2>
					<div id="gk" class="giocatori ">
						<c:forEach items="${portieri}" var="p">
							<div id="${p.id}" class="giocatore por" value="${p.costo}">${p.cognome} - ${p.squadra} ${p.costo} CR</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 tab-pane " id="tab_2">
					<h2>Difensori</h2>
					<div id="def" class="giocatori ">
						<c:forEach items="${difensori}" var="d">
							<div id="${d.id}" class="giocatore dif" value="${d.costo}">${d.cognome} - ${d.squadra} ${d.costo} CR</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 tab-pane " id="tab_3">
					<h2>Centrocampisti</h2>
					<div id="mid" class="giocatori">
						<c:forEach items="${centrocampisti}" var="c">
							<div id="${c.id}" class="giocatore cen" value="${c.costo}">${c.cognome} - ${c.squadra} ${c.costo} CR</div>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 tab-pane " id="tab_4">
					<h2>Attaccanti</h2>
					<div id="str" class="giocatori">
						<c:forEach items="${attaccanti}" var="a">
							<div id="${a.id}" class="giocatore  att" value="${a.costo}">${a.cognome} - ${a.squadra} ${a.costo} CR</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-md-4" style="display: flow-root;">
				<h2 style="display: inline-block;">I Tuoi Giocatori</h2>
				<div id="rosaG" class="tuoiGiocatori" onmouseover="calcolaCrediti();"></div>
				
			</div>
		</div>
		<div class="col-md-3 pull-right">
			</br>
			</br>
			<h3 id="portieri">Portieri: 0 / 3 </h3>
			<h3 id="difensori">Difensori: 0 / 8 </h3>
			<h3 id="centrocampisti">Centrocampisti: 0 / 8 </h3>
			<h3 id="attaccanti">Attaccanti: 0 / 6 </h3>
			<h3 id="giocatoriTot">Totale: 0 / 25 </h3>
			<input type="submit" value="Conferma Rosa" id="conferma" onclick="conferma();" disabled="false" style="background: grey"></input>
			<input type="submit" value="Azzera" style="background: red" onclick="location.href='listaGiocatori';"></input>
		</div>
	</div>



</br>
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/dragAndDrop.js"></script>
<script type="text/javascript" src="js/creaRosa.js"></script>

</html>