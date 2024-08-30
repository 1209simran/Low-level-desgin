package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String restaurantName;
    private int numOfTables;
    private Menu menu;
    private List<Table> table;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        this.table = new ArrayList<>();
        this.menu = new Menu();
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getNumOfTables() {
        return numOfTables;
    }

    public void setNumOfTables(int numOfTables) {
        this.numOfTables = numOfTables;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }

    public void addTable(Table table) {
        this.table.add(table);
        setNumOfTables(numOfTables + 1);
    }

}
