package vendingStates;

import model.Coin;
import model.Product;
import model.VendingMachine;

import java.util.List;

public interface StateManager {

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    public void insertCoins(VendingMachine vendingMachine, Coin coin) throws Exception;

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;

    public void chooseProduct(VendingMachine machine, int productCode) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Product dispenseProduct(VendingMachine machine, int productCode) throws Exception;

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;

}
