package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.CartDAO;
import DAOs.WishListDAO;;

/**
 * Servlet implementation class AddToWishListFromCartServlet
 */
@WebServlet("/AddToWishListFromCartServlet")
public class AddToWishListFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToWishListFromCartServlet() {
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
        WishListDAO wishDAO = new WishListDAO();
        CartDAO cartdao = new CartDAO();
        String email = (String)request.getSession().getAttribute("AuthUserEmail");
		String productName = request.getParameter("productName");
		System.out.println("email: " + email + " product: " + productName);
        wishDAO.addItem(productName, email);
        cartdao.removeProduct(productName, email);
        response.sendRedirect("WishListServlet");
	}

}
