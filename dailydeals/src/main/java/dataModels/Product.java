package dataModels;

import java.util.ArrayList;

public class Product {
	String productName;
	double price;
	double rating;
	String description;
	ArrayList<String> imageUrls;
	int quantity;
	String ratingStar;
	
	public String getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(String ratingStar) {
		this.ratingStar = ratingStar;
	}

	public Product(String productName,double price, int quantity, double rating, String description) {
		this.productName = productName;
		this.price = price;
		this.rating = rating;
		this.description = description;
		this.quantity = quantity;
	}
	//image are stored in AWS S3.

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
}
