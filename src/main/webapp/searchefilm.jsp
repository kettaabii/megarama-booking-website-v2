<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Movies</title>
</head>
<body>
    <h1>Search Movies by Title</h1>
    <form action="MovieServletsearch" method="get">
        <label for="title">Enter Movie Title:</label>
        <input type="text" id="title" name="title">
        <button type="submit">Search</button>
    </form>
</body>
</html>
