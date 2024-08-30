package vendingStates;

import model.Coin;
import model.Product;
import model.VendingMachine;

import java.util.List;

public class ProductSelectionStateImpl implements StateManager {

    public ProductSelectionStateImpl() {
        System.out.println("Currently Vending machine is in Product Selection State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you can not click on insert coin button in Selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoins(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you can not insert Coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        Product product = machine.getInventory().getProduct(productCode);
        double paidByUser = 0.0;
        for (Coin coin : machine.getCoinList()) {
            paidByUser = paidByUser + coin.value;
        }

        if (paidByUser < product.getPrice()) {
            System.out.println("Insufficient Amount, Product you selected is for price: " + product.getPrice()
                    + " and you paid: " + paidByUser);
            refundFullMoney(machine);
            throw new Exception("insufficient amount");
        } else if (paidByUser >= product.getPrice()) {

            if (paidByUser > product.getPrice()) {
                getChange((int) (paidByUser - product.getPrice()));
            }
            machine.setVendingMachineState(new DispenseProductStateImpl(machine, productCode));
        }

    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;
    }

    @Override
    public Product dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("product can not be dispensed in hasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(new IdleStateImpl(machine));
        return machine.getCoinList();

    }

}
