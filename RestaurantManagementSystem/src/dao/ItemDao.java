package dao;

import model.Item;
import model.Menu;
import model.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDao {
    private HashMap<String, Item> itemsHashMap;

    public ItemDao() {
        this.itemsHashMap = new HashMap<>();
    }

    public void addItems(Restaurant restaurant, Item item) {
        Menu menu = restaurant.getMenu();
        List<Item> items = menu.getItems();
        items.add(item);
        itemsHashMap.put(item.getItemName(), item);
        menu.setItems(items);
        restaurant.setMenu(menu);
        System.out.println("Item " + item.getItemName() + " added to menu");
    }

    public void removeItem(Restaurant restaurant, String name) {
        if (itemsHashMap.containsKey(name)) {
            itemsHashMap.remove(name);
            List<Item> items = restaurant.getMenu().getItems();
            items.removeIf(item -> item.getItemName().equals(name));
            System.out.println("Item " + name + " removed from menu");
        } else {
            System.out.println("Item " + name + " doesn't exist");
        }
    }

    public void updateItem(Restaurant restaurant, String name, double price) {
        if (itemsHashMap.containsKey(name)) {
            Item item = itemsHashMap.get(name);
            item.setPrice(price);
            itemsHashMap.put(name, item);
            List<Item> items = restaurant.getMenu().getItems();
            items = items.stream()
                    .map(it -> {
                        if (it.getItemName().equals(name)) {
                            it.setPrice(price); // Update condition
                        }
                        return it;
                    })
                    .collect(Collectors.toList());
            System.out.println("Item " + name + " price updated");
        } else {
            System.out.println("Item " + name + " doesn't exist");
        }
    }
}
