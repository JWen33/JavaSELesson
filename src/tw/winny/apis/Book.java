package tw.winny.apis;

public class Book {
	private String title;
	private String author;
	private String publisherYer;
	
	public Book(String title, String author, String publisherYear) {
		this.title = title;
		this.author = author;
		this.publisherYer = publisherYear;		
//		System.out.println("Book物件實體產出");
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getBookInfo() {
		return "[Title=" + title + ", Author=" + author + ", PublisherYear:" + publisherYer + "]";
	}
	
	public String toString() {
		return getBookInfo();
		
	}
}


