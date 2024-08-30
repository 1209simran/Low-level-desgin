package vendingStates;

import model.Coin;
import model.Product;
import model.VendingMachine;

import java.util.List;

public class DispenseProductStateImpl implements StateManager {

    public DispenseProductStateImpl() {
        System.out.println("Currently Vending machine is in Product Selection State");
    }

    public DispenseProductStateImpl(VendingMachine machine, int productCode) throws Exception {
        dispenseProduct(machine, productCode);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("insert coin button can not clicked on Dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("product selection button can not be clicked in Dispense state");

    }

    @Override
    public void insertCoins(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("coin can not be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not be chosen in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("change can not returned in Dispense state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public Product dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Product has been dispensed");
        Product product = machine.getInventory().getProduct(productCode);
        machine.getInventory().updateProduct(productCode);
        machine.setVendingMachineState(new IdleStateImpl(machine));
        return product;
    }

}
