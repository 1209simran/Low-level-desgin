package model;

import vendingStates.IdleStateImpl;
import vendingStates.StateManager;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private StateManager stateManager;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine(int inventorySize) {
        this.inventory = new Inventory(inventorySize);
        this.coinList = new ArrayList<>();
        this.stateManager = new IdleStateImpl();
    }

    public void addCoins(Coin coin) {
        System.out.println("Adding coin");
        coinList.add(coin);
    }

    public StateManager getVendingMachineState() {
        return stateManager;
    }

    public void setVendingMachineState(StateManager vendingMachineState) {
        this.stateManager = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }


}
