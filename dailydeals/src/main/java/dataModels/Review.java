package dataModels;

public class Review {
    private String customerEmail;
    private String productName;
    private boolean isRecommended;
    private String reviewText;

    public Review(String email, String product, boolean isRecommended, String text){
        this.customerEmail = email;
        this.productName = product;
        this.isRecommended = isRecommended;
        this.reviewText = text;
    }

    public Review(String email, String product, boolean isRecommended){
        this.customerEmail = email;
        this.productName = product;
        this.isRecommended = isRecommended;
    }

    public String getReviewEmail(){
        return customerEmail;
    }

    public String getProductName(){
        return productName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Boolean isRecommended() {
        return isRecommended;
    }

    public void setReviewText(String text){
        reviewText = text;
    }

    public void setRecommendation(boolean isRecommended){
        this.isRecommended = isRecommended;
    }

}
