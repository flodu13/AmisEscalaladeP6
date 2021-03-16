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
<title>mes topos</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<div class="card-deck">

			<c:forEach var="topo" items="${topos}" varStatus="status">
				<form method="post" action="TopoManagement">
					<div class="card bg-light">
						<div class="card-body text-center">
							<input type="hidden" name="idTopo" value="${ topo.idTopo }" />
							<p class="card-text">
								<c:out value="${topo.name }" />
							</p>
							<c:if test="${topo.available != true}">
								<p class="card-text">
									<input type="checkbox" name="available" id="available"
										value="true" /> <label for id="available">passer le
										topo comme étant disponible</label>
								</p>
							</c:if>

							<p class="card-text">demande de réservation :</p>
							<c:forEach var="reservation" items="${topo.reservationInquiries}"
								varStatus="status">
								<input type="hidden" name="idReservation"
									value="${ reservation.idInquiry }" />
								<p class="card-text">
									<c:out value="${reservation.user.login }" />
									(demande envoyée le :
									<fmt:formatDate type="date" value="${ reservation.lendDate }" />
									)
								</p>
								<p class="card-text">
									<c:out value="${ reservation.message }" />
								</p>
								<p class="card-text">
									<c:out value="${ reservation.user.email }" />
								</p>
								<p class="card-text">
									<c:if
			test="${reservation.statut.equals(\"en cours\")}">
									<input type="checkbox" name="reserved" id="reserved"
										value="true" /> <label for id="reserved">accepter la
										demande</label>
										</c:if>
										<c:if
			test="${reservation.statut.equals(\"acceptée\")}">
									demande acceptée
									
										</c:if>
					
								</p>
							</c:forEach>
							<p class="card-text">							
								<button class="btn btn-secondary" type="submit">mettre
									à jour</button>
							</p>
						</div>
					</div>
				</form>
			</c:forEach>

		</div>
	</div>
</body>
</html>