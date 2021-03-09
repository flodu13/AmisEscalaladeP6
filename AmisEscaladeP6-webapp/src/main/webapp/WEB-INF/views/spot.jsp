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
<title>spot</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="listSpot container">
		<p>Site d'escalades disponible sur notre site :</p>
		<div class="row">

			<c:forEach var="spot" items="${spots}" varStatus="status">
				<div class="col-6">
					<div class="card" style="width: 18rem;">
						<img src="images/<c:out value="${spot.name}"/>.png" class="card-img-top" alt="...">
						<div class="card-body">
							<c:url var="detailspot" value="SpotDetail">
								<c:param name="id" value="${ spot.idSpot }" />
							</c:url>
							<h5 class="card-title">${spot.name }</h5>
							<p class="card-text">${spot.address.region }</p>
							<a href="${ detailspot }" class="btn btn-primary">Voir
								détails</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
</body>
</html>