package model;

public class Product {

    private int code;
    private String name;
    private double price;
    private long quantity;

    public Product(int code, String name, double price, long quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void addQuantity(long quantity) {
        setQuantity(this.quantity + quantity);
    }

    public int getProductCode() {
        return code;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void subtractQuantity(long quantity) {
        setQuantity(this.quantity - quantity);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

