package vendingStates;


import model.Coin;
import model.Product;
import model.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleStateImpl implements StateManager {

    public IdleStateImpl() {
        System.out.println("Currently Vending machine is in Idle State");
    }

    public IdleStateImpl(VendingMachine machine) {
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }


    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Cannot insert coin before clicking on insert coin button");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("Cannot choose product when machine in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Cannot get change in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Cannot insert coin before clicking on insert coin button");
    }

    @Override
    public Product dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("Cannot dispense product");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Money has not been inserted");
    }

    @Override
    public void updateInventory(VendingMachine machine, Product product, int productCode) throws Exception {
        machine.getInventory().addProduct(product);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyStateImpl());
    }
}
