package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.CustomerDAO;

/**
 * Servlet implementation class AccountManagementServlet
 */
@WebServlet("/AccountManagementServlet")
public class AccountManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String _oldPassword;
	private String _newPassword; 
	private String _email;
	private String _cardNum;
	private CustomerDAO _custDAO;
	private String _addr="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountManagementServlet() {
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
		
		String region="";
		if(request.getParameter("region")!=null) {
			region = request.getParameter("region");
		}
		String fullAddr = request.getParameter("user_addr_1") + " " + request.getParameter("user_addr_2") + " "
				+ request.getParameter("user_city") + " " + region + " " +request.getParameter("user_state")
			    + " " + request.getParameter("user_zip");
		
		_oldPassword=request.getParameter("user_old_pass");
		_email = request.getParameter("user_email");
		_newPassword = request.getParameter("user_new_pass");
		_cardNum = request.getParameter("user_card");
		_addr = fullAddr;

		_custDAO = new CustomerDAO();
		
		// check if user exists before attempting to update info
		if(_custDAO.userAuth(_oldPassword, _email)){
			
			_custDAO.updateCustomerInfo(_newPassword, _email, _addr, _cardNum);
			
		}else{
			System.out.print("USER DOES NOT EXISIT");
		}
	}
}
