<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="img/favicon.ico">

<title>Fantasiw League</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">


<link rel="stylesheet" href="css/popup.css">
<link rel="stylesheet" href="css/field.css">
</head>

<body id="formazione">

	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home.jsp">FANTASIW LEAGUE</a>
			</div>
			<div class="navbar-collapse collapse navbar-right">
				<ul class="nav navbar-nav">
					<li ><a href="home.jsp">HOME</a></li>
					<li><a href="leghe">CLASSIFICA</a></li>
					<li><a href="formazione.jsp">FORMAZIONE</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">UTENTE <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="account.jsp">ACCOUNT</a></li>
							<li><a href="roseUtente">SQUADRA</a></li>
							<li><a href="storico-scontri.jsp">STORICO SCONTRI</a></li>
							<li><a href="logout">LOGOUT</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	
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

	<!-- *****************************************************************************************************************
	 SECTION OF DRAGGABLE PLAYERS
	 ***************************************************************************************************************** -->

	<section>
	  <h1>I tuoi giocatori</h1>
	  
	  <div class="positions menu">
	    <a>Goalkeepers</a>
	    <ul data-pos="gk">
	      <li>
	        <div draggable="true" data-player="J.Hart">
	          <img draggable="false" src="img/formazione/orange.png">
	          <p>J.Hart</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="B.Forster">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=9089"/>
	          <p>B.Forster</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="F.Foster">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=40383"/>
	          <p>F.Foster</p>
	        </div>
	      </li>
	    </ul>
	  </div>
	
	  <div class="positions menu">
	    <a>Defenders</a>
	    <ul data-pos="df">
	      <li>
	        <div draggable="true" data-player="L.Baines">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=12745"/>
	          <p>L.Baines</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="G.Cahill">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=19419"/>
	          <p>G.Cahill</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="P.Jagielka">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=7645"/>
	          <p>P.Jagielka</p>
	        </div>
	      </li>
	      <li>        
	        <div draggable="true" data-player="G.Johnson">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=9047"/>
	          <p>G.Johnson</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="L.Shaw">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=106760"/>
	          <p>L.Shaw</p>
	        </div>
	      </li>
	      <li><div draggable="true" data-player="C.Smalling">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=55909"/>
	          <p>C.Smalling</p>
	        </div>
	      </li>
	      <li><div draggable="true" data-player="P.Jones">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=76359"/>
	          <p>P.Jones</p>
	        </div>
	      </li>
	    </ul>
	  </div>
	  
	  <div class="positions menu">
	    <a>Midfielders</a>
	    <ul data-pos="md">
	      <li>
	        <div draggable="true" data-player="R.Barkley">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=88894"/>
	          <p>R.Barkley</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="R.Sterling">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=103955"/>
	          <p>R.Sterling</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="S.Gerrard">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=1814"/>
	          <p>S.Gerrard</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="J.Henderson">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=56979"/>
	          <p>J.Henderson</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="A.Lallana">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=39155"/>
	          <p>A.Lallana</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=2051"/>
	          <p>F.Lampard</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="J.Milner">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=15157"/>
	          <p>J.Milner</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="O.Chamberlain">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=81880"/>
	          <p>O.Chamberlain</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="J.Wilshere">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=54102"/>
	          <p>J.Wilshere</p>
	        </div>
	      </li>
	    </ul>
	  </div>
	  
	  <div class="positions menu">
	    <a>Forwards</a>
	    <ul data-pos="fw">
	      <li>
	        <div draggable="true" data-player="R.Lambert">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=11037"/>
	          <p>R.Lambert</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="W.Rooney">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=13017"/>
	          <p>W.Rooney</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="D.Sturridge">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=40755"/>
	          <p>D.Sturridge</p>
	        </div>
	      </li>
	      <li>
	        <div draggable="true" data-player="D.Welbeck">
	          <img draggable="false" src="http://omo.akamai.opta.net/image.php?&sport=football&entity=player&description=114&dimensions=40x60&id=50175"/>
	          <p>D.Welbeck</p>
	        </div>
	      </li>
	    </ul>
	  </div>
	</section>

	
	
	
	
	<!-- *****************************************************************************************************************
	 
	 STARTING 11
	 *****************************************************************************************************************-->

	<canvas id="pitch" width="600" height="600"></canvas>

	<ul id="starting_11" class="4-4-2">
	  <li data-pos="gk" id="pos1"></li>
	  <li data-pos="df" id="pos2" draggable="true"></li>
	  <li data-pos="df" id="pos3" draggable="true"></li>
	  <li data-pos="df" id="pos4" draggable="true"></li>
	  <li data-pos="df" id="pos5" draggable="true"></li>
	  <li data-pos="md" id="pos6" draggable="true"></li>
	  <li data-pos="md" id="pos7" draggable="true"></li>
	  <li data-pos="md" id="pos8" draggable="true"></li>
	  <li data-pos="md" id="pos9" draggable="true"></li>
	  <li data-pos="fw" id="pos10" draggable="true"></li>
	  <li data-pos="fw" id="pos11" draggable="true"></li>
	</ul>

	
	<!-- *****************************************************************************************************************
	 SOCCER FIELD
	 ***************************************************************************************************************** --> 
	 	
	  <div class="stage">
	  <div class="world">
	    <div class="team"></div>
	    <div class="terrain">
	      <div class="field ground">
	        <div class="field__texture field__texture--gradient"></div>
	        <div class="field__texture field__texture--gradient-b"></div>
	        <div class="field__texture field__texture--grass"></div>
	        <div class="field__line field__line--goal"></div>
	        <div class="field__line field__line--goal field__line--goal--far"></div>
	        <div class="field__line field__line--outline"></div>
	        <div class="field__line field__line--penalty"></div>
	        <div class="field__line field__line--penalty-arc"></div>
	        <div class="field__line field__line--penalty-arc field__line--penalty-arc--far"></div>
	        <div class="field__line field__line--mid"></div>
	        <div class="field__line field__line--circle"></div>
	        <div class="field__line field__line--penalty field__line--penalty--far"></div>
	      </div>
	      <div class="field__side"></div>
	    </div>
	  </div>
	</div>


<!--  --------------------- -->

 
	
<script src="js/field.js" type="text/javascript"></script> 
	<c:if test="${not loggato}">
		<script>
		window.location = "index.jsp";
		</script>
	</c:if>

</body>

<footer>

<!-- *****************************************************************************************************************
	 FOOTER
	 ***************************************************************************************************************** -->
	<div id="footerwrap">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>Informazioni</h4>
					<div class="hline-w"></div>
					<p>Progetto realizzato per il corso di Sistemi Informativi per
						il Web.</p>
				</div>
				<div class="col-lg-4">
					<h4>Social</h4>
					<div class="hline-w"></div>
					<p>
						<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
							class="fa fa-twitter"></i></a> <a href="#"><i
							class="fa fa-instagram"></i></a>
					</p>
				</div>
				<div class="col-lg-4">
					<h4>Contattaci</h4>
					<div class="hline-w"></div>
					<p>
						Unical,CdL in Informatica<br /> 87036,Arcavacata,<br /> Italia.<br />
					</p>
				</div>

			</div>
			<! --/row -->
		</div>
		<! --/container -->
	</div>
	<! --/footerwrap -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.hoverdir.js"></script>
	<script src="js/jquery.hoverex.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/jquery.isotope.min.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/popup.js"></script>
	<script src="js/redirect.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</footer>

</html>
	 
	 
	 