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
<title>accueil</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>

	<c:if test="${sessionScope.currentUser == null}">
	<p class="text-center">
	Bonjour ! 
	</p>
	</c:if>
	<c:if test="${sessionScope.currentUser != null}">
	<p class="text-center">
	Vous êtes connecté ! 
	</p>
	</c:if>
	<p class="text-center">
	Bienvenu sur le site "les amis de l'escalade".	
	Ce site est un site communautaire, si vous souhaitez partager des spots, n'hesitez pas à vous inscrire !
	</p>
	<p class="text-center">
	<img src="images/accueil.png">
	</p>	
	<p class="text-center">
	Tous nos Topos sont accessibles uniquement après inscription.	
	</p>
	
</body>
</html>