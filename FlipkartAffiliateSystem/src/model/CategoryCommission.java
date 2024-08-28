package model;

import enums.Category;
import enums.CommissionType;

public class CategoryCommission {

    private Category category;
    private CommissionType commissionType;
    private Double maxCap;
    private Double percentage;
    private Double flatRate;

    public CategoryCommission(Category category, CommissionType commissionType, Double percentage, Double flatRate, Double maxCap) {
        this.category = category;
        this.commissionType = commissionType;
        this.maxCap = maxCap;
        this.percentage = percentage;
        this.flatRate = flatRate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
    }

    public Double getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(Double maxCap) {
        this.maxCap = maxCap;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Double getFlatRate() {
        return flatRate;
    }

    public void setFlatRate(Double flatRate) {
        this.flatRate = flatRate;
    }
}
