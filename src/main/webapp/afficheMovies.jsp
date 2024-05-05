<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Modals.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Affichage des films</title>
<!-- Ajoutez le lien vers Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Liste des films</h1>



		<div class="row">
			<c:forEach var="film" items="${filmlist}">
				<div class="col-md-4">
					<div class="card mb-3">
						<img src="${film.getCover()}" class="card-img-top"
							alt="Image de couverture">
						<div class="card-body">
							<h5 class="card-title">${film.getTitle()}</h5>
							<p class="card-text">${film.getTitle()}</p>
							<p class="card-text">
								<strong>Date de sortie:</strong> ${film.getTitle()}
							</p>
							<p class="card-text">
								<strong>Durée:</strong> ${film.getTitle()} minutes
							</p>
							<p class="card-text">
								<strong>Genre:</strong> ${film.getTitle()}
							</p>
							<p class="card-text">
								<strong>Réalisateur:</strong> ${film.getTitle()}
							</p>
							<form action="affcihermovies" method="post">
								<input type="hidden" name="filmId" value="${film.getFilmId()}">
								<button type="submit" class="btn btn-danger">Supprimer</button>
							</form>
							<form action="update.jsp" method="post">
								<input type="hidden" name="filmId" value="${film.getFilmId()}">
								<button type="submit" class="btn btn-primary">Update</button>
							</form>
						</div>
					</div>
				</div>
		</div>
		</c:forEach>
		<p>Aucun film trouvé.</p>

	</div>

	<!-- Ajoutez le lien vers jQuery et Bootstrap JS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
