
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Modals.Movie" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
    <meta charset="UTF-8">
    <title>Watch Later Movies</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
        }
        .movie {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 20px auto;
            max-width: 600px;
        }
        .movie h2 {
            color: #333;
            margin-top: 0;
        }
        .movie p {
            color: #666;
            margin: 5px 0;
        }
    </style>
<head>
<meta charset="ISO-8859-1">
<title>Watch Later Movies</title>
</head>
<body>
    <h1>Watch Later Movies</h1>
    <%
    List<Movie> watchLaterMovies = (List<Movie>) session.getAttribute("watchLaterMovies");
    if (watchLaterMovies != null && !watchLaterMovies.isEmpty()) {
        for (Movie movie : watchLaterMovies) {
    %>
    <div class="movie">
        <h2><%= movie.getTitle() %></h2>
        <p>Director: <%= movie.getDirector() %></p>
        <p>Release Date: <%= new SimpleDateFormat("dd/MM/yyyy").format(movie.getReleaseDate()) %></p>
        <p>Description: <%= movie.getDescription() %></p>
        
        <form action="watchelaterServlet" method="post">
            <input type="hidden" name="filmId" value="<%= movie.getFilmId() %>">
            <input type="hidden" name="title" value="<%= movie.getTitle() %>">
            <input type="hidden" name="description" value="<%= movie.getDescription() %>">
            
            <input type="submit" value="Watch Later">
        </form>
    </div>
    <% 
        }
    } else {
    %>
    <p style="text-align: center;">No movies added to watch later list.</p>
    <% 
    }
    %>
</body>
</html>