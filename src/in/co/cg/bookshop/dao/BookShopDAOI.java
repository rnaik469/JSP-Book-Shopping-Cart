package in.co.cg.bookshop.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import in.co.cg.bookshop.pojo.Books;

public interface BookShopDAOI {

	 Map<Integer,Books> allBooks();

	void addBookCart(Books book);

	Collection<Books> viewBookCart();

	void removeBookFromCart(int BookId);

}