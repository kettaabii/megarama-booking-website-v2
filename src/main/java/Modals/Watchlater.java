package Modals;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Watchlater {
   @Id
   private int idfav;

    private String viewer;
    private String filmTitle;
    private String genre;
    private String Cover;
    public Watchlater( String viewer, String filmTitle, String genre,String Cover) {

        this.viewer = viewer;
        this.filmTitle = filmTitle;
        this.genre = genre;
        this.Cover = Cover;
    }
    public Watchlater() {}


    public String getCover() {
        return Cover;
    }

    public void setCover(String cover) {
        Cover = cover;
    }

    public int getIdfav() {
        return idfav;
    }

    public void setIdfav(int idfav) {
        this.idfav = idfav;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
}
