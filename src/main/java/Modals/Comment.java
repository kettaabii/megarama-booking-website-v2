package Modals;

public class Comment {
	private int id;
    private int movie_id;
    private int user_id;
    private String description;
    private int rating;
    
	public Comment(int movie_id, int user_id, String description, int rating) {
		super();
		this.movie_id = movie_id;
		this.user_id = user_id;
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

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
