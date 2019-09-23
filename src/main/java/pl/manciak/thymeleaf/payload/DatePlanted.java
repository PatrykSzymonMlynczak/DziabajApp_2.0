package pl.manciak.thymeleaf.payload;

public class DatePlanted {
    String productName;

    public DatePlanted(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }
}
