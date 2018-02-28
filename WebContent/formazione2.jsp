<html>
<link href="css/modulo.css">
<link href="css/formazione2.css" rel="stylesheet">
<jsp:include page="header.jsp"></jsp:include>

<%@ page import="java.util.Date" %>
<%@ page import="controller.Formazione2" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<body>
<jsp:include page="navbar.jsp"></jsp:include>
<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
	<div id="blue">
	    <div class="container">
			<div class="row">
				<h3>Inserisci la formazione</h3>
			</div><!-- /row -->
	    </div> <!-- /container -->
	</div><!-- /blue -->

<form action="giocatoriRosa" method="POST">
				<select name="rose1" class="form-control" id="rose1" style="width:350px ; margin-left:2%" onchange="this.form.submit()">
				<option >Scegli una Squadra</option>
					<c:forEach items="${roseG}" var="r">
						<option value="${r.id}">${r.nome} Lega: ${r.lega.nome}</option>
					</c:forEach>
				</select>
			</form>

<div class="popup">
 <div id="sel1">
 <h3>Scegli Portiere</h3>
<select id="portieri" class="js-example-basic-multiple" name="states[]" multiple="multiple">
  <option value="AL">port</option>
  <option value="WY">Wyoming</option>
</select>
</div>
<div id="sel2">
 <h3>Scegli Difensori</h3>
<select id="difensori" class="js-example-basic-multiple" name="states[]" multiple="multiple">
  <option value="AL">dif</option>
  <option value="WY">c</option>
</select>
</div>
<div id="sel3">
 <h3>Scegli Centrocampisti</h3>

<select id="centrocampisti" class="js-example-basic-multiple" name="states[]" multiple="multiple">
  <option value="AL">ccwadwadwadsafsaf</option>
  <option value="WY">wrt</option>
</select>
</div>
<div id="sel4">
 <h3>Scegli Attaccanti</h3>

<select id="attaccanti" class="js-example-basic-multiple" name="states[]" multiple="multiple">
  <option value="AL">att</option>
  <option value="WY">eqrqfq</option>
</select>
 </div>
 <span id="close" style="position: absolute;right: 3%;top: 5%;"><?xml version="1.0" encoding="iso-8859-1"?>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 44 44" enable-background="new 0 0 44 44" width="24px" height="24px">
    <path d="m22,0c-12.2,0-22,9.8-22,22s9.8,22 22,22 22-9.8 22-22-9.8-22-22-22zm3.2,22.4l7.5,7.5c0.2,0.2 0.3,0.5 0.3,0.7s-0.1,0.5-0.3,0.7l-1.4,1.4c-0.2,0.2-0.5,0.3-0.7,0.3-0.3,0-0.5-0.1-0.7-0.3l-7.5-7.5c-0.2-0.2-0.5-0.2-0.7,0l-7.5,7.5c-0.2,0.2-0.5,0.3-0.7,0.3-0.3,0-0.5-0.1-0.7-0.3l-1.4-1.4c-0.2-0.2-0.3-0.5-0.3-0.7s0.1-0.5 0.3-0.7l7.5-7.5c0.2-0.2 0.2-0.5 0-0.7l-7.5-7.5c-0.2-0.2-0.3-0.5-0.3-0.7s0.1-0.5 0.3-0.7l1.4-1.4c0.2-0.2 0.5-0.3 0.7-0.3s0.5,0.1 0.7,0.3l7.5,7.5c0.2,0.2 0.5,0.2 0.7,0l7.5-7.5c0.2-0.2 0.5-0.3 0.7-0.3 0.3,0 0.5,0.1 0.7,0.3l1.4,1.4c0.2,0.2 0.3,0.5 0.3,0.7s-0.1,0.5-0.3,0.7l-7.5,7.5c-0.2,0.1-0.2,0.5 3.55271e-15,0.7z" fill="#D80027"></path>
  </svg>
 </span>
</div>




<div class="bd" style="display:table-caption;">
<div class="container">
<div class="input-btn-group">
  <label>
    <input type="radio" name="formation" id="433" checked  onclick="check()"> <span></span> 4-3-3
  </label>
  <label>
    <input type="radio" name="formation" id="442"  onclick="check()"> <span></span>4-4-2
  </label>
  <label>
    <input type="radio" name="formation" id="352"  onclick="check()"> <span></span> 3-5-2
  </label>
  <label>
    <input type="radio" name="formation" id="343"  onclick="check()"> <span></span> 3-4-3
  </label>
</div>
</div> 




		<div class="col-md-6 pull-right">
		<h3 style="color: green">Tempo Restante Per Mettere La Formazione: </h3>
<H2 id="Timer"></H2>
</br>
<input type="submit" value="Conferma Rosa" id="conferma" onclick="conferma();" disabled="false" style="background: grey"></input>
			<input type="submit" value="Azzera" style="background: red" onclick="location.href='listaGiocatori';"></input> 
</div>

<div class="pitch" id="m1"style="display: table">
			<div class="container ">
			
				<div class="box1">
							<div class="pen1">
						<div class="pos g1" style="margin: 5px 14px;"><a class="gioc1" id="p">1</a></div>
					</div>
				</div>
				<div class="pos g2" style="margin: 90px 51px"><a class="gioc2" id="d">2</a></div>
				<div class="pos g3" style="margin: 90px 122px;"><a class="gioc3" id="d">3</a></div>
				<div class="pos g4" style="margin: 90px 184px"><a class="gioc4" id="d">4</a></div>
				<div class="pos g5" style="margin: 90px 255px"><a class="gioc5" id="d">5</a></div>
				<div class="pos g6" style="margin: 175px 76px"><a class="gioc6" id="c">6</a></div>
				<div class="pos g7" style="margin: 175px 152px"><a class="gioc7" id="c">7</a></div>
				<div class="pos g8" style="margin: 175px 232px"><a class="gioc8" id="c">8</a></div>
				<div class="pos g9" style="margin: 295px 76px;"><a class="gioc9" id="a">9</a></div>
				<div class="pos g10" style="margin: 295px 152px;"><a class="gioc10" id="a">10</a></div>
				<div class="pos g11" style="margin: 295px 229px;"><a class="gioc11" id="a">11</a></div>

				<div class="half"></div>
				<div class="box2">
					<div class="pen2"></div>
				</div>
			</div>
		</div>		
			

</div>



<jsp:include page="footer.jsp"></jsp:include>
<script src="js/formazioneDropdown.js" type="text/javascript"></script>
<script src="js/formazione.js" type="text/javascript" ></script> 
<script type="text/javascript" src="js/modulo.js"></script>
	
</body>
</html>