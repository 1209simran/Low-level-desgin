package model;

import enums.OrderStatus;

import java.time.LocalDateTime;

public class Order {

    private String orderId;
    private String productId;
    private double amount;
    private OrderStatus orderStatus;
    private LocalDateTime orderdAt;
    private LocalDateTime orderUpdatedAt;
    private String affiliateId;
    private double commission;

    public Order(String orderId, String productId, double amount, OrderStatus orderStatus, LocalDateTime orderdAt, String affiliateId) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.orderdAt = orderdAt;
        this.affiliateId = affiliateId;
        this.commission = 0.0;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderdAt() {
        return orderdAt;
    }

    public void setOrderdAt(LocalDateTime orderdAt) {
        this.orderdAt = orderdAt;
    }

    public LocalDateTime getOrderUpdatedAt() {
        return orderUpdatedAt;
    }

    public void setOrderUpdatedAt(LocalDateTime orderUpdatedAt) {
        this.orderUpdatedAt = orderUpdatedAt;
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
