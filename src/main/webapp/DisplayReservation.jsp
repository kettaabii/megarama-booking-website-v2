<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modals.Reservation" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Affichage des films</title>
    <!-- Ajoutez le lien vers Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Liste des reservations</h1>
        
        <%-- Vérifiez si la liste des films existe dans la requête --%>
        <% if (request.getAttribute("reservations") != null) { %>
            <%-- Obtenez la liste des films depuis la requête --%>
            <% List<Reservation> reservations = (List<Reservation>)request.getAttribute("reservations"); %>
            
            <div class="row">
                <%-- Parcourir la liste des films et afficher les détails --%>
                <% for (Reservation reservation : reservations) { %>
                    <div class="col-md-4">
                        <div class="card mb-3">
                           
                            <div class="card-body">
                                <h5 class="card-title"><%= reservation.getReservationId() %></h5>
                                <p class="card-text"> ID:<%=reservation.getViewer()%></p>
                                 <p class="card-text"><strong>Privilege</strong> <%= reservation.getFilmTitle() %></p>     
                                <p class="card-text"><strong>Privilege</strong> <%= reservation.getReservationDate() %></p>
                                <p class="card-text"><strong>Email</strong> <%= reservation.getPrice() %></p>
                                 <p class="card-text"><strong>Email</strong> <%= reservation.getSeat() %></p>
                                <%-- <form action="affcihermovies" method="post">
                                <input type="hidden" name="filmId" value="<%= movie.getFilmId() %>">
                                <button type="submit" class="btn btn-danger">Supprimer</button>
                                </form> --%>
                                
                            </div>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <p>Aucun film trouvé.</p>
        <% } %>
    </div>
    
    <!-- Ajoutez le lien vers jQuery et Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
