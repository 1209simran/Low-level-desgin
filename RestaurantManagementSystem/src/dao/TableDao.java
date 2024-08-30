package dao;

import model.Restaurant;
import model.Table;

import java.util.HashMap;

public class TableDao {

    private HashMap<Integer, Table> tableHashMap;

    public TableDao() {
        this.tableHashMap = new HashMap<>();
    }

    public void addTable(Restaurant restaurant, Table table) {
        tableHashMap.put(table.getId(), table);
        restaurant.addTable(table);
        System.out.println("Added new table with id - " + table.getId());
    }

    public void reserveTable(Restaurant restaurant, int id) {
        restaurant.getTable().stream().map(table -> {
            if (table.getId() == id && table.isAvailable()) {
                table.setAvailable(false); // Update condition
            }
            return table;
        });
        if (tableHashMap.containsKey(id) && tableHashMap.get(id).isAvailable()) {
            Table table = tableHashMap.get(id);
            table.setAvailable(false);
            tableHashMap.put(table.getId(), table);
            System.out.println("Table id -> " + table.getId() + " allocated");
        } else {
            System.out.println("Table id -> " + id + " is already booked");
        }
    }
}
