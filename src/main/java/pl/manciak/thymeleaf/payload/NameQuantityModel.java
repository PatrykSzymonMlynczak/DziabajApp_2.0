package pl.manciak.thymeleaf.payload;

public class NameQuantityModel {
    private String productName;
    private Float productQuantity;
    private String mealName;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Float productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
}
