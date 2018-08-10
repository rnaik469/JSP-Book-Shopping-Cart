package in.cg.bookshop.service;

import java.util.Collection;
import java.util.List;

import in.co.cg.bookshop.pojo.Books;

/**
 * @author Rohit Naik
 *
 */
public interface BookShopServiceI {

	public Collection<Books> allBooks();

	int addBookCart(int id);

	Collection<Books> viewBookCart();

	int removeBookFromCart(int BookId);

}