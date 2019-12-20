package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.CartDAO;
import DAOs.CustomerDAO;
import DAOs.WishListDAO;
import dataModels.Cart;
import dataModels.Customer;

/**
 * Servlet implementation class GetCartServlet
 */
@WebServlet("/GetCartServlet")
public class GetCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getMethod());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String)request.getSession().getAttribute("AuthUserEmail");
		CartDAO cartdao = new CartDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.getCustomerByEmail(email);
		if (customer.get_email() == null) {
			// redirect to the login page if the customer is not logged in
			response.sendRedirect("loginPage.jsp");
		} else {
			// if the user is logged in proceed to load in the information from the db about
			// the user's wishlist
			ArrayList<Cart> cart = cartdao.getCartForCustomer(email);
			HttpSession session = request.getSession();
			session.setAttribute("cart", cart);
			response.sendRedirect("cart.jsp");
		}

	}

}
