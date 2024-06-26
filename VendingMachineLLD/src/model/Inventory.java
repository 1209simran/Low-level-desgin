package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Product> products;

    public Inventory(int inventorySize) {
        this.products = new ArrayList<>(inventorySize);
    }

    public void addProduct(Product product) {
        boolean isProductExist = false;
        System.out.println("Adding product in vending machine");

        for (Product prod : products) {
            if (prod.getProductCode() == product.getProductCode()) {
                if (prod.getQuantity() >= 10) {
                    System.out.println("Cannot add products more than 10");
                    continue;
                }
                prod.addQuantity(product.getQuantity());
            }
        }
        if (!isProductExist)
            products.add(product);
    }

    public void updateProduct(int productCode) {
        System.out.println("Removing product from vending machine");

        for (Product prod : products) {
            if (prod.getProductCode() == productCode && prod.getQuantity() > 0) {
                prod.subtractQuantity(1);
                if (prod.getQuantity() == 0) {
                    products.remove(prod);
                }
            }

        }
    }

    public Product getProduct(int productCode) {

        for (Product prod : products) {
            if (prod.getProductCode() == productCode) {
                return prod;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
