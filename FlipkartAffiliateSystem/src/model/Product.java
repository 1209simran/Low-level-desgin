package model;

import enums.Category;

public class Product {

    private String id;
    private String productName;
    private Category category;

    public Product(String id, String productName, Category category) {
        this.id = id;
        this.productName = productName;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
