package dataModels;

public class WishList {
    private String email;
    private String product;
    private int priority;

    public WishList(String email, String product, int priority) {
        this.email = email;
        this.product = product;
        this.priority = priority;
    }

    public String getCustomerEmail() {
        return email;
    }

    public String getProductName() {
        return product;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}