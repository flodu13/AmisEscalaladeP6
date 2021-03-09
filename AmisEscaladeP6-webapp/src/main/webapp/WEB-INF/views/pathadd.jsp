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
		<label>Vous souhaitez ajouter un voie pour un secteurt, merci
			de renseigner le formulaire suivant (les champs marqués d'un * sont
			obligatoires)</label>
		<form method="post" action="PathAdd">
			<div class="row mb-3">
				<div class="col">
					<input type="text" class="form-control"
						placeholder="Nom de la voie *" id="name" name="name" required>
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="hauteur *"
						id="height" name="height" required>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<input type="text" class="form-control" placeholder="cotation *"
						id="name" name="cotation" required>
				</div>
				<div class="col">
					<input type="text" class="form-control"
						placeholder="nombre de longueurs *" id="numberoflenght"
						name="numberoflenght" required>
				</div>
			</div>
			<div class="row mb-3">

				<div class="col">
					<input type="text" class="form-control"
						placeholder="nombre de spits *" id="numberofpoints"
						name="numberofpoints" required>
				</div>
			
			<div class="col">
				<input id="idsector" name="idsector" type="hidden" value="${infosector.idSector}">
				<button class="btn btn-secondary" type="submit">Enregistrer
					la voie</button>
			</div>
			
			</div>
		</form>
	</div>
</body>
</html>