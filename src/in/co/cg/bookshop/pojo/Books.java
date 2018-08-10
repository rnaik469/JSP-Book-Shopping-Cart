package in.co.cg.bookshop.pojo;

/**
 * @author rohit naik
 *
 */
public class Books {
	private String bookName;
	private String authorName;
	private String bookDesc;
	private String bookImg;
	private int bookPrice;
	private int bookId;
	private int bookcount;

	public String getBookName() {
		return bookName;
	}

	public Books() {

	}

	/**
	 * @param bookName
	 * @param authorName
	 * @param bookDesc
	 * @param bookId
	 * @param bookPrice
	 * @param bookcount
	 * @param bookImg
	 */
	public Books(String bookName, String authorName, String bookDesc, int bookId, int bookPrice, int bookcount,
			String bookImg) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookDesc = bookDesc;
		this.bookImg = bookImg;
		this.bookPrice = bookPrice;
		this.bookId = bookId;
		this.bookcount = bookcount;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public int getBookId() {
		return bookId;
	}

	public int getBookcount() {
		return bookcount;
	}

	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	@Override
	public String toString() {
		return "Books [bookName=" + bookName + ", authorName=" + authorName + ", bookDesc=" + bookDesc + ", bookPrice="
				+ bookPrice + ", bookId=" + bookId + "]";
	}

}
