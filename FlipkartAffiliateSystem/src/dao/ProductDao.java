package dao;

import model.Product;

import java.util.HashMap;

public class ProductDao {
    private static ProductDao productDao;
    private HashMap<String, Product> products;

    public ProductDao() {
        this.products = new HashMap<>();
    }

    public static ProductDao getInstance() {
        if (productDao == null)
            productDao = new ProductDao();
        return productDao;
    }

    public boolean isProductExist(String id) {
        return products.containsKey(id);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }
}
