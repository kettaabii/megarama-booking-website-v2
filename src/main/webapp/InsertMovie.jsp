<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Movie</title>
</head>
<body>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 0 auto;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        p.success-message {
            color: #008000;
            margin-top: 10px;
        }
    </style>

<h2>Add Movie</h2>
<form action="InsertMovieServlet" method="post">
    <label>Title:</label><br>
    <input type="text" name="Title"><br><br>
    
    <label>Description:</label><br>
    <textarea name="Description"></textarea><br><br>
    
    <label>Duration (minutes):</label><br>
    <input type="number" name="Duration"><br><br>
    
    <label>Release Date</label><br>
    <input type="date" name="ReleaseDate"><br><br>
    
    
    <label>Genre:</label><br>
    <input type="text" name="Genre"><br><br>
    
    <label>Director:</label><br>
    <input type="text" name="Director"><br><br>
    
    <label>Cover Image URL:</label><br>
    <input type="text" name="Cover"><br><br>
    
    <input type="submit" value="Add Movie">
</form>


</body>
</html>
 --%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Movie</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

h2 {
	color: #333;
	text-align: center;
	margin-bottom: 30px;
	font-size: 36px;
}

form {
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	max-width: 600px;
	margin: 0 auto;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 10px;
}

input[type="text"], input[type="number"], textarea, input[type="date"],
	select {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
	font-size: 16px;
}

input[type="submit"] {
	background-color: #e50914;
	color: white;
	padding: 15px 30px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 18px;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #c10812;
}

.success-message {
	color: #008000;
	margin-top: 20px;
	text-align: center;
}

.icon {
	display: inline-block;
	vertical-align: middle;
	margin-right: 10px;
}
</style>
</head>
<body>

	<h2>
		<i class="fas fa-film icon"></i>Add Movie
	</h2>
	<form action="InsertMovieServlet" method="post">
		<label for="Title">Title:</label> <input type="text" id="Title"
			name="Title" required> <label for="Description">Description:</label>
		<textarea id="Description" name="Description" rows="4" required></textarea>

		<label for="Duration">Duration (minutes):</label> <input type="number"
			id="Duration" name="Duration" required> <label
			for="ReleaseDate">Release Date:</label> <input type="date"
			id="ReleaseDate" name="ReleaseDate" required> <label
			for="Genre">Genre:</label> <select id="Genre" name="Genre" required>
			<option value="" disabled selected>Select genre</option>
			<option value="Action">Action</option>
			<option value="Adventure">Adventure</option>
			<option value="Comedy">Comedy</option>
			<option value="Drama">Drama</option>
			<option value="Fantasy">Fantasy</option>
			<option value="Horror">Horror</option>
			<option value="Romance">Romance</option>
			<option value="Science Fiction">Science Fiction</option>
			<option value="Thriller">Thriller</option>
			<!-- Add more genres as needed -->
		</select> <label for="Director">Director:</label> <input type="text"
			id="Director" name="Director" required> <label for="Cover">Cover
			Image URL:</label> <input type="text" id="Cover" name="Cover" required>
		<label for="MegaCover">Cover Image URL:</label> <input type="text"
			id="MegaCover" name="MegaCover" required> <input
			type="submit" value="Add Movie">
	</form>

</body>
</html>
