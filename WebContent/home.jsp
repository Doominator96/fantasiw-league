<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${not loggato}">
		<script>
		window.location = "index.jsp";
		</script>
	</c:if>  

<jsp:include page="header.jsp"></jsp:include>
<link rel="stylesheet" href="css/popup.css">
<body>
<jsp:include page="navbar.jsp"></jsp:include>



<div id="headerwrap">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h3>La miglior soluzione per il tuo fantacalcio</h3>
				<h1>Fantasiw League 2017/2018</h1>
			</div>
			<div class="col-lg-12">
				<img src="img/calcio.jpg" class="img-responsive">
			</div>
		</div>
	</div>
</div>

<!-- *****************************************************************************************************************
	 SERVICE LOGOS
	 ***************************************************************************************************************** -->
<div id="service">
	<div class="container">
		<div class="row centered">
			<div class="col-md-6">
				<i class="fa fa-gear"></i>
				<h4>Crea Lega</h4>
				<p>Crea quì la tua lega e invita i tuoi amici a partecipare.</p>
				<br /> <a class="btn btn-theme" id="test" type="button" data-toggle="modal" data-target="#myModalLega">Vai</a>
				</div>
				<div id="myModalLega" class="modal fade" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button class="close" type="button" data-dismiss="modal">×</button>
								<h4 class="modal-title">Crea La tua Lega</h4>
							</div>
							<div class="modal-body">
								<div class="popup">
									<form action="creaLega" method="POST">
										<input type="text" id="nome" name="nome" required /> <label
											for="nome">Nome</label> <input type="password" id="password"
											name="password" required /> <label for="password">Password</label>


										<input type="submit" name="submit" value="Crea">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			
			<div class="col-md-6">
				<i class="fa fa-pencil"></i>
				<h4>Crea Rosa</h4>
				<p>Acquista i giocatori e componi la squadra dei tuoi sogni.</p>
				<p>
					<br /> <a class="btn btn-theme" id="test" type="button" data-toggle="modal" data-target="#myModalRosa">Vai</a>
					</div>
				<div id="myModalRosa" class="modal fade" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button class="close" type="button" data-dismiss="modal">×</button>
								<h4 class="modal-title">Crea La tua Rosa</h4>
							</div>
							<div class="modal-body">
								<div class="popup">
									<form action="creaRosa" method="POST">
										<input type="text" id="nomeRosa" name="nomeRosa" required /> <label
											for="nome">Nome Rosa</label>
										<input type="text" id="nomeLega" name="nomeLega" required /> <label
											for="nome">Nome Lega</label>
										<input type="password" id="passwordLega" name="passwordLega" required /> <label
											for="nome">Password Lega</label>
										<input type="submit" name="submit" value="Crea">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			


			
		</div>
	</div>
	<!--/container -->
</div>
<!--/service -->

<!-- *****************************************************************************************************************
	 PORTFOLIO SECTION
	 ***************************************************************************************************************** -->
<div id="portfoliowrap">
	<h3>Ultime Notizie dalla Serie A</h3>

	<div class="portfolio-centered">
		<div class="recentitems portfolio">
			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/atalanta.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Atalanta</h3>
							<a data-rel="prettyPhoto" href="img/loghi/atalanta.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i> <script
									src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FAtalanta.xml&detail=-1&limit=1&showtitle=false&type=js"></script>
							</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/benevento.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Benevento</h3>
							<a data-rel="prettyPhoto" href="img/loghi/benevento.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FBenevento.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/bologna.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Bologna</h3>
							<a data-rel="prettyPhoto" href="img/loghi/bologna.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FBologna.xml&detail=-1&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/cagliari.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Cagliari</h3>
							<a data-rel="prettyPhoto" href="img/loghi/cagliari.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FCagliari.xml&detail=-1&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/chievo.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Chievo</h3>
							<a data-rel="prettyPhoto" href="img/loghi/chievo.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FChievo.xml&detail=-1&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/crotone.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Crotone</h3>
							<a data-rel="prettyPhoto" href="img/loghi/crotone.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FCrotone.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/fiorentina.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Fiorentina</h3>
							<a data-rel="prettyPhoto" href="img/loghi/fiorentina.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FFiorentina.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/genoa.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Genoa</h3>
							<a data-rel="prettyPhoto" href="img/loghi/genoa.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FGenoa.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/hellas.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Hellas Verona</h3>
							<a data-rel="prettyPhoto" href="img/loghi/hellas.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FVerona.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/inter.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Inter</h3>
							<a data-rel="prettyPhoto" href="img/loghi/inter.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FInter.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/juventus.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Juventus</h3>
							<a data-rel="prettyPhoto" href="img/loghi/juventus.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FJuventus.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/lazio.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Lazio</h3>
							<a data-rel="prettyPhoto" href="img/loghi/lazio.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FLazio.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/milan.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Milan</h3>
							<a data-rel="prettyPhoto" href="img/loghi/milan.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FMilan.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/napoli.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Napoli</h3>
							<a data-rel="prettyPhoto" href="img/loghi/napoli.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FNapoli.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/roma.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Roma</h3>
							<a data-rel="prettyPhoto" href="img/loghi/roma.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FRoma.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/sampdoria.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Sampdoria</h3>
							<a data-rel="prettyPhoto" href="img/loghi/sampdoria.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FSampdoria.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/sassuolo.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Sassuolo</h3>
							<a data-rel="prettyPhoto" href="img/loghi/sassuolo.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FSassuolo.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/spal.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">SPAL</h3>
							<a data-rel="prettyPhoto" href="img/loghi/spal.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FSpal.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/torino.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Torino</h3>
							<a data-rel="prettyPhoto" href="img/loghi/torino.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FTorino.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->

			<div class="portfolio-item graphic-design">
				<div class="he-wrap tpl6">
					<img src="img/loghi/udinese.png" alt="">
					<div class="he-view">
						<div class="bg a0" data-animate="fadeIn">
							<h3 class="a1" data-animate="fadeInDown">Udinese</h3>
							<a data-rel="prettyPhoto" href="img/loghi/udinese.png"
								class="dmbutton a2" data-animate="fadeInUp"><i
								class="fa fa-search"></i><script src="//rss.bloople.net/?url=http%3A%2F%2Fwww.gazzetta.it%2Frss%2FSquadre%2FUdinese.xml&detail=&limit=1&showtitle=false&type=js"></script>
								</a>
						</div>
						<!-- he bg -->
					</div>
					<!-- he view -->
				</div>
				<!-- he wrap -->
			</div>
			<!-- end col-12 -->



		</div>
		<!-- portfolio -->
	</div>
	<!-- portfolio container -->
</div>
<!--/Portfoliowrap -->

<!-- *****************************************************************************************************************
	 Collaborazioni
	 ***************************************************************************************************************** -->
<div id="cwrap">
	<div class="container">
		<div class="row centered">
			<h3>In collaborazione con:</h3>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<img src="img/seriea.png" class="img-responsive">
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<img src="img/fifa.png" class="img-responsive">
			</div>
		</div>
	</div>
	<!-- /row -->
</div>
<!-- /container -->


	
	
<jsp:include page="footer.jsp"></jsp:include>

<script src="js/home.js"></script>
</body>
</html>