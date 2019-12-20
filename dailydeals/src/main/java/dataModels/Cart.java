package dataModels;

public class Cart {
    private int quantity;
    private String customerEmail;
    private String productName;


    public Cart(String email, String product, int quantity){
        this.customerEmail = email;
        this.productName = product;
        this.quantity = quantity;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public String getProductName(){
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
       this.quantity = quantity;
    }


}
