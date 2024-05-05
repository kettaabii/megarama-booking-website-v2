
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>


    <title>cliaaan</title>
    <style><%@include file="WEB-INF/Movie.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"></head>
<body>
<!-- Navbar -->
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
<div id="slider">
    <figure>
        <c:forEach var="film" items="${filmlistslider}">
        <div class="image"><img style="width: 100%; height: 100vh;" src="${film.getMegaCover()}" alt="">
            <div class="example"  >
                <div class="description" style="display: flex;margin: 10px;">
                <img src="${film.getCover()}" class="backimg"/>
                <div style="margin:15px; display: flex; flex-direction: column; justify-content: space-between">
                    <div style="width: 350px">
                        <h3 style="color: white;">${film.getTitle()}</h3>
                        <p style="font-size: 13px; text-align: start;">${film.getDuration()} -<span> ${film.getReleaseDate()} -</span><span
                                style="font-weight: bold;">${film.getDirector()}</span></p>
                        <p style="font-size: 13px; text-align: start;"><span class="text-success">92% Match </span><span
                                class="border rounded px-1 mx-2">TV - MA</span><span style="font-weight: bold;"
                                                                                     class="border rounded px-1 mx-1 ">HD</span><span
                                style='color:#fdb000; background: rgba(0, 0, 0, 0.6);' class="rounded border px-2 mx-1">9.0 <i
                                class='bx bxs-star' style='color:#fdb000'></i></span></p>
                        <p style="font-size: 15px; text-align: start;">Genre : ${film.getGenre()}</p>
                        <p style="font-size: 14px; text-align: start;">${film.getDescription()}</p>
                    </div>

                    <div class="btns" style="display:flex ; justify-content: space-around;">
                    <button class="bte"><a style="color: white; text-decoration: none;" type="submit" href="BookMovie?id=${film.getFilmId()}" >Book Now</a></button>
                        <button>Details</button>

                    </div>
                </div>
            </div>


            </div>


        </div>



        </c:forEach>

    </figure>
</div>
<h2 style="color: white; margin: 1rem; padding: 10px 20px; background: background: linear-gradient(0deg, rgba(0,0,0,0) 0%, rgba(0,0,0,0.6) 20%, rgba(0,0,0,1) 50%, rgba(0,0,0,0.6) 80%, rgba(0,0,0,0) 100%);">Streaming Now :</h2>
<div class="grid-wrapper" style="display: flex; flex-wrap: wrap;
    width: 100%;
    height: 350px;
    position: relative;
    margin: 30px;">

<c:forEach var="film" items="${filmlist}">
        <div class="card">
            <img src="${film.getCover()}" class="card-img" alt="" />
            <div class="card-body">
                <h2 class="name">${film.getTitle()}</h2>
                <h6 class="des">${film.getGenre()}</h6>
                <button class="watchlist-btn"href="BookMovie?id=${film.getFilmId()}">add to watchlist</button>
            </div>
        </div>

</c:forEach>
    </div>
</div>








<script>
    function menuToggle() {
        const toggleMenu = document.querySelector(".menu");
        toggleMenu.classList.toggle("active");
    }
    let cardContainers = [...document.querySelectorAll(".card-container")];
    let preBtns = [...document.querySelectorAll(".pre-btn")];
    let nxtBtns = [...document.querySelectorAll(".nxt-btn")];

    cardContainers.forEach((item, i) => {
        let containerDimensions = item.getBoundingClientRect();
        let containerWidth = containerDimensions.width;

        nxtBtns[i].addEventListener("click", () => {
            item.scrollLeft += containerWidth - 200;
        });

        preBtns[i].addEventListener("click", () => {
            item.scrollLeft -= containerWidth + 200;
        });
    });

</script>
</body>
</html>
