<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>Research</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<form method="post" action="Research">
			<div class="row mb-3">
		
				<div class="col">
					<select id="region" name="region" class="form-control">
						<option value="">Choisissez la région</option>
						<option value="NOUVELLE-AQUITAINE">Nouvelle-Aquitaine</option>
						<option value="PACA">PACA</option>
						<option value="AUVERGNE-RHONE-ALPES">Auvergne-Rhône-Alpes</option>
						<option value="etc..">etc...</option>
					</select>
				</div>
				<div class="col">
					<select id="difficult" name="difficult" class="form-control">
						<option value="">Choisissez la difficulté</option>
						<option value="1a">1a</option>
						<option value="1b">1b</option>
						<option value="1c">1c</option>
						<option value="2a">2a</option>
						<option value="etc...">etc...</option>
					</select>
				</div>
			<div class="col">
					<input type="text" class="form-control" placeholder="name"
						id="name" name="name">
				</div>
			</div>
			
			<button class="btn btn-secondary" type="submit">Rechercher</button>

		</form>
	</div>

	<div class="listSpot">
		<p>Résultats</p>
		<ul class="flex spots" >
			<c:forEach var="spot" items="${spotsfind}" varStatus="status">

				<c:url var="detailspot" value="SpotDetail">
					<c:param name="id" value="${ spot.idSpot }" />
				</c:url>
				<li class="spot"><a href="${ detailspot }">${ spot.name }</a>
					<a class="img-container" href="${ detailspot }"> 
					<img src="images/<c:out value="${spot.name}"/>.png" alt="..."/>
				</a></li>
			</c:forEach>

		</ul>
	</div>
</body>
</html>