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
<title>Inscription</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<label>Veuillez remplir le formulaire d'inscription afin de
			vous inscrire</label>
		<form method="post" action="Inscription">
			<div class="row mb-3">

				<div class="col">
					<label for="name" class="form-label">Nom</label> 
					<input type="text"
						class="form-control" id="name" name="name" required>
				</div>
				<div class="col">
					<label for="lastname" class="form-label">Prénom</label> 
					<input
						type="text" class="form-control" id="lastname" name="lastname"
						required>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label for="login" class="form-label">Login</label> 
					<input
						type="text" class="form-control" id="login" name="login" required>
				</div>
				<div class="col">
					<label for="email" class="form-label">Email</label> 
					<input
						type="text" class="form-control" id="email" name="email" required>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col">
					<label for="password" class="form-label">Password</label> 
					<input
						type="password" class="form-control" id="password" name="password"
						required>
				</div>
				<div class="col">
					<label for="confirmpassword" class="form-label">Confirmation mot de passe</label>
					<input type="password" class="form-control" id="confirmpassword"
						name="confirmpassword" required>
				</div>
			</div>

			<button class="btn btn-secondary" type="submit">Envoyer</button>
	</div>
	</form>
	</div>
</body>
</html>