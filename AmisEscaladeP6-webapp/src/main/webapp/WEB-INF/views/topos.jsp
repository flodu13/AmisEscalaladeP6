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
<title>topos</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="listSpot">
		<p>Voici la liste de nos topos</p>

		<div class="formulaire">
			<form method="post" action="Topos">
				<div class="row mb-3">
					<div class="col">
						<select id="location" name="location" class="form-control">
							<option value="">Choisissez la région</option>
							<option value="PACA">PACA</option>
							<option value="NOUVELLE-AQUITAINE">PYRENEES-ORIENTALES</option>
							<option value="AUVERGNE-RHONE-ALPES">AUVERGNE-RHONE-ALPES</option>
							<option value="etc...">etc...</option>
						</select>
					</div>
					<div class="col">
						<input type="text" class="form-control" placeholder="nom du topo"
							id="name" name="name">
					</div>
					<div class="col">
						<input type="checkbox" name="available" id="available"
							value="true" /> <label for id="available">Afficher
							uniquement les topos disponibles</label>
					</div>
				</div>
				<button class="btn btn-secondary" type="submit">Filtrer</button>
		</div>
		<div class="card-deck" >
			<c:forEach var="topo" items="${topos}" varStatus="status">
				<c:if test="${sessionScope.currentUser.idUser != topo.user.idUser}">
					<div class="card bg-light"  style="width: 30%">
						<div class="card-body text-center">
							<p class="card-text">
								<c:out value="${topo.name }" />
								:
							</p>
							<p class="card-text">
								<c:out value="${topo.description }" />
							</p>
							<p class="card-text">
								Déposer par
								<c:out value="${topo.user.login }" />
								le
								<fmt:formatDate type="date" value="${ topo.publicationDate }" />
							</p>
							<p class="card-text">
								<c:if test="${topo.available != true}">
									<p class="card-text">Indisponible</p>
								</c:if>
							</p>
							<p class="card-text">
								<p>
								votre message à <c:out value="${topo.user.login }" /> :
								</p>
								<p>
								<c:if test="${topo.available == true}">
									<textarea class="comment" cols="55" rows="5" name="comment">
  								</textarea>
								</c:if>
								</P>
							</p>
							<c:if test="${topo.available == true}">
							<input type="hidden" name="idUser"
								value="${ sessionScope.currentUser.idUser }" /> <input
								type="hidden" name="idTopo" value="${ topo.idTopo }" />
							<button class="btn btn-secondary" type="submit">Réserver</button>
							</c:if>
						</div>
					</div>
				</c:if>
			</c:forEach>
			</form>
		</div>
	</div>
</body>
</html>