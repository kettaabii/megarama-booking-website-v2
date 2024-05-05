<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Modals.Movie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultats de la recherche</title>
</head>
<body>
	<h1>Résultats de la recherche</h1>

	<% if (request.getAttribute("movies") != null) { %>
	<% List<Movie> movies = (List<Movie>) request.getAttribute("movies"); %>

	<%-- Vérifier si des films ont été trouvés --%>
	<% if (!movies.isEmpty()) { %>
	<ul>
		<%-- Parcourir la liste des films et les afficher --%>
		<% for (Movie movie : movies) { %>
		<li>
			<%-- Afficher les détails du film --%> <strong>Titre:</strong> <%= movie.getTitle() %><br>
			<strong>Description:</strong> <%= movie.getDescription() %><br>
			<strong>Date de sortie:</strong> <%= movie.getReleaseDate() %><br>
			<strong>Durée:</strong> <%= movie.getDuration() %> minutes<br> <strong>Genre:</strong>
			<%= movie.getGenre() %><br> <strong>Réalisateur:</strong> <%= movie.getDirector() %><br>
			<img src="<%= movie.getCover() %>" alt="Cover Image">
		</li>
		<% } %>
	</ul>
	<% } else { %>
	<p>Aucun film trouvé avec ce titre.</p>
	<% } %>
	<% } else { %>
	<p>Aucun résultat à afficher.</p>
	<% } %>
</body>
</html>
