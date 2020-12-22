package sOLID_Principle_S;

public class Book implements BookHandler {

	private BookPersistance bookPersistence;
	private int numOfPages;
	private String authorName;

	public Book(String authorName, int numOfPages) {
		this.authorName = authorName;
		this.numOfPages = numOfPages;
		this.bookPersistence = new BookPersistance();
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public void save() {
		this.bookPersistence.save(this);
	}

	@Override
	public String toString() {
		return authorName + " - " + numOfPages;
	}
}

