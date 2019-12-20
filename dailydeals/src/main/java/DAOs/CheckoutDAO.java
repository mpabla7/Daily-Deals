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

public class CheckoutDAO {
	private Connection connectToDB() {

        String orderNumber;
        String status;
        String shippingSpeed;
        String date;
        String time;
        Double shippingCost;


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

	public void checkout(){
        String checkCart = "";

		Connection con = connectToDB();

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(checkCart);
			if (rs.next()) {
				
			}

			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		}
    }

}
