<html>
<jsp:include page="header.jsp"></jsp:include>

<link href="css/formazione2.css" rel="stylesheet">
<%@ page import="java.util.Date" %>
<%@ page import="controller.Formazione2" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<body>
<jsp:include page="navbar.jsp"></jsp:include>
<link href="css/modulo.css">
<script type="text/javascript" src="js/modulo.js"></script>
<jsp:include page="header.jsp"></jsp:include>
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

<div class="popup">
  <h2>Scegli Giocatore</h2>
  	<select class="js-example-basic-single" id="e1" name="state">
  	<option value="AL">Alabama</option>
  	<option value="WY">Wyoming</option>
</select>
  <span id="close" style="position: absolute;right: 3%;top: 5%;"><?xml version="1.0" encoding="iso-8859-1"?>
  <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" viewBox="0 0 44 44" enable-background="new 0 0 44 44" width="24px" height="24px">
    <path d="m22,0c-12.2,0-22,9.8-22,22s9.8,22 22,22 22-9.8 22-22-9.8-22-22-22zm3.2,22.4l7.5,7.5c0.2,0.2 0.3,0.5 0.3,0.7s-0.1,0.5-0.3,0.7l-1.4,1.4c-0.2,0.2-0.5,0.3-0.7,0.3-0.3,0-0.5-0.1-0.7-0.3l-7.5-7.5c-0.2-0.2-0.5-0.2-0.7,0l-7.5,7.5c-0.2,0.2-0.5,0.3-0.7,0.3-0.3,0-0.5-0.1-0.7-0.3l-1.4-1.4c-0.2-0.2-0.3-0.5-0.3-0.7s0.1-0.5 0.3-0.7l7.5-7.5c0.2-0.2 0.2-0.5 0-0.7l-7.5-7.5c-0.2-0.2-0.3-0.5-0.3-0.7s0.1-0.5 0.3-0.7l1.4-1.4c0.2-0.2 0.5-0.3 0.7-0.3s0.5,0.1 0.7,0.3l7.5,7.5c0.2,0.2 0.5,0.2 0.7,0l7.5-7.5c0.2-0.2 0.5-0.3 0.7-0.3 0.3,0 0.5,0.1 0.7,0.3l1.4,1.4c0.2,0.2 0.3,0.5 0.3,0.7s-0.1,0.5-0.3,0.7l-7.5,7.5c-0.2,0.1-0.2,0.5 3.55271e-15,0.7z" fill="#D80027"/>
  </svg>
  </span>
</div>

<div class="container">
<div class="btn-group" data-toggle="buttons">
  <label>
    <input type="radio" name="formation" id="442" autocomplete="off" onclick="check()"> <span></span>4-4-2
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
<div class="pitch">
			<div class="container">
				<div class="m1">
					<div class="pos" style="margin: 5px 17px;" onclick=>1</div>
				
					<button class="gio"><div class="pos" style="margin: 65px 90px">2</div></button>
				
					<div class="pos" style="margin: 65px 157px;">3</div>
					<div class="pos" style="margin: 65px 224px;">4</div>

					<div class="pos" style="margin: 114px 53px;">5</div>
					<div class="pos" style="margin: 114px 126px;">6</div>
					<div class="pos" style="margin: 114px 186px;">7</div>
					<div class="pos" style="margin: 114px 258px;">8</div>

					<div class="pos" style="margin: 165px 90px;">9</div>
					<div class="pos" style="margin: 165px 222px;">10</div>

					<div class="pos" style="margin: 198px 157px;">11</div>
				</div>
				<div class="m2">
					<div class="pos" style="margin: 5px 17px;" onclick=>1</div>
				
					<button class="gio"><div class="pos" style="margin: 65px 90px">2</div></button>
				
					<div class="pos" style="margin: 65px 157px;">3</div>
					<div class="pos" style="margin: 65px 224px">4</div>

					<div class="pos" style="margin: 114px 53px">5</div>
					<div class="pos" style="margin: 114px 126px">6</div>
					<div class="pos" style="margin: 114px 186px">7</div>
					<div class="pos" style="margin: 114px 258px">8</div>

					<div class="pos" style="margin: 165px 90px;">9</div>
					<div class="pos" style="margin: 165px 222px;">10</div>

					<div class="pos" style="margin: 198px 157px;">11</div>
				</div>
				
				<div class="m3">
					<div class="pos" style="margin: 5px 17px;" onclick=>1</div>
				
					<button class="gio"><div class="pos" style="margin: 65px 90px">2</div></button>
				
					<div class="pos" style="margin: 65px 157px;">3</div>
					<div class="pos" style="margin: 65px 224px">4</div>

					<div class="pos" style="margin: 114px 53px">5</div>
					<div class="pos" style="margin: 114px 126px">6</div>
					<div class="pos" style="margin: 114px 186px">7</div>
					<div class="pos" style="margin: 114px 258px">8</div>

					<div class="pos" style="margin: 165px 90px;">9</div>
					<div class="pos" style="margin: 165px 222px;">10</div>

					<div class="pos" style="margin: 198px 157px;">11</div>
				</div>
				
				<div class="m4">
					<div class="pos" style="margin: 5px 17px;" onclick=>1</div>
				
					<button class="gio"><div class="pos" style="margin: 65px 90px">2</div></button>
				
					<div class="pos" style="margin: 65px 157px;">3</div>
					<div class="pos" style="margin: 65px 224px">4</div>

					<div class="pos" style="margin: 114px 53px">5</div>
					<div class="pos" style="margin: 114px 126px">6</div>
					<div class="pos" style="margin: 114px 186px">7</div>
					<div class="pos" style="margin: 114px 258px">8</div>

					<div class="pos" style="margin: 165px 90px;">9</div>
					<div class="pos" style="margin: 165px 222px;">10</div>

					<div class="pos" style="margin: 198px 157px;">11</div>
				</div>
				
			</div>
				
			</div>
			
			
<div id="demo"></div>




<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="js/formazioneDropdown.js"></script>

  <script src="js/formazione.js" type="text/javascript" ></script> 

</body>
</html>