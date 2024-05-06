package Modals;

public class Comment {
    private int idComment;
    private String comment;
    private String author;
    private int Rating;
    private int FilmId;

    public Comment(int idComment, String comment, String author, int filmId, int rating) {
        this.idComment = idComment;
        this.comment = comment;
        this.author = author;
        this.FilmId = filmId;
        this.Rating = rating;
    }

    public Comment(String comment, String author, int rating, int filmId) {
        this.comment = comment;
        this.author = author;
        Rating = rating;
        FilmId = filmId;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getFilmId() {
        return FilmId;
    }

    public void setFilmId(int filmId) {
        FilmId = filmId;
    }
}
