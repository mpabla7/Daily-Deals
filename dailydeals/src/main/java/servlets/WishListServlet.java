package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.WishListDAO;
import DAOs.CustomerDAO;
import dataModels.*;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/WishListServlet")
public class WishListServlet extends HttpServlet {

	private int priority;
	private String email;
	private String productName;
	private WishListDAO wishListdao;
	private CustomerDAO customerDAO;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WishListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getMethod());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto
		// doGet(request, response);
		email = (String)request.getSession().getAttribute("AuthUserEmail");
		System.out.println(email);
		wishListdao = new WishListDAO();
		customerDAO = new CustomerDAO();
		Customer customer = customerDAO.getCustomerByEmail(email);
		System.out.println(customer.get_firstName());
		if (customer.get_email() == null) {
			// redirect to the login page if the customer is not logged in
			response.sendRedirect("loginPage.jsp");
		} else {
			// if the user is logged in proceed to load in the information from the db about
			// the user's wishlist
			ArrayList<WishList> wishlist = wishListdao.getWishListForCustomer(email);
			HttpSession session = request.getSession();
			session.setAttribute("wishlist", wishlist);
			// request.setAttribute("wishlist", wishlist);
			response.sendRedirect("wishList.jsp");
		}
	}

}
