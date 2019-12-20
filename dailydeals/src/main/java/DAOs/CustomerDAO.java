package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.*;

import dataModels.Customer;

public class CustomerDAO {
	
	public Customer getCustomerByEmail(String email) {
		Connection con = connectToDB();
		Customer customer = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE email = '"+email+"'");
        
			while(rs.next()) {
				 customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}
     
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return customer;
	}
	
	/**
	 * Returns true if user exists in the database, otherwise returns false 
	 * Used in LoginServlet/AccountManagementServlet to verify if the user logging in has an account 
	 * 
	 * @param password
	 * @param email
	 * @return boolean
	 */
	public boolean userAuth(String password, String email) {
		Connection con = connectToDB();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE email = '"+email+"' " + " AND password = " +"'" + password +"'");
			if (rs.next()) return true;
			stmt.close();
			con.close();
		}
		catch(SQLException e){
			System.out.println("SQLException caught: " + e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * updates customer info when customer updates their info in account management page. 
	 * Used in AccountManagementServlet 
	 * 
	 * @param newPassword
	 * @param email
	 * @param address
	 * @param cardNum
	 */
	public void updateCustomerInfo(String newPassword, String email, String address, String cardNum) {
		
		Connection con = connectToDB();
		Customer customer = null;
		
		String update_pass=""; 
		String update_cardNum="";
		String updateAddr="";
		
		// if user has entered a new password, then update their password 
		if(newPassword.length()>0) {
			update_pass = "UPDATE dailyDeals.customer SET password = " + "'" + newPassword + "'" 
			+ " WHERE email = " + "'" + email + "'";
		}
		// if user has entered a credit Card, then update their card number 
		if(cardNum.length()>0) {

			update_cardNum = "UPDATE dailyDeals.customer SET cardNumber = " + "'" + cardNum + "'" 
			+ " WHERE email = " + "'" + email + "'";
		}
		// if user has entered a new address, then update their address 
		if(address.length()>5) {
			updateAddr = "UPDATE dailyDeals.customer SET address = " + "'" + address + "'" 
			+ " WHERE email = " + "'" + email + "'";
		}
		
		
		try {
			Statement stmt = con.createStatement();
			
			if(update_cardNum.length()>0) {
				stmt.executeUpdate(update_cardNum);
			}
			if(updateAddr.length()>0) {
				stmt.executeUpdate(updateAddr);
			}
			if(update_pass.length()>0) {
				stmt.executeUpdate(update_pass);
			}
		
			stmt.close();
			con.close();
			
		}catch(SQLException e){
	        System.out.println("SQLException caught: " + e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * Will create a customer from the input given in signUpPage.jsp
	 * When user first signs up, he/she does not input their credit card number or address
	 * Address and credit card number is later specified in the account management page
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param fn
	 * @param ln
	 * @param addr
	 * @param cardNum
	 */
	public void createCustomer(String username, String email, String password, String fn, String ln, String addr, String cardNum) {
		String insertMe = "INSERT INTO dailyDeals.customer "
				+ "(email, username, password, firstName, lastName, address, cardNumber)"
				+ " VALUES (" +  "'" +email + "'"+ ", " + "'"+ username +"'"+ ", " + "'"+password+ "'"+ ", " +"'" +fn+ "'"+", " 
				+ "'"+ln+"'" +", " + "'"+addr+"'" +", " +"'" +cardNum +"'"+ ");";
		
		Connection con = connectToDB();
		
		try {
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertMe);
						
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}	
	}
	
	
	private Connection connectToDB() {
		String db = "dailyDeals";
		String user; // assumes database name is the same as username
		user = "root";
		String password = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db + "?serverTimezone=EST5EDT", "root",
					password);
			System.out.println(db + " database successfully opened.</br></br>");
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException caught: " + e.getMessage());
		}
		return con;
	}
	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.getCustomerByEmail("jimmiy@yahoo.com");
		
		if(customer!=null) {
			System.out.println("firstname: "+customer.get_firstName());
			System.out.println("lastname: "+customer.get_lastName());
			System.out.println("address: "+customer.get_address());
			System.out.println("username: "+customer.get_username());
			System.out.println("cardNumber: "+customer.get_cardNumber());
			System.out.println("email: "+customer.get_email());
			System.out.println("password: "+customer.get_password());
			
		}else {
			System.out.println("");
		}
	}
}
