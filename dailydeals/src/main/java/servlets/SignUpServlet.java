package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.CustomerDAO;
import dataModels.Customer;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	private String _username;
	private String _email;
	private String _password;
	private String _fn;
	private String _ln;
	// _address and _cardNumber will be updated at a later time in the user's account management page 
	// NOT when first creating an account
	private String _address = "na";
	private String _cardNumber = "na";
	private CustomerDAO custDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		//doGet(request, response);
		
		_username = request.getParameter("user_username");
		_email = request.getParameter("user_email");
		_password = request.getParameter("user_pass");
		_fn = request.getParameter("user_fn");
		_ln = request.getParameter("user_ln");
		
		custDAO = new CustomerDAO();
		Customer customer = custDAO.getCustomerByEmail(_email);
		if(customer != null) {
			HttpSession session = request.getSession();
			session.setAttribute("emailIsUsed", true);
			response.sendRedirect("signUpPage.jsp");
			
		}else {
			custDAO.createCustomer(_username, _email, _password, _fn, _ln, _address, _cardNumber);
			response.sendRedirect("loginPage.jsp");
		}
		
	}
}
