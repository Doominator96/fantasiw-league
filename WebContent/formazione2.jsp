<html>
<jsp:include page="header.jsp"></jsp:include>

<link href="css/formazione2.css" rel="stylesheet">
<%@ page import="java.util.Date" %>
<%@ page import="controller.Formazione2" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<body>
<jsp:include page="navbar.jsp"></jsp:include>
<link href="css/modulo.css">
  <script src="js/formazione.js" type="text/javascript" ></script> 
<script type="text/javascript" src="js/modulo.js"></script>
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

<H1>${minDate}</H1>

<div class="container">
<div class="btn-group" data-toggle="buttons">
  <label>
    <input type="radio" name="formation" id="442" autocomplete="off" checked onclick="check()"> <span></span>4-4-2
  </label>
  <label>
    <input type="radio" name="formation" id="433" autocomplete="off" onclick="check()"> <span></span> 4-3-3
  </label>
  <label>
    <input type="radio" name="formation" id="352" autocomplete="off" onclick="check()"> <span></span> 3-5-2
  </label>
  <label>
    <input type="radio" name="formation" id="343" autocomplete="off" onclick="check()"> <span></span> 3-4-3
  </label>
</div>
<!-- 
    <div class="row-fluid">     
        <div class="span12">
            <div id="counter">
            <a id="over" href="hmj" class="P1" target="_blank">Portiere
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="D1" target="_blank">Difensore
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="D2" target="_blank">Difensore
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="D3" target="_blank">Difensore
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="D4" target="_blank">Difensore
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="C1" target="_blank">Centrocampista
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="C2" target="_blank">Centrocampista
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="C3" target="_blank">Centrocampista
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="C4" target="_blank">Centrocampista
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="A1" target="_blank">Attacante
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                <a id="over" href="hmj" class="A2" target="_blank">Attaccante
                <img class="img-responsive" src="img/formazione/red.png" alt="1" />
                </a>
                
                <img src="img/formazione/field.jpg" alt="bg" />
            </div>
        </div>           
    </div>
	-->
</div> 
 
<button onclick="data()";>PROVA</button>



<div class="pitch">
			<h4>3-4-2-1</h4>
			<div class="container">
				<div class="box1">
					<div class="pen1">
						<div class="pos" style="margin: 5px 17px;">1</div>
					</div>
				</div>
				<div class="pos" style="margin: 65px 90px">2</div>
				<div class="pos" style="margin: 65px 157px;">3</div>
				<div class="pos" style="margin: 65px 224px">4</div>

				<div class="pos" style="margin: 114px 53px">5</div>
				<div class="pos" style="margin: 114px 126px">6</div>
				<div class="pos" style="margin: 114px 186px">7</div>
				<div class="pos" style="margin: 114px 258px">8</div>

				<div class="pos" style="margin: 165px 90px;">9</div>
				<div class="pos" style="margin: 165px 222px;">10</div>

				<div class="pos" style="margin: 198px 157px;">11</div>

				<div class="half"></div>
				<div class="box2">
					<div class="pen2"></div>
				</div>
			</div>
		</div>
<div id="demo"></div>
<script>

</script>







</body>
</html>