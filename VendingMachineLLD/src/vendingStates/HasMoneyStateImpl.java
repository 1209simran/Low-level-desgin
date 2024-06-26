package vendingStates;


import model.Coin;
import model.Product;
import model.VendingMachine;

import java.util.List;

public class HasMoneyStateImpl implements StateManager {


    public HasMoneyStateImpl() {
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.addCoins(coin);
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new ProductSelectionStateImpl());
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("you need to click on start product selection button first");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can not get change in hasMoney state");
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

    @Override
    public void updateInventory(VendingMachine machine, Product product, int productCode) throws Exception {
        throw new Exception("you can not update inventory in hasMoney  state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }
}
