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
<title>Ajouter un secteur</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<label>Vous souhaitez ajouter un secteur pour un spot, merci de
			renseigner le formulaire suivant (les champs marqués d'un * sont
			obligatoires)</label>
		<form method="post" action="SectorAdd">
			<div class="row mb-3">
				<div class="col">
					<input type="text" class="form-control"
						placeholder="Nom du secteur *" id="name" name="name" required>
				</div>
				<div class="col">
					<input type="text" class="form-control"
						placeholder="nombre de voies *" id="numberofpath" name="numberofpath"
						required>
				</div>
			</div>
			<input id="id" name="id" type="hidden" value="${infospot.idSpot}">
			<button class="btn btn-secondary" type="submit">Enregistrer le
				secteur</button>
		</form>
	</div>
</body>
</html>