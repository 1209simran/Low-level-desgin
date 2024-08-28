package dao;

import model.CategoryCommission;

import java.util.HashMap;

public class CategoryCommissionDao {

    private static CategoryCommissionDao commissionDao = null;
    private HashMap<String, CategoryCommission> categoryCommissions;

    public CategoryCommissionDao() {
        this.categoryCommissions = new HashMap<>();
    }

    public static CategoryCommissionDao getInstance() {
        if (commissionDao == null)
            commissionDao = new CategoryCommissionDao();
        return commissionDao;
    }

    public boolean isCategoryExists(String category) {
        return categoryCommissions.containsKey(category);
    }

    public void addCommission(CategoryCommission categoryCommission) {
        categoryCommissions.put(categoryCommission.getCategory().toString(), categoryCommission);
    }

    public CategoryCommission getCommission(String category) {
        return categoryCommissions.get(category);
    }
}
