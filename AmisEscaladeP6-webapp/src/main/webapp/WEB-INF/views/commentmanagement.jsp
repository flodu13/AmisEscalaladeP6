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
<title>commentaire</title>
</head>
<body>
	<header>
		<%@include file="commun/header.jsp"%>
	</header>
	<div class="formulaire">
		<form method="post" action="CommentManagement">
			<input type="hidden" name="idComment" value="${ comment.idComment }" />
			<textarea class="comment" cols="80" rows="4" name="comment" ><c:out value ="${comment.comment }"></c:out>
  			</textarea>	
			<p>
				<input type="checkbox" name="delete" id="delete" value="true" /> <label
					for id="delete">supprimer le commentaire</label>
			</p>

			<p>
				<button class="btn btn-secondary" type="submit">mettre à
					jour</button>
			</p>
		</form>
	</div>
</body>
</html>