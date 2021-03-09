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
<title>detail secteur</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<div class="row mb-3">
			<div class="detailSpot">
				<div class="image-gauche">
					<img src="images/<c:out value="${infospot.name}"/>.png"
						class="detailSpotImg" />
				</div>
				<div class="texte-droite">
					<h3>
						Site :
						<c:out value="${ infospot.name }" />
						-
						<c:out value="${ infosector.name }" />
					</h3>

					<h5>voies :</h5>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Nom du secteur</th>
								<th scope="col">Hauteur</th>
								<th scope="col">Cotation</th>
								<th scope="col">Nombre de longueurs</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="path" items="${infosector.paths}"
								varStatus="status">
								<tr>
									<td>
										<li><c:out value="${path.name }" /> (<c:out
												value="${path.height }" /> m, <c:out
												value="${path.cotation }" />, <c:out
												value="${path.numberOfLengh }" />, <c:out
												value="${path.pointNumber }" />)</li>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${sessionScope.currentUser != null}">
						<div>
							<c:url var="path" value="PathAdd">
								<c:param name="idsector" value="${idsector}" />
							</c:url>
							<a id="containerPLus" href="${ path }">
								<p>
									<img src="images/plus.png" id="plus">
								</p>
								<p>Ajouter une voie</p>
							</a>
						</div>
					</c:if>
				</div>

			</div>
		</div>
	</div>
</body>
</html>