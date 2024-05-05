<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/04/2024
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css"
	rel="stylesheet" />
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='https://unicons.iconscout.com/release/v3.0.6/css/line.css'>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
body {
	font-family: Arial, sans-serif;
	background-color: black;
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
<title>admiiin</title>
</head>
<body>


	<nav
		class="fixed top-0 z-50 w-full bg-white border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700">
		<div class="px-3 py-3 lg:px-5 lg:pl-3">
			<div class="flex items-center justify-between">
				<div class="flex items-center justify-start rtl:justify-end">
					<img class="navbar-brand me-auto" style="width: 130px;"
						src="https://i.ibb.co/vVjW8k7/megarama-logo.png">
					<div class="offcanvas offcanvas-end" tabindex="-1"
						id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
						<div class="offcanvas-header">
							<h5 class="offcanvas-title" id="offcanvasNavbarLabel">WELCOME
								TO YOUR CINEMA</h5>
						</div>
					</div>
					<button data-drawer-target="logo-sidebar"
						data-drawer-toggle="logo-sidebar" aria-controls="logo-sidebar"
						type="button"
						class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
						<span class="sr-only">Open sidebar</span>
						<svg class="w-6 h-6" aria-hidden="true" fill="currentColor"
							viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
               <path clip-rule="evenodd" fill-rule="evenodd"
								d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"></path>
            </svg>
					</button>

				</div>
				<div class="flex items-center">
					<div class="flex items-center ms-3">
						<div>
							<button type="button"
								class="flex text-sm bg-gray-800 rounded-full focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600"
								aria-expanded="false" data-dropdown-toggle="dropdown-user">
								<span class="sr-only">Open user menu</span> <img src="admin.png"
									class="star-img" alt="star" style="width: 20px;">
							</button>
						</div>
						<div
							class="z-50 hidden my-4 text-base list-none bg-white divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600"
							id="dropdown-user">
							<div class="px-4 py-3" role="none">
								<p class="text-sm text-gray-900 dark:text-white" role="none">
									admin</p>
								<p
									class="text-sm font-medium text-gray-900 truncate dark:text-gray-300"
									role="none">admin123@gmail.com</p>
							</div>
							<ul class="py-1" role="none">
								<li><a href="#"
									class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
									role="menuitem">Dashboard</a></li>
								<li><a href="#"
									class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
									role="menuitem">Settings</a></li>
								<li><a href="#"
									class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
									role="menuitem">Earnings</a></li>
								<li><a href="login.jsp"
									class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
									role="menuitem">Sign out</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<aside id="logo-sidebar"
		class="fixed top-0 left-0 z-40 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-800 dark:border-gray-700"
		aria-label="Sidebar">
		<div
			class="h-full px-3 pb-4 overflow-y-auto bg-white dark:bg-gray-800">
			<div class="search position-relative text-center px-4 py-3 mt-2">
				<h1></h1>
				<form action="MovieServletsearch" method="get">
					<input type="text" id="title" name="title"
						placeholder="Search Movies by Title">

				</form>

			</div>
			<ul class="space-y-2 font-medium">
				<li><a href="#"
					class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
						<svg
							class="w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
							fill="currentColor" viewBox="0 0 22 21">
                  <path
								d="M16.975 11H10V4.025a1 1 0 0 0-1.066-.998 8.5 8.5 0 1 0 9.039 9.039.999.999 0 0 0-1-1.066h.002Z" />
                  <path
								d="M12.5 0c-.157 0-.311.01-.565.027A1 1 0 0 0 11 1.02V10h8.975a1 1 0 0 0 1-.935c.013-.188.028-.374.028-.565A8.51 8.51 0 0 0 12.5 0Z" />
               </svg> <span class="ms-3">Dashboard</span>
				</a></li>
				<li><a href="affcihermovies"
					class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
						<svg
							class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
							fill="currentColor" viewBox="0 0 18 18">
                  <path
								d="M6.143 0H1.857A1.857 1.857 0 0 0 0 1.857v4.286C0 7.169.831 8 1.857 8h4.286A1.857 1.857 0 0 0 8 6.143V1.857A1.857 1.857 0 0 0 6.143 0Zm10 0h-4.286A1.857 1.857 0 0 0 10 1.857v4.286C10 7.169 10.831 8 11.857 8h4.286A1.857 1.857 0 0 0 18 6.143V1.857A1.857 1.857 0 0 0 16.143 0Zm-10 10H1.857A1.857 1.857 0 0 0 0 11.857v4.286C0 17.169.831 18 1.857 18h4.286A1.857 1.857 0 0 0 8 16.143v-4.286A1.857 1.857 0 0 0 6.143 10Zm10 0h-4.286A1.857 1.857 0 0 0 10 11.857v4.286c0 1.026.831 1.857 1.857 1.857h4.286A1.857 1.857 0 0 0 18 16.143v-4.286A1.857 1.857 0 0 0 16.143 10Z" />
               </svg> <span class="flex-1 ms-3 whitespace-nowrap">listes
							films</span>

				</a></li>
				<li><a href="lisetesusersservlets"
					class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
						<svg
							class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
							fill="currentColor" viewBox="0 0 20 20">
                  <path
								d="m17.418 3.623-.018-.008a6.713 6.713 0 0 0-2.4-.569V2h1a1 1 0 1 0 0-2h-2a1 1 0 0 0-1 1v2H9.89A6.977 6.977 0 0 1 12 8v5h-2V8A5 5 0 1 0 0 8v6a1 1 0 0 0 1 1h8v4a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-4h6a1 1 0 0 0 1-1V8a5 5 0 0 0-2.582-4.377ZM6 12H4a1 1 0 0 1 0-2h2a1 1 0 0 1 0 2Z" />
               </svg> <span class="flex-1 ms-3 whitespace-nowrap">listes
							Users</span> <span
						class="inline-flex items-center justify-center w-3 h-3 p-3 ms-3 text-sm font-medium text-blue-800 bg-blue-100 rounded-full dark:bg-blue-900 dark:text-blue-300">3</span>
				</a></li>
				<li><a href="listreservationsservlet"
					class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
						<svg
							class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
							fill="currentColor" viewBox="0 0 20 18">
                  <path
								d="M14 2a3.963 3.963 0 0 0-1.4.267 6.439 6.439 0 0 1-1.331 6.638A4 4 0 1 0 14 2Zm1 9h-1.264A6.957 6.957 0 0 1 15 15v2a2.97 2.97 0 0 1-.184 1H19a1 1 0 0 0 1-1v-1a5.006 5.006 0 0 0-5-5ZM6.5 9a4.5 4.5 0 1 0 0-9 4.5 4.5 0 0 0 0 9ZM8 10H5a5.006 5.006 0 0 0-5 5v2a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-2a5.006 5.006 0 0 0-5-5Z" />
               </svg> <span class="flex-1 ms-3 whitespace-nowrap">listes
							reservations</span>
				</a></li>
				<li><a href="affcihermovies"
					class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
						<svg
							class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg"
							fill="currentColor" viewBox="0 0 18 20">
                  <path
								d="M17 5.923A1 1 0 0 0 16 5h-3V4a4 4 0 1 0-8 0v1H2a1 1 0 0 0-1 .923L.086 17.846A2 2 0 0 0 2.08 20h13.84a2 2 0 0 0 1.994-2.153L17 5.923ZM7 9a1 1 0 0 1-2 0V7h2v2Zm0-5a2 2 0 1 1 4 0v1H7V4Zm6 5a1 1 0 1 1-2 0V7h2v2Z" />
               </svg> <span class="flex-1 ms-3 whitespace-nowrap">gestion
							films</span>
				</a></li>
				<li><a href="login.jsp"
					class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
						<svg
							class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
							viewBox="0 0 18 16">
                  <path stroke="currentColor" stroke-linecap="round"
								stroke-linejoin="round" stroke-width="2"
								d="M1 8h11m0 0L8 4m4 4-4 4m4-11h3a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-3" />
               </svg> <span class="flex-1 ms-3 whitespace-nowrap">log
							out</span>
				</a></li>

			</ul>
		</div>
	</aside>
	<BR>
	<BR>
	<BR>
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
		<input type="text" id="MegaCover" name="MegaCover" required> <input
			type="submit" value="Add Movie">
	</form>


	<script src="../path/to/flowbite/dist/flowbite.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script>
	<script
		src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.jshttps://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
	<script src="script.js"></script>


</body>
</html>
