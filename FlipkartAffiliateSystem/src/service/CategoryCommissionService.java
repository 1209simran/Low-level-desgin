package service;

import dao.CategoryCommissionDao;
import enums.Category;
import enums.CommissionType;
import model.CategoryCommission;

public class CategoryCommissionService {

    private final CategoryCommissionDao categoryCommissionDao;

    public CategoryCommissionService(CategoryCommissionDao categoryCommissionDao) {
        this.categoryCommissionDao = categoryCommissionDao;
    }

    public void addCommission(String category, String commissionType, Double percentage,
                              Double flatRate, Double maxCap) {
        if (categoryCommissionDao.isCategoryExists(category)) {
            System.out.println("Category commission -> " + category + " already exists");
            return;
        }
        Category cat = Category.valueOf(category);
        CommissionType comType = CommissionType.valueOf(commissionType);
        CategoryCommission categoryCommission = new CategoryCommission(cat, comType, percentage, flatRate, maxCap);
        categoryCommissionDao.addCommission(categoryCommission);
        System.out.println("Added Commission for category -> " + category);
    }

    public CategoryCommission getCommission(String category) {
        return categoryCommissionDao.getCommission(category);
    }

}
