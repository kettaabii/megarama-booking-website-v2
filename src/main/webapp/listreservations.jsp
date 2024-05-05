<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01/05/2024
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html lang="en">
<head>


<title>cliaaan</title>
<style>
<%@
include
 
file
="
WEB-INF
/
Movie
.css
"%
>
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar nav-movie fixed-top navbar-expand-lg py-0"
		style="height: 50px;">
		<div class="container">
			<img class="navbar-brand me-auto" style="width: 40px"
				src="images/logo.png">
			<div class="offcanvas offcanvas-end" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasNavbarLabel">WELCOME
						TO YOUR CINEMA</h5>
					<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
						aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-center flex-grow-1 pe-3">
						<li class="nav-item active-menu"><a
							class="nav-link text-light mx-lg-2 mx-4"
							href="/Magerama_cinema_BM_war_exploded/display">ShowTimes</a></li>
						<li class="nav-item"><a
							class="nav-link text-light mx-lg-2 mx-4" href="#">Films</a></li>
						<li class="nav-item"><a
							class="nav-link text-light mx-lg-2 mx-4" href="#">Cinemas</a></li>
						<li class="nav-item"><a
							class="nav-link text-light mx-lg-2 mx-4" href="#">Promotions</a>
						</li>
						<li class="nav-item"><a
							class="nav-link text-light mx-lg-2 mx-4" href="#">Events</a></li>
					</ul>
				</div>

			</div>
			<div class="search">
				<form action="s" method="post">
					<li class="nav-link search-bar active rounded col-10"><input
						class="search col-10 text-light bg-slight border border-0 px-3 py-1 rounded"
						id="titleFilm" name="titleFilm" type="text"
						placeholder="Search for movie..."> <i type="submit"
						style="color: white;" class="bx bx-search-alt icon rounded"></i></li>
				</form>
			</div>
			<i class='bx bx-user bx-flip-horizontal icon rounded'
				style='color: white' data-bs-toggle="modal"
				data-bs-target="#exampleModal" type="button"></i>



			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content bg-dark text-light">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">User account</h5>
					<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!-- Ajoutez ici le contenu des coordonnées de l'utilisateur -->
					<p>Nom: ${login}</p>
					<p>Email: ${login}</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<a href="Logout" type="button" class="btn btn-warning">Log out</a>
					<a href="reserve-history" class="btn btn-danger text-light">Reservation<i
						class='bx bxs-coupon' style='color: #ffffff'></i></a>
				</div>
			</div>
		</div>
	</div>

	<img
		style="z-index: -1000; width: 1300px; height: 800px; position: absolute; top: 0; left: 0;"
		src="images/bg-GOT.jpg">
	<section class="home">
		<div style="position: absolute; top: 250px; left: 37px;"
			class="container rounded">
			<table style="width: 107%; background: rgba(12, 14, 18, 0.78)"
				class="table table-striped rounded">
				<thead style="padding: 10px">
					<tr>

						<th>Viewer</th>
						<th>FilmTitle</th>
						<th>ReservationDate</th>
						<th>Price</th>
						<th>Seat</th>


					</tr>
				</thead>
				<tbody style="padding: 10px">
					<c:forEach var="res" items="${Reservationlist}">
						<tr>

							<td>${res.getViewer()}</td>
							<td>${res.getFilmTitle()}</td>
							<td>${res.getReservationDate()}</td>
							<td>${res.getPrice()}</td>
							<td>${res.getSeat()}</td>


						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>



		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
		<!-- bootstrap js link -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>

