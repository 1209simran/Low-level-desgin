package model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {

    private int id;
    private HashMap<Integer, Integer> itemWithQuantityList;
    private double billAmount;
    private LocalDateTime createdOrderTs;
    private LocalDateTime updatedOrderTs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Integer> getItemWithQuantityList() {
        return itemWithQuantityList;
    }

    public void setItemWithQuantityList(HashMap<Integer, Integer> itemWithQuantityList) {
        this.itemWithQuantityList = itemWithQuantityList;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public LocalDateTime getCreatedOrderTs() {
        return createdOrderTs;
    }

    public void setCreatedOrderTs(LocalDateTime createdOrderTs) {
        this.createdOrderTs = createdOrderTs;
    }

    public LocalDateTime getUpdatedOrderTs() {
        return updatedOrderTs;
    }

    public void setUpdatedOrderTs(LocalDateTime updatedOrderTs) {
        this.updatedOrderTs = updatedOrderTs;
    }
}
