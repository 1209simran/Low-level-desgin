package service;

import dao.ProductDao;
import enums.Category;
import model.Product;

public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(String id, String name, String category) {
        if (productDao.isProductExist(id)) {
            System.out.println("Product -> " + name + " already exists");
            return;
        }
        Category productCat = Category.valueOf(category);
        Product product = new Product(id, name, productCat);
        productDao.addProduct(product);
        System.out.println("Added Product -> " + name);

    }
}
