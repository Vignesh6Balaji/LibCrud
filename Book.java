package Model;
public class Book {
	private String title;
	private int bid;
	private String author;
	private double price;
	private boolean isAvailable;
	
	public Book(String title, int bid, String author, double price, boolean isAvailable) {
		this.title = title;
		this.bid = bid;
		this.author = author;
		this.price = price;
		this.isAvailable=isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ",bid=" + bid + ", author=" + author + ", price=" + price + "]";
	}
	
}
