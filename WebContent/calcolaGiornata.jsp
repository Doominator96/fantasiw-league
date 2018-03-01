<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<link href="css/popup.css" rel="stylesheet">

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
<select id="leghe" class="js-example-basic-single col-md-12" name="state" onChange="stampaRose()">
 <c:forEach items="${leg}" var="l">
	<option value="${l.id}">${l.nome}</option>
  </c:forEach>
</select>
</br>
</br>

	<h2 class="centered">Scegli Rosa</h2>
<select id="rose" class="js-example-basic-single col-md-12" name="state" onchange="stampaGiocatori()">

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
							<th>Cognome</th>
							<th>Squadra</th>
							<th>Gol Subiti</th>
							<th>Gol</th>
							<th>Rigore</th>
							<th>Rigore Sbagliato</th>
							<th>Assist</th>
							<th>C. Giallo</th>
							<th>Voto</th>
						</tr>
					</thead>
					<tbody id="tab">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<input type="submit" id="calcola" disabled="true" value="Calcola Voti" onclick="calc()" style="background-color: grey">
</body>
<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/calcolaVoto.js"></script>
<script type="text/javascript" src="js/formazione.js"></script>

</html>