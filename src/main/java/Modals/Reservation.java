package Modals;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private String viewer;
    private String filmTitle;
    private Date reservationDate;
    private int price;
    private int seat;

    // Constructor
    public Reservation(int reservationId, String viewer, String filmTitle, Date reservationDate, int price, int seat) {
        this.reservationId = reservationId;
        this.viewer = viewer;
        this.filmTitle = filmTitle;
        this.reservationDate = reservationDate;
        this.price = price;
        this.seat = seat;
    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    // Optional toString method for debugging purposes
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", viewer='" + viewer + '\'' +
                ", filmTitle='" + filmTitle + '\'' +
                ", reservationDate=" + reservationDate +
                ", price=" + price +
                ", seat=" + seat +
                '}';
    }
}
