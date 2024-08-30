package service;

import dao.RestaurantDao;
import model.Restaurant;

public class RestaurantService {
    private final RestaurantDao restaurantDao;
    private Restaurant restaurant;

    public RestaurantService(RestaurantDao restaurantDao, String name) {
        this.restaurantDao = restaurantDao;
        restaurant = new Restaurant(name);
    }

    public Restaurant getRestaturant() {
        return restaurant;
    }
}
