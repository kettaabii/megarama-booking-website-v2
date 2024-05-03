<%@ page import="Modals.Movie" %>
<%@ page import="MYSQLIMP.MoviesDAOImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>


    <title>cliaaan</title>
    <style><%@include file="WEB-INF/bookstylz.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
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
            <a class="nav-link text-light mx-lg-2 mx-4" href="#">Events</a>
        </div>
        <i class='bx bx-user bx-flip-horizontal icon rounded' style='color:white'></i>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<div class="containerr">
    <%
        Movie movie = (Movie) request.getAttribute("Movie");%>
    <div >
        <a href="#"><img id="main_image" style="width: 100vw;" src="<%=movie.getMegaCover()%>" alt="Affiche du film beekeeper" title="Affiche de film"></a>
    </div>
    <div class="main_info text-light">
        <h1><%= movie.getTitle()%> </h1>
        <p class="annee"><%= movie.getReleaseDate()%></p>
        <p class="titre_film"><%= movie.getTitle()%></p>
        <p class="genre"><%= movie.getGenre()%><span><%= movie.getDuration()%></span></p>
        <p class="format"><%= movie.getDescription()%>

        <div class="more_info">

            <div class="sub_inf">
                <p class="mor_in">4K</p>
                <p class="mor_in">VF</p>
                <p class="mor_in"><%= movie.getGenre()%></p>
                <p class="mor_in"><span><%= movie.getDuration()%></span></p>
            </div>

            <div>
                <button id="main_btn">Watch trailer </button>
            </div>

        </div>
    </div>

    <div class="zone_reser">
        <div class="zone_left">

            <img src="https://i.ibb.co/xf38X82/scrn.png">
            <div class="zone">
                <div class="all-seats">
                    <input type="checkbox" name="tickets" id="s1" class="seatt" value="s1"/>
                    <label for="s1" class="seat booked"></label>
                </div>
            </div>

        </div>


        <div class="zone_right">

            <form action="confirm-reservation" method="POST">
                <p class="border rounded px-1 mx-1"style="font-size: 2rem;font-weight: bold;text-align: center ;text-decoration: #FFC312;"><%= movie.getTitle()%></p>
                <input type="hidden" name="title" value="<%= movie.getTitle()%>">
            <div class="prices">
                <div class="total">
                    <span> <span class="count" class="border rounded px-1 mx-1" style="font-size: 2rem;font-weight: bold;text-align: center ;text-decoration: #FFC312;">0</span> Tickets </span>
                    <input type="hidden" >
                    <div class="amount" class="border rounded px-1 mx-1"style="font-size: 2rem;font-weight: bold;text-align: center ;text-decoration: #FFC312;">0</div>
                    <input type="hidden" name="amount" class="price" value="">
                    <div id="seat-selected" class="border rounded px-1 mx-1"style="font-size: 2rem;font-weight: bold;text-align: center ;text-decoration: #FFC312;">0</div>
                    <input type="hidden" name="seat" class="selectseat" value="">
                    <div class="timings">
                        <div class="dates">
                            <input type="radio" name="date" id="d1" value="2024-05-11" checked />
                            <label for="d1" class="dates-item">
                                <div class="day">Sun</div>
                                <div class="date">11</div>
                            </label>
                            <input type="radio" id="d2" name="date" value="2024-05-12"/>
                            <label class="dates-item" for="d2">
                                <div class="day">Mon</div>
                                <div class="date">12</div>
                            </label>
                            <input type="radio" id="d3" name="date" value="2024-05-13"/>
                            <label class="dates-item" for="d3">
                                <div class="day">Tue</div>
                                <div class="date">13</div>
                            </label>
                            <input type="radio" id="d4" name="date" value="2024-05-14"/>
                            <label class="dates-item" for="d4">
                                <div class="day">Wed</div>
                                <div class="date">14</div>
                            </label>
                            <input type="radio" id="d5" name="date" value="2024-05-15"/>
                            <label class="dates-item" for="d5">
                                <div class="day">Thu</div>
                                <div class="date">15</div>
                            </label>
                            <input type="radio" id="d6" name="date" value="2024-05-16"/>
                            <label class="dates-item" for="d6">
                                <div class="day">Fri</div>
                                <div class="date">16</div>
                            </label>
                            <input type="radio" id="d7" name="date" value="2024-05-17"/>
                            <label class="dates-item" for="d7">
                                <div class="day">Sat</div>
                                <div class="date">17</div>
                            </label>
                        </div>
                        <div class="times">
                            <input type="radio" name="time" id="t1" checked />
                            <label for="t1" class="time">11:00</label>
                            <input type="radio" id="t2" name="time" />
                            <label for="t2" class="time"> 14:30 </label>
                            <input type="radio" id="t3" name="time" />
                            <label for="t3" class="time"> 18:00 </label>
                            <input type="radio" id="t4" name="time" />
                            <label for="t4" class="time"> 21:30 </label>
                        </div>
                    </div>
                </div>
            </div>
                <button id="btn" type="submit">Confirm your ticket reservation</button>
            </form>

        </div>



    </div>
</div>






<script>
    let seats = document.querySelector(".all-seats");
    for (var i = 0; i < 59; i++) {
        let randint = Math.floor(Math.random() * 2);
        let booked = randint === 1 ? "booked" : "";
        seats.insertAdjacentHTML(
            "beforeend",
            '<input type="checkbox" class="seatt" value="s'+(i + 2) +'" name="tickets" id="s' +
            (i + 2) +
            '" /><label for="s' +
            (i + 2) +
            '" class="seat ' +
            booked +
            '"></label>'
        );
    }

    let tickets = seats.querySelectorAll("input");
    tickets.forEach((ticket) => {
        ticket.addEventListener("change", () => {
            let amount = document.querySelector(".amount").innerHTML;
            let count = document.querySelector(".count").innerHTML;
            const valueAmount = document.querySelector(".price")
            amount = Number(amount);
            count = Number(count);

            if (ticket.checked) {
                count += 1;
                amount += 200;
            } else {
                count -= 1;
                amount -= 200;
            }
            document.querySelector(".amount").innerHTML = amount +'<p>Dhs</p>' ;
            document.querySelector(".count").innerHTML = count;
            valueAmount.value = amount;
        });
    });
    document.addEventListener('DOMContentLoaded', function () {
        const seats = document.querySelectorAll('.seatt');
        const selectedSeat = document.getElementById('seat-selected');
        const valueSeat = document.querySelector(".selectseat")
        seats.forEach(function (checkbox) {
            checkbox.addEventListener('change', function () {
                let selectedOffersArray = [];
                seats.forEach(function (cb) {
                    if (cb.checked) {
                        selectedOffersArray.push(cb.value);
                    }
                });
                selectedSeat.textContent = selectedOffersArray.join(' - ');
                valueSeat.value = selectedOffersArray.join(' - ');
            });
        });
    });
</script>

</body>
</html>