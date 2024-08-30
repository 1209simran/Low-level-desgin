package service;

import dao.TableDao;
import model.Restaurant;
import model.Table;

public class TableService {
    private static int tableId = 1;
    private final TableDao tableDao;
    private Restaurant restaurant;

    public TableService(RestaurantService restaurantService, TableDao tableDao) {
        this.tableDao = tableDao;
        this.restaurant = restaurantService.getRestaturant();
    }

    public void addTable() {

        Table table = new Table(generateTableId());
        tableDao.addTable(restaurant, table);
    }

    private int generateTableId() {
        return tableId++;
    }

    public void reserveTable(int id) {
        tableDao.reserveTable(restaurant, id);
    }
}
