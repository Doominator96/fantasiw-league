<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
<div id="blue">
	<div class="container">
		<div class="row">
			<h3>Account.</h3>
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</div>
<!-- /blue -->


<!-- *****************************************************************************************************************
	 BLOG CONTENT
	 ***************************************************************************************************************** -->

<div class="container mtb">
	<div class="row">

		<! -- BLOG POSTS LIST -->
		<div class="col-lg-8">
			<! -- Blog Post 1 -->
			<p>
				<img class="img-responsive" src="img/silhouette.jpg">
			</p>
			<h3 class="ctitle">Nome Utente: ${username}</h3>
			<div class="hline"></div>
			<h3 class="ctitle" >Email: ${email}</h3>
			<div class="hline"></div>
			<h3 class="ctitle" >Password: ${password}</h3>
			<a class="btn btn-theme" id="test" type="button" data-toggle="modal" data-target="#myModal">Cambia Password</a>
				<div id="myModal" class="modal fade" >
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button class="close" type="button" data-dismiss="modal">×</button>
								<h4 class="modal-title">Cambio Password</h4>
							</div>
							<div class="modal-body">
								<div class="popup">
									<form action="cambiaPassword" method="POST">
										<input type="password" id="vpassword" name="vpassword" required /> <label
											for="vpassword">Vecchia Password</label> <input type="password" id="npassword"
											name="npassword" required /> <label for="npassword">Nuova Password</label>


										<input type="submit" name="submit" value="Cambia">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>	
		</div>
				<div class="col-lg-8">
		<h3 class="ctitle">ROSE UTENTE</h3>
		

	</div>
	<! --/row -->
</div>
<! --/container -->
<jsp:include page="footer.jsp"></jsp:include>
