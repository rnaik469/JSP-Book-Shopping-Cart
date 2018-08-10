package in.co.cg.bookshop.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import in.cg.bookshop.service.BookShopService;
import in.cg.bookshop.service.BookShopServiceI;
import in.co.cg.bookshop.pojo.Books;
import sun.rmi.server.Dispatcher;

/**
 * @author Rohit Naik
 *  Servlet implementation class BookShopController
 */

@WebServlet("*.app")
public class BookShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookShopServiceI bookShopService = new BookShopService();// Instantiating BookShopServiceI

		HttpSession session = request.getSession();

		String action = request.getServletPath();// Action from the User
		switch (action) {
		case "/books.app":
			session.setAttribute("books", bookShopService.allBooks());// Display All Books
			session.setAttribute("cartC", count);
			response.sendRedirect("home.jsp");

			break;
		case "/add.app":
			int id = Integer.parseInt(request.getParameter("bookId")); // Update count in the cart
			count = bookShopService.addBookCart(id); // Add book to cart
			session.setAttribute("cartC", count); // Set cart count
			response.sendRedirect("home.jsp");
			break;
		case "/view.app":
			session.setAttribute("cart", bookShopService.viewBookCart()); // Display all the books in the cart
			response.sendRedirect("cart.jsp");
			break;

		case "/remove.app":
			int bId = Integer.parseInt(request.getParameter("bookId"));// Update count in the cart
			count = bookShopService.removeBookFromCart(bId); // Add book to cart
			session.setAttribute("cartC", count);
			session.setAttribute("cart", bookShopService.viewBookCart());
			response.sendRedirect("cart.jsp");
			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
