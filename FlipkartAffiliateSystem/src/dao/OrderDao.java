package dao;

import enums.OrderStatus;
import model.Order;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class OrderDao {

    private static OrderDao orderDao = null;
    private HashMap<String, Order> orders;

    public OrderDao() {
        this.orders = new HashMap<>();
    }

    public static OrderDao getInstance() {
        if (orderDao == null)
            orderDao = new OrderDao();
        return orderDao;
    }

    public boolean isOrderExists(String id) {
        return orders.containsKey(id);
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void updateOrder(String id, OrderStatus orderStatus) {
        Order order = orders.get(id);
        order.setOrderStatus(orderStatus);
        order.setOrderUpdatedAt(LocalDateTime.now());
        orders.put(order.getOrderId(), order);
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public List<Order> getAllOrders() {
        return orders.values().stream().toList();
    }
}
