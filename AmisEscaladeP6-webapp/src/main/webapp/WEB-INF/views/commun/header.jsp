

<nav class="navbar navbar-expand-md bg-light navbar-light fixed-top ">
	<img class="logo" src="images/logo.png" height="autox" width="150px">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav mr-auto">
			<c:if test="${sessionScope.currentUser == null}">
				<li class="nav-item"><a class="navbar-brand " href="Connexion">Connexion</a>
				</li>
			</c:if>
			<c:if test="${sessionScope.currentUser == null}">
				<li class="nav-item"><a class="navbar-brand" href="Inscription">S'inscrire</a>
				</li>
			</c:if>
			<li class="nav-item"><a class="navbar-brand" href="Accueil">Accueil</a>
			</li>
			<li class="nav-item"><a class="navbar-brand" href="Spots">Sites
					d'escalade</a></li>
			<c:if test="${sessionScope.currentUser != null}">
				<li class="nav-item"><a class="navbar-brand" href="Topos">Topos</a>
				</li>
			</c:if>
			<c:if test="${sessionScope.currentUser != null}">
				<li class="nav-item"><a class="navbar-brand" href="Account">Mon
						compte</a></li>
			</c:if>
			<c:if test="${sessionScope.currentUser != null}">
				<li class="nav-item"><a class="navbar-brand" href="SpotAdd">Ajouter
						un site</a></li>
			</c:if>
			<li class="nav-item"><a href="Research"><img
					src="images/loupe.png"></a></li>
		</ul>
	</div>

</nav>
