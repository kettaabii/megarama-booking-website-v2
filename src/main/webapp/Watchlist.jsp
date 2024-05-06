<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06/05/2024
  Time: 02:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="WEB-INF/Movie.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>my watchlist</title>
</head>
<body>
<nav class="navbar nav-movie bg-dark fixed-top navbar-expand-lg py-0" style="height: 70px;">
    <div class="container">
        <img class="navbar-brand me-auto" style="width: 130px;" src="https://i.ibb.co/vVjW8k7/megarama-logo.png">
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
             aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">WELCOME TO YOUR CINEMA</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-center flex-grow-1 pe-3">
                    <li class="nav-item active-menu">
                        <a class="nav-link text-light mx-lg-2 mx-4" href="#">ShowTimes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light mx-lg-2 mx-4" href="#">Films</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light mx-lg-2 mx-4" href="#">Cinemas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light mx-lg-2 mx-4" href="#">Promotions</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-light mx-lg-2 mx-4" href="#">Events</a>
                    </li>
                </ul>
            </div>

        </div>

        <div class="login">
            <% if (session.getAttribute("username") == null){%>
            <a class="nav-link text-light mx-lg-2 mx-4" href="/Cinema_Megarama_war_exploded/login">
                login</a>
            <%} else {%>
            <div class="action">
                <div class="profile" onclick="menuToggle();">
                    <img src="<%=session.getAttribute("profile")%>" />
                </div>
                <div class="menu">
                    <h3><%=session.getAttribute("username")%><br /><span><%=session.getAttribute("email")%></span></h3>
                    <ul>
                        <li>
                            <img src="https://icon-library.com/images/reservation-icon-png/reservation-icon-png-10.jpg" /><a href="listreservationsservlet?viewer=<%=session.getAttribute("username")%>">My Reservations</a>
                        </li>
                        <li>
                            <img src="https://cdn-icons-png.freepik.com/512/5563/5563837.png" /><a href="#">My watchlist</a>
                        </li>
                        <li>
                            <img src="<%=session.getAttribute("profile")%>" /><a href="#">Profile Settings</a>
                        </li>
                        <li>
                            <img src="./assets/icons/log-out.png" /><a href="#">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
            <%}%>

        </div>
        <i class='bx bx-user bx-flip-horizontal icon rounded' style='color:white'></i>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<h2 style="color: white; margin: 1rem; padding: 10px 20px; background: background: linear-gradient(0deg, rgba(0,0,0,0) 0%, rgba(0,0,0,0.6) 20%, rgba(0,0,0,1) 50%, rgba(0,0,0,0.6) 80%, rgba(0,0,0,0) 100%);">Streaming Now :</h2>
<div class="grid-wrapper" style="display: flex; flex-wrap: wrap;
    width: 100%;
    height: 350px;
    position: relative;
    margin: 30px;">

    <c:forEach var="wishlist" items="${Userreservation}">

        <div class="card">
            <img src="${wishlist.getCover()}" class="card-img" alt="" />

            <div class="card-body">
                <h2 class="name">${wishlist.getTitle()}</h2>

                <h6 class="des">${wishlist.getGenre()}</h6>

            </div>
        </div>


</div>
</div>


<script>
    function menuToggle() {
        const toggleMenu = document.querySelector(".menu");
        toggleMenu.classList.toggle("active");
    }</script>

</body>
</html>
