package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.CartDAO;

/**
 * Servlet implementation class AddToCartFromMainServlet
 */
@WebServlet("/AddToCartFromMainServlet")
public class AddToCartFromMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartFromMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		System.out.println("quantity"+request.getParameter("quantity")+" "+request.getSession().getAttribute("AuthUserEmail"));
		CartDAO inCartDAO = new CartDAO();
		System.out.println("product: "+request.getParameter("productName"));
		String productName = request.getParameter("productName");
		String email = (String)request.getSession().getAttribute("AuthUserEmail");
		int quantity = 1;
		inCartDAO.addProduct(productName, email, quantity);
		CartDAO cartDAO = new CartDAO();
		double price = Double.valueOf(request.getParameter("price"));
		double amount = price * quantity;
		cartDAO.updateCart(email, amount);
		response.sendRedirect("GetCartServlet");
		
	}

}
