<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>account</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<label>Afin de mettre à jour vos infos personnelles, merci de
			renseigner les champs suivants :</label>
		<form method="post" action="Account">
			<div class="row mb-3">
				<div class="col">
					<input type="text" class="form-control" placeholder="Nom (*)"
						id="name" name="name" value="${ account.name }" required>
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="Prénom (*)"
						id="lastname" name="lastname" value="${ account.lastName }"
						required>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<input type="text" class="form-control" placeholder="Email (*)"
						id="email" name="email" value="${ account.email }" required>
				</div>

				<div class="col">
					<input type="password" class="form-control" id="password"
						placeholder="Password (*)" name="password" required>
				</div>
			</div>
			<button class="btn btn-secondary" type="submit">mettre à jour</button>
	</div>
	</form>
	</div>
	<div class="formulaire">
		<p>Mes topos:</p>
		<div class="card-deck">
			<c:forEach var="topo" items="${topos}" varStatus="status">
			<c:if test="${topo.user.idUser == account.idUser}">
				<div class="card bg-light">
					<div class="card-body text-center">
						<p class="card-text">
							<c:out value="${topo.name }" />
						</p>
						<p class="card-text">
							Statut actuel :
							<c:if test="${topo.available == true}"> Disponible </c:if>
							<c:if test="${topo.available != true}"> Indisponible </c:if>
						</p>
						<c:forEach var="reservation" items="${reservationInquiries}"
							varStatus="status">
							<c:if test="${reservation.topo.idTopo.equals(topo.idTopo)}">
								<p class="card-text">
									demande de reservation par
									<c:out value="${reservation.user.login}" />
									le
									<fmt:formatDate type="date" value="${ reservation.lendDate }" />
								</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
				</c:if>
			</c:forEach>

		</div>
		<div>
			<c:url var="topo" value="TopoAdd">
				<c:param name="id" value="${ account.idUser }" />
			</c:url>
			<a id="containerPLus" href="${ topo }">
				
				<p>Ajouter un topo</p>
			</a>
			
			<c:url var="topoManagement" value="TopoManagement">
				<c:param name="idUser" value="${ account.idUser }" />				
			</c:url>
			<a id="containerPLus" href="${ topoManagement }">
				
				<p>Gérer mes topos</p>
			</a>
		</div>
		<p>Mes demandes de reservation :</p>
		<ul class="list">
			<c:forEach var="reservation" items="${account.reservationInquiries}"
				varStatus="status">
				<li>
				<c:out value="${reservation.topo.name }" /> : <c:out value="${reservation.statut }" /> 
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>