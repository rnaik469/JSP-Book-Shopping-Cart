package in.cg.bookshop.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.co.cg.bookshop.dao.BookShopDAOI;
import in.co.cg.bookshop.dao.BookShopDao;
import in.co.cg.bookshop.pojo.Books;

/**
 * @author rohit naik
 *
 */
public class BookShopService implements BookShopServiceI {
	BookShopDAOI bookShopDao = new BookShopDao();// Instantiating BookShopDAO
	static int count = 0;

	/**
	 * (non-Javadoc)
	 * 
	 * @see in.cg.bookshop.service.BookShopServiceI#allBooks() returns all available
	 *      books
	 */
	public Collection<Books> allBooks() {
		return bookShopDao.allBooks().values();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see in.cg.bookshop.service.BookShopServiceI#addBookCart(int) Add book to
	 *      cart returns book count
	 */
	@Override
	public int addBookCart(int id) {
		boolean check = true;
		count++;

		for (Books books : viewBookCart()) {
			if (books.getBookId() == id) {
				books.setBookcount(books.getBookcount() + 1);
				check = false;
				break;
			}

		}
		if (check) {
			bookShopDao.addBookCart(bookShopDao.allBooks().get(id));
		}
		return count;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see in.cg.bookshop.service.BookShopServiceI#viewBookCart() returns total
	 *      books count in the cart
	 */
	@Override
	public Collection<Books> viewBookCart() {
		return bookShopDao.viewBookCart();
	}

	/**
	 * (non-Javadoc) Remove Books From cart
	 * 
	 * @returns total count
	 * @see in.cg.bookshop.service.BookShopServiceI#removeBookFromCart(int)
	 */
	@Override
	public int removeBookFromCart(int id) {
		count--;

		for (Books books : viewBookCart()) {
			if (books.getBookId() == id) {
				if (books.getBookcount() == 1) {
					bookShopDao.removeBookFromCart(id);
					break;
				}
				if (books.getBookcount() > 1) {
					books.setBookcount(books.getBookcount() - 1);
					break;
				}
			}

		}

		return count;
	}

}
