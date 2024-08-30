import dao.*;
import service.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        RestaurantDao restaurantDao = new RestaurantDao();
        TableDao tableDao = new TableDao();
        ItemDao itemDao = new ItemDao();
        MenuDao menuDao = new MenuDao();

        RestaurantService restaurantService = new RestaurantService(restaurantDao, "Nirwana");
        TableService tableService = new TableService(restaurantService, tableDao);
        AdminService adminService = new AdminService(tableService);
        UserService userService = new UserService(userDao);
        ItemService itemService = new ItemService(itemDao, restaurantService);
        MenuService menuService = new MenuService(menuDao, restaurantService);

        userService.addUser(1, "Admin", true);

        adminService.addTable();

        itemService.addItems("Panner Tikka", "VEG", "STARTER", 250.00);
        itemService.addItems("Chicken Panner Tikka", "NON_VEG", "STARTER", 400.00);
        itemService.addItems("Cold Drink", "VEG", "DESSERT", 20.00);
        itemService.removeItem("Chicken Panner Tikka");
        itemService.updateItem("Cold Drink", 50.00);

        menuService.getMenu();

        tableService.reserveTable(1);
        tableService.reserveTable(1);

//        tableService.allocateTable();
    }
}