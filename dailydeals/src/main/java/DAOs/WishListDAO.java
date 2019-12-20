package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataModels.*;

public class WishListDAO {
	public ArrayList<WishList> getWishListForCustomer(String email){
		ArrayList<WishList> wishlist = new ArrayList<WishList>();
		Connection con = connectToDB();
		try {
			Statement stmt = con.createStatement();
			ResultSet wishedProducts = stmt.executeQuery("SELECT * FROM wishFor WHERE email=" + "'" + email + "' ORDER BY priority ASC;");
			
			while(wishedProducts.next()) {
				wishlist.add(new WishList(wishedProducts.getString(1),wishedProducts.getString(2),wishedProducts.getInt(3)));
			}
     
			wishedProducts.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return wishlist;
	}

	public WishList getWishlistItem(String email, String productName){
		Connection con = connectToDB();
		WishList wishlistItem = null;
		try{
			Statement stmt = con.createStatement();
			ResultSet wishedProducts = stmt.executeQuery("SELECT * FROM wishFor WHERE email=" + "'" + email + "' AND productName='" + productName + "';");
			wishlistItem = new WishList(wishedProducts.getString(1), wishedProducts.getString(2), wishedProducts.getInt(3));
		}catch(SQLException e){
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return wishlistItem;
	}

	public void addItem(String productName, String email) {
		
		Connection con = connectToDB();
		String countStatement = "SELECT COUNT(email) FROM dailyDeals.wishFor WHERE email='" + email + "';";
		int priority = 1;
		// gets the last priority to insert the new item to the end of the wishlist
		try {
			
			Statement stmt = con.createStatement();
			ResultSet countResult = stmt.executeQuery(countStatement);
			priority = countResult.getInt(1) + 1;
			
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}

		String insertMe = "INSERT INTO dailyDeals.wishFor VALUES(" +  "'" +email + "'"+ ", " + "'"+ productName +"','" + priority + "');";
		
		
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

	public void removeItem(String email, String productName){
		
		String deleteString = "DELETE FROM dailyDeals.wishFor WHERE email='" + email + "' AND productName ='" + productName + "';";
		Connection con = connectToDB();
		
		try {
			
			Statement stmt = con.createStatement();
			System.out.println("Attempting to remove item");
			stmt.executeUpdate(deleteString);
			System.out.println("Item successfully removed");
						
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("Item failed to be removed");
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dailyDeals?serverTimezone=EST5EDT", "root",
					password);
			System.out.println(db + " database successfully opened.</br></br>");
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException caught: " + e.getMessage());
		}
		return con;
	}
}
