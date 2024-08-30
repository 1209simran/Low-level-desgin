package model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private String buyerName;
    private List<Auction> auctions;

    public Buyer(String buyerName) {
        this.buyerName = buyerName;
        this.auctions = new ArrayList<>();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }
}
