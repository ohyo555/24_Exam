
public class wiseSaying {

	private int id;
	private String wisesaying;
	private String author;
	private String time;

	public wiseSaying(int id, String wisesaying, String author, String time) {
		this.id = id;
		this.wisesaying = wisesaying;
		this.author = author;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWisesaying() {
		return wisesaying;
	}

	public void setWisesaying(String wisesaying) {
		this.wisesaying = wisesaying;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
