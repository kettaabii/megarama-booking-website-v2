package Modals;

public class Comment {
	public class Movie {
	    private int id;
	    private int filmId ;
	    private int userId;
	    private String description;
	    
		public Movie() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Movie(int filmId, int userId, String description) {
			super();
			this.filmId = filmId;
			this.userId = userId;
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getFilmId() {
			return filmId;
		}
		public void setFilmId(int filmId) {
			this.filmId = filmId;
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
	    
}
