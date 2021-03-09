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
<title>detailspot</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">

		<c:if
			test="${sessionScope.currentUser.role.code == 2 and infospot.tag != true}">
			<form class="form-inline" method="post" action="SpotTag">
				<input type="hidden" name="id" value="${ infospot.getIdSpot() }" />
				<button class="btn btn-secondary m-3" type="submit">Ajouter
					aux officiels</button>
			</form>
		</c:if>
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
					</h3>
					<p>Info site:</p>
					<ul class="list">
						<li>Localisation : <c:out
								value="${ infospot.address.streetNumber }" /> <c:out
								value="${ infospot.address.streetName }" /> <c:out
								value="${ infospot.address.postCode }" /> <c:out
								value="${ infospot.address.city }" /> (<c:out
								value="${ infospot.address.country }" />)
						</li>
						<li>Cotation: <c:out value="${ infospot.difficultLevel }" /></li>
					</ul>
					<p>Voies :</p>
					
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Nom du secteur</th>
								<th scope="col">Nom de la voie</th>
								<th scope="col">Hauteur</th>
								<th scope="col">Cotation</th>
								<th scope="col">Nombre de longueurs</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sector" items="${infospot.sectors}"
								varStatus="status">
								<c:forEach var="path" items="${sector.paths}"
									varStatus="status">
									<tr>
									<td>${sector.name }</td>
										<td>${path.name }</td>
										<td>${path.height }</td>
										<td>${path.cotation }</td>
										<td>${path.numberOfLengh}</td>
									</tr>
								</c:forEach>
							</c:forEach>
						</tbody>
					</table>
					<c:if test="${sessionScope.currentUser != null}">
						<div>
							<c:url var="sector" value="SectorAdd">
								<c:param name="id" value="${ infospot.getIdSpot() }" />
							</c:url>
							<a id="containerPLus" href="${ sector }">
								<p>
									<img src="images/plus.png" id="plus">
								</p>
								<p>Ajouter un secteur</p>
							</a>
						</div>
					</c:if>
				</div>

			</div>
		</div>
		<p>
			<c:if test="${sessionScope.currentUser != null}">
				<div>
					<form class="form-inline" method="post" action="SpotDetail">
						<textarea class="comment" cols="80" rows="4" name="comment">
  					</textarea>
						<input type="hidden" name="id" value="${ infospot.getIdSpot() }" />
						<button class="btn btn-secondary m-3" type="submit">Commenter</button>
					</form>
				</div>
			</c:if>
		</p>
		<p>
		<h5>Commentaires:</h5>
		<div class="bg-light border border-light">
			<c:forEach var="comment" items="${infospot.comments}"
				varStatus="status">
				<form class="form-inline" method="get" action="CommentManagement">
					<p class="m-2">
						 <c:out
								value="${comment.getUser().getLogin() }" /> ( <fmt:formatDate
								type="date" value="${ comment.getPublicationDate() }" /> ) :
					
						<c:out value="${ comment.getComment() }" />
						<c:if test="${sessionScope.currentUser.role.code == 2}">

							<input type="hidden" name="idcomment"
								value="${ comment.idComment}" />
							<button class="btn btn-secondary m-3" type="submit">Modifier/Supprimer</button>
						</c:if>
					</p>
				</form>
			</c:forEach>
		</div>
		</p>
	</div>
	</div>
</body>
</html>