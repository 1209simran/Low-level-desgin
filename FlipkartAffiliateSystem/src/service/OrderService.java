package service;

import dao.OrderDao;
import enums.OrderStatus;
import model.Affiliate;
import model.CategoryCommission;
import model.Order;
import model.Transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderService {

    private final OrderDao orderDao;
    private final CategoryCommissionService categoryCommissionService;
    private final AffiliateService affiliateService;
    private final TransactionService transactionService;

    public OrderService(OrderDao orderDao, CategoryCommissionService categoryCommissionService, AffiliateService affiliateService, TransactionService transactionService) {
        this.orderDao = orderDao;
        this.categoryCommissionService = categoryCommissionService;
        this.affiliateService = affiliateService;
        this.transactionService = transactionService;
    }


    public void addOrder(String orderId, double amount, String productId, String category,
                         String affiliateId, String orderStatus, String createdAt) {
        if (orderDao.isOrderExists(orderId)) {
            System.out.println("Order -> " + orderId + " already exists. Can't add same orderId");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        OrderStatus ordStat = OrderStatus.valueOf(orderStatus);
        LocalDateTime orderedAt = LocalDateTime.parse(createdAt, formatter);
        Order order = new Order(orderId, productId, amount, ordStat, orderedAt, affiliateId);
        double commission = calculateCommission(category, amount);
        affiliateService.updateAffiliateCommission(affiliateId, commission);
        order.setCommission(commission);
        orderDao.addOrder(order);
        System.out.println("Create order with order id ->" + orderId);
    }

    private double calculateCommission(String category, double amount) {
        CategoryCommission categoryCommission = categoryCommissionService.getCommission(category);
        double commission = 0.0;
        if (categoryCommission.getPercentage() != null) {
            commission = (amount * categoryCommission.getPercentage()) / 100;
            if (commission > categoryCommission.getMaxCap())
                commission = categoryCommission.getMaxCap();
        } else {
            commission = categoryCommission.getFlatRate();
        }
        return commission;
    }

    public void updateOrder(String orderId, String orderStatus) {
        if (!orderDao.isOrderExists(orderId)) {
            System.out.println("Order -> " + orderId + " doesn't exists.");
            return;
        }
        Order order = orderDao.getOrder(orderId);
        OrderStatus ordStat = OrderStatus.valueOf(orderStatus);
        orderDao.updateOrder(orderId, ordStat);
        System.out.println("Update order with order id -> " + orderId);
        if (ordStat.equals(OrderStatus.RETURN_PERIOD_EXPIRED)) {
            payCommission(order);
        }
    }

    private void payCommission(Order order) {
        Transaction transaction = new Transaction();
        String affId = order.getAffiliateId();
        Affiliate affiliate = affiliateService.getAffiliateById(affId);
        double commDiff = affiliate.getComissionAmountTillDate() - affiliate.getComissionPaidTillDate();
        if (commDiff > 100) {
            transaction.setOrderId(order.getOrderId());
            transaction.setTransactionId(UUID.randomUUID().toString());
            transaction.setAffiliateId(affId);
            transaction.setTotalAmount(commDiff);
            transactionService.addTransaction(transaction);
            affiliateService.updateAffiliatePaidCommission(affId, commDiff);
            System.out.println("Transaction for affiliate " + affId + " of Rs " + commDiff + " paid!");
        }
    }

    public void getOrdersByAffiliateAndStatus(String affId, String orderStatus) {
        OrderStatus orderStat = OrderStatus.valueOf(orderStatus);
        List<Order> orders = orderDao.getAllOrders();
        orders = orders.stream().filter(order -> order.getAffiliateId().equals(affId) &&
                order.getOrderStatus().equals(orderStat)).collect(Collectors.toUnmodifiableList());
        orders.forEach(order -> {
            System.out.println("Order id -> " + order.getOrderId());
        });

    }
}
