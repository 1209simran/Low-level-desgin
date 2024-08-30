package model;

import java.util.List;

public class Table {
    private int id;
    private int numOfSeats;
    private boolean isAvailable;
    private Order order;
    private boolean isBillPaid;

    public Table(int id) {
        this.id = id;
        this.numOfSeats = 5;
        this.isAvailable = true;
        this.isBillPaid = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public void setBillPaid(boolean billPaid) {
        isBillPaid = billPaid;
    }
}
