package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataModels.Product;

public class ProductDAO {
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = connectToDB();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product");
        
			while(rs.next()) {
				Product product = new Product(rs.getString(1),rs.getDouble(2),rs.getInt(3),rs.getDouble(4),rs.getString(5));
				product.setImageUrls(getProductImage(rs.getString(1)));
				product.setRatingStar(getStars(rs.getDouble(4)));
				products.add(product);
				
			}
     
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return products;
	}
	public Product getProductByName(String name) {
		Connection con = connectToDB();
		Product product = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE productName = '"+name+"'");
        
			if(rs.next()) {
				 product = new Product(rs.getString(1),rs.getDouble(2),rs.getInt(3),rs.getDouble(4),rs.getString(5));
			}
			product.setImageUrls(getProductImage(rs.getString(1)));
			product.setRatingStar(getStars(rs.getDouble(4)));
     
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return product;
	}
	private ArrayList<String> getProductImage(String name){
		ArrayList<String> result = new ArrayList<>();
		Connection con = connectToDB();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT url FROM product_image WHERE productName = '"+name+"'");
        
			while(rs.next()) {
				 result.add(rs.getString(1));
			}
     
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
		return result;
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
	private String getStars(double rating) {
		StringBuilder sb = new StringBuilder();
		int starCount = 0;
		for(int i = 0;i<(int)rating;i++){
			sb.append("<i class=\"fa fa-star\"></i>");
			starCount++;
		}
		if(rating%1>=0.79){
			sb.append("<i class=\"fa fa-star\"></i>");
			starCount++;
		}else if(rating%1>=0.3){
			sb.append("<i class=\"fa fa-star-half-o\"></i>");
			starCount++;
		}
		while(starCount<5){
			sb.append("<i class=\"fa fa-star-o\"></i>");
			starCount++;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		System.out.println(productDAO.getProductByName("iPhone 11 Pro").getImageUrls());
		for(Product p: productDAO.getAllProducts()) {
			System.out.println(p.getProductName()+": "+p.getImageUrls());
		}
	}
}
