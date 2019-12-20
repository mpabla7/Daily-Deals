package DAOs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataModels.Review;

public class ReviewDAO {
	
	public Review getReview(String customerEmail, String productName) {
		Connection con = connectToDB();
		Review review = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reviewedBy WHERE email = '" + customerEmail + "' AND productName = '" + productName + "';");
        
			while(rs.next()) {
				 review = new Review(rs.getString(1), rs.getString(2), rs.getBoolean(3),rs.getString(4));
			}
     
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return review;
	}
	
	/**
	 * Checks if a review exists, used by createReview to ensure two reviews
     * for a product are not being made
	 * 
	 * @param email
	 * @param productName
	 */
	public boolean isReviewedBy(String email, String productName) {
		Connection con = connectToDB();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reviewedBy WHERE email = '" + email + "' " + " AND productName = " +"'" + productName +"'");
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
	 * updates customer review if customer wants to change or modify their review on a product
	 * 
	 * @param email
	 * @param productName
	 * @param isRecommended
	 * @param reviewText
	 */
	public void updateReview(String email, String productName, Boolean isRecommended, String reviewText) {
		
		Connection con = connectToDB();
		Review review = null;
        
        String updateIsRecommended = "";
        String updateReviewText = "";

		// the boolean must always be entered and updated when update is called
		updateIsRecommended = "UPDATE dailyDeals.reviewedBy SET isRecommended = " + "'" + isRecommended + "'" 
		+ " WHERE email = " + "'" + email + "' AND productName = '" + productName + "'";
	
		// if user has entered reviewText update the text, otherwise leave it
		if(updateReviewText.length()>0) {
			updateReviewText = "UPDATE dailyDeals.reviewedBy SET reviewText = " + "'" + reviewText + "'" 
			+ " WHERE email = " + "'" + email + "' AND productName = '" + productName + "'";
		}
		
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(updateIsRecommended);
			if(updateReviewText.length()>0) {
				stmt.executeUpdate(updateReviewText);
			}
			
			stmt.close();
			con.close();
			
		}catch(SQLException e){
	        System.out.println("SQLException caught: " + e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * Will create a review when a customer posts a review on a product page
	 * 
	 * @param email
	 * @param productName
	 * @param isRecommended
	 * @param reviewText
	 */
	public void createReview(String email, String productName, Boolean isRecommended, String reviewText) throws Exception {

        // throw an exception if a review already exists
        if(isReviewedBy(email, productName))
            throw new Exception("Please use updateReview or delete the review before creating a new one.");

		String insertMe = "INSERT INTO dailyDeals.reviewedBy "
				+ "(email, productName, isRecommended, reviewText)"
				+ " VALUES (" +  "'" +email + "'"+ ", " + "'"+ productName +"'"+ ", " + "'"+isRecommended+ "'"+ ", " +"'" +reviewText+ "');";
		
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
    
    /**
	 * 
	 * Will create a review when a customer posts a review on a product page
     * This method allows the customer to rate a product without posting a review
	 * 
	 * @param email
	 * @param productName
	 * @param isRecommended
	 * @param reviewText
	 */
	public void createReview(String email, String productName, Boolean isRecommended) throws Exception {
        createReview(email, productName, isRecommended, "");
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
//	public static void main(String[] args) {
//		ReviewDAO reviewDAO = new ReviewDAO();
//		Review review = reviewDAO.getReview("jimmiy@yahoo.com", "Macbook Pro");
//		
//		if(customer!=null) {
//			System.out.println("email: "+review.getReviewEmail());
//			System.out.println("product: "+review.getProductName());
//			System.out.println("isRecommended: "+review.isRecommended());
//			System.out.println("Review: "+review.getReviewText());
//			
//		}else {
//			System.out.println("");
//		}
//	}
}
