package Modals;

public class Comment {
	private int id;
    private int movieId;
    private int userId;
    private String description;
    private int rating;
    
	public Comment(int movieId, int userId, String description, int rating) {
		super();
		this.movieId = movieId;
		this.userId = userId;
		this.description = description;
		this.rating = rating;
	}
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
    
    
		
}
