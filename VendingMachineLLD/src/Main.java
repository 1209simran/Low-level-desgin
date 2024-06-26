import model.Coin;
import model.Product;
import model.VendingMachine;
import vendingStates.StateManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(5);
        try {

            System.out.println("filling up the inventory");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("clicking on InsertCoinButton");

            StateManager vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoins(vendingMachine, Coin.NICKEL);
            vendingState.insertCoins(vendingMachine, Coin.QUARTER);

            System.out.println("clicking on ProductSelectionButton");

            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 1);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            displayInventory(vendingMachine);
        }

    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Juice", 10.0, 5));
        productList.add(new Product(2, "Coke", 40.0, 5));
        productList.add(new Product(3, "Lays", 5.0, 5));
        productList.add(new Product(4, "Hide & Seek", 20.0, 5));
        vendingMachine.getInventory().setProducts(productList);
    }

    private static void displayInventory(VendingMachine vendingMachine) {

        List<Product> productList = vendingMachine.getInventory().getProducts();
        for (Product product : productList) {

            System.out.println("ProductCode: " + product.getProductCode() +
                    " | Item: " + product.getName() +
                    " | Price: " + product.getPrice() +
                    " | Quantity: " + product.getQuantity());
        }
    }

}