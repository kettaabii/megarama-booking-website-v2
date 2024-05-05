<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un film</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Modifier un film</h1>
		<form action="updateservlet" method="post">
			<input type="number" name="filmId" value="${param.filmId}">
			<div class="form-group">
				<label for="title">Titre:</label> <input type="text"
					class="form-control" id="title" name="title" value="${param.title}">
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea class="form-control" id="description" name="description">${movie.description}</textarea>
			</div>
			<div class="form-group">
				<label for="releaseDate">Date de sortie:</label> <input type="date"
					class="form-control" id="releaseDate" name="releaseDate"
					value="${movie.releaseDate}">
			</div>
			<div class="form-group">
				<label for="duration">Durée:</label> <input type="number"
					class="form-control" id="duration" name="duration"
					value="${movie.duration}">
			</div>
			<div class="form-group">
				<label for="genre">Genre:</label> <input type="text"
					class="form-control" id="genre" name="genre" value="${movie.genre}">
			</div>
			<div class="form-group">
				<label for="director">Réalisateur:</label> <input type="text"
					class="form-control" id="director" name="director"
					value="${movie.director}">
			</div>
			<div class="form-group">
				<label for="cover">Image de couverture:</label> <input type="text"
					class="form-control" id="cover" name="cover" value="${movie.cover}">
			</div>
			<div class="form-group">
				<label for="MegaCover">Image de couverture:</label> <input
					type="text" class="form-control" id="MegaCover" name="cover"
					value="${movie.MegaCover()}">
			</div>
			<button type="submit" class="btn btn-primary">Enregistrer</button>
		</form>
	</div>
</body>
</html>
