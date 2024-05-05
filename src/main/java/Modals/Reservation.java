package Modals;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity

@Table(name = "reservation")
public class Reservation {
    @Id private int reservationId;
    private String viewer;
    private String filmTitle;
    private Date reservationDate;
    private int price;
    private String seat;

    // Constructor
    public Reservation(int reservationId, String viewer, String filmTitle, Date reservationDate, int price, String seat) {
        this.reservationId = reservationId;
        this.viewer = viewer;
        this.filmTitle = filmTitle;
        this.reservationDate = reservationDate;
        this.price = price;
        this.seat = seat;
    }

    public Reservation(String viewer, String filmTitle, Date reservationDate, int price, String seat) {
        this.viewer = viewer;
        this.filmTitle = filmTitle;
        this.reservationDate = reservationDate;
        this.price = price;
        this.seat = seat;
    }

    public Reservation() {

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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    // Optional toString method for debugging purposes
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", viewer='" + viewer + '\'' +
                ", filmTitle='" + filmTitle + '\'' +

                ", price=" + price +
                ", seat=" + seat +
                '}';
    }
}
