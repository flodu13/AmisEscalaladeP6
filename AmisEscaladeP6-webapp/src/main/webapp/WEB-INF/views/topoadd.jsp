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
<title>Ajouter un topo</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<label>Vous souhaitez mettre à disposition un nouveau topo :</label>
		<form method="post" action="TopoAdd">
			<div class="row mb-3">
				<div class="col">
					<input type="text" class="form-control"
						placeholder="Nom du topo(*)" id="name" name="name" required>
				</div>
				<div class="col">
					<select id="location" name="location" class="form-control">
						<option value="">Choisissez la région concernée" *</option>
						<optgroup label="location">
							<option>PACA</option>
							<option>NOUVELLE-AQUITAINE</option>
							<option>Etc...</option>
						</optgroup>
					</select>
				</div>
			</div>

			<div class="row mb-3">
				<label for="description">Descritpion du topo :</label>
				<div class="col">

					<textarea class="description" cols="55" rows="4" name="description">
  					</textarea>

				</div>
				<div class="col">
					<input type="checkbox" name="available" id="available" value="true" /> <label
						for id="available">topo disponible</label>
				</div>
			</div>

			<button class="btn btn-secondary" type="submit">Enregistrer</button>
		</form>
	</div>
</body>
</html>