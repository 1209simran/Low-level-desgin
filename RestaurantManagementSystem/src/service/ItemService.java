package service;

import dao.ItemDao;
import enums.ItemCategory;
import enums.ItemType;
import model.Item;
import model.Restaurant;

public class ItemService {
    private static int itemId = 1;
    private final ItemDao itemDao;
    private Restaurant restaurant;

    public ItemService(ItemDao itemDao, RestaurantService restaurantService) {
        this.itemDao = itemDao;
        this.restaurant = restaurantService.getRestaturant();
    }

    public void addItems(String name, String itemType, String itemCat, double price) {
        Item item = new Item();
        item.setId(generateItemId());
        item.setItemName(name);
        item.setItemCategory(ItemCategory.valueOf(itemCat));
        item.setItemType(ItemType.valueOf(itemType));
        item.setPrice(price);
        itemDao.addItems(restaurant, item);
    }

    private int generateItemId() {
        return itemId++;
    }

    public void removeItem(String name) {
        itemDao.removeItem(restaurant, name);
    }

    public void updateItem(String name, double price) {
        itemDao.updateItem(restaurant, name, price);
    }
}
