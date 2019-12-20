package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.exceptions.RSAException;
import com.mysql.cj.protocol.Resultset;

import dataModels.Cart;

public class CartDAO {
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

	public void updateCart(String email, double amount) {
		String checkCart = "SELECT COUNT(*) FROM dailyDeals.shoppingcart WHERE email = '" + email + "';";

		Connection con = connectToDB();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(checkCart);
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					createCart(email, amount);
				} else {
					actualUpdateCart(email, amount);
				}
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
	}

	public void actualUpdateCart(String email, double amount) {
		String QueryCart = "SELECT totalCost FROM dailyDeals.shoppingcart WHERE email = '" + email + "';";

		Connection con = connectToDB();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QueryCart);
			if (rs.next()) {
				amount += rs.getDouble(1);
				String updateCart = "UPDATE shoppingCart SET totalCost =" + amount + " WHERE email= '" + email + "';";
				stmt.executeUpdate(updateCart);
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
	}

	public void createCart(String email, double amount) {
		String insertCart = "INSERT INTO dailyDeals.shoppingcart (email,avalibleSales,totalCost) VALUES('" + email
				+ "', 100," + amount + ");";

		Connection con = connectToDB();

		try {

			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertCart);

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
	}

	public void addProduct(String productName, String email, int quantity) {
		String insertMe = "INSERT INTO dailyDeals.inCart "
				+ "(email, productName, quantity)"
				+ " VALUES (" +  "'" +email + "'"+ ", " + "'"+ productName +"'"+ ", " + "'"+quantity+ "');";
		
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

	public void removeProduct(String productName, String email){
		String deleteString = "DELETE FROM dailyDeals.inCart WHERE email='" + email + "' AND productName ='" + productName + "';";
		
		Connection con = connectToDB();
		
		try {
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(deleteString);
						
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}	
	}

	public ArrayList<Cart> getCartForCustomer(String email){
		ArrayList<Cart> cart = new ArrayList<Cart>();
		Connection con = connectToDB();
		try {
			Statement stmt = con.createStatement();
			ResultSet wishedProducts = stmt.executeQuery("SELECT * FROM inCart WHERE email=" + "'" + email + "';");
			
			while(wishedProducts.next()) {
				cart.add(new Cart(wishedProducts.getString(1),wishedProducts.getString(2),wishedProducts.getInt(3)));
			}
     
			wishedProducts.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return cart;
	}

}
