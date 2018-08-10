package in.co.cg.bookshop.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.co.cg.bookshop.pojo.Books;

/**
 * @author Rohit Naik
 *
 */
public class BookShopDao implements BookShopDAOI {

	static Map<Integer, Books> bookDetails = new HashMap<Integer, Books>(); // Stored books Map
	static Map<Integer, Books> bookMap = new HashMap<Integer, Books>(); // Map for books in the cart
	Books carBook = null;
	/*
	 * (non-Javadoc)
	 * 
	 * @see in.co.cg.bookshop.dao.BookShopDAOI#addBooks()
	 */

	// Adding book details in Books constructor
	static Books book1 = new Books("Object-Oriented Programming C++", "E Balagurusamy", "C++", 101, 348, 1, "c++.jpeg");
	static Books book2 = new Books("The C language", "Denis Ritche", "C", 102, 223, 1, "c.png");
	static Books book3 = new Books("Python", "Timothy", "Python crash course", 103, 450, 1, "exp_pyhton.jpg");
	static Books book4 = new Books("Core Python", "R. Rao", "Python++", 104, 535, 1, "core_python.jpg");

	// Static block add all available books in the map
	static {
		bookDetails.put(book1.getBookId(), book1);
		bookDetails.put(book2.getBookId(), book2);
		bookDetails.put(book3.getBookId(), book3);
		bookDetails.put(book4.getBookId(), book4);
	}

	
	/** (non-Javadoc)
	 * @see in.co.cg.bookshop.dao.BookShopDAOI#allBooks()
	 * @returns available Map  
	 */
	@Override
	public Map<Integer, Books> allBooks() {
		return bookDetails;
	}

	/*
	 * (non-Javadoc)
	 * @ Add book in the cart
	 * @see
	 * in.co.cg.bookshop.dao.BookShopDAOI#addBookCart(in.co.cg.bookshop.pojo.Books)
	 */
	@Override
	public void addBookCart(Books books) {
		System.out.println(books + "obj");
		bookMap.put(books.getBookId(), books);

	}

	/*
	 * (non-Javadoc)
	 * @returns all books in the cart
	 * @see in.co.cg.bookshop.dao.BookShopDAOI#viewBookCart()
	 */
	@Override
	public Collection<Books> viewBookCart() {
		System.out.println(bookMap);
		return bookMap.values();
	}

	/*
	 * (non-Javadoc)
	 *  Remove books from the cart
	 * @see in.co.cg.bookshop.dao.BookShopDAOI#removeBookFromCart(int)
	 */
	@Override
	public void removeBookFromCart(int id) {
		bookMap.remove(id);
	}
}
