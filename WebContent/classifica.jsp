<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>

<!-- *****************************************************************************************************************
	 BLUE WRAP
	 ***************************************************************************************************************** -->
<div id="blue">
	<div class="container">
		<div class="row">
			<h3>Classifica</h3>
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</div>
<!-- /blue -->

<!-- *****************************************************************************************************************
	DROP DOWN LEGA
	 ***************************************************************************************************************** -->

<div class="container">
	<div class="row">
		<div class="col-xs-12">

			<h2>Lega</h2>
			<!--     Begin Form -->
			<form>
				<select name="lega" id="menu" class="form-control">
					<c:forEach items="${employeeList}" var="employee">
						<c:out value="Name : ${employee.name}" />
						<c:out value="Age : ${employee.age}" />
					</c:forEach>
				</select>
			</form>
		</div>
		<!-- /col -->
	</div>
	<!-- /row-->
</div>
<!-- /container -->
<span> </span>

<!-- *****************************************************************************************************************
	 TABLE
	 ***************************************************************************************************************** -->
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12">

			<div class="table-responsive">
				<table class="table  table-hover" id="table">
					<thead>
						<tr class="info">
							<th>Posizione</th>
							<th>Nome</th>
							<th>Giornate Vinte</th>
							<th>Gol Fatti</th>
							<th>Gol Subiti</th>
							<th>Punteggio Tot.</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
