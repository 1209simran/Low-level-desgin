package service;

import dao.MenuDao;
import model.Menu;
import model.Restaurant;

public class MenuService {

    private final MenuDao menuDao;
    private Restaurant restaurant;

    public MenuService(MenuDao menuDao, RestaurantService restaurantService) {
        this.menuDao = menuDao;
        this.restaurant = restaurantService.getRestaturant();
    }

    public Menu getMenu() {
        restaurant.getMenu().getItems().forEach(item -> {
            System.out.println("Item -> " + item.getItemName() + " , price ->" + item.getPrice());
        });
        return restaurant.getMenu();
    }
}
