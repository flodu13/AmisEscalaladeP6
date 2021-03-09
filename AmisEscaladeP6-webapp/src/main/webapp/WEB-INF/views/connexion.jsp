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
<title>Connexion</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<label>Vous pouvez vous connecter via ce formulaire (ou pour
			créer un compte cliquer <a href="Inscription">ici</a>)
		</label>
		<form class="form-inline" method="post" action="Connexion">
			<div class="form-group">
				<label class="mr-2" for="prenom">login</label> <input type="text"
					id="login" name="login">
			</div>
			<div class="form-group ml-3">
				<label class="mr-2" for="mail">mot de passe</label> <input
					type="password" id="password" name="password">
			</div>
					<div class="formulaire">
			<button class="btn btn-secondary" type="submit">Connexion</button>
		</div>
		</form>
	</div>

</body>
</html>