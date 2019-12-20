package servlets;

import java.io.IOException;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.CustomerDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private String _email;
	private String _password;
	private CustomerDAO custDAO;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		_password = request.getParameter("user_pass");
		_email = request.getParameter("user_email");
		
		custDAO = new CustomerDAO();		
		boolean validUser = custDAO.userAuth(_password, _email);
		System.out.println("loginServlet: "+request.getMethod());
		if(validUser){
			// redirect to next main web page after logging (not made yet)
			HttpSession session = request.getSession();
			session.setAttribute("AuthUserEmail", _email);
			//response.sendRedirect("MainPageServlet");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MainPageServlet");
			requestDispatcher.forward(request, response);
		}else{
			// invalid password
			HttpSession session = request.getSession();
			session.setAttribute("authResult", false);
			response.sendRedirect("loginPage.jsp");
		}
	}

}
