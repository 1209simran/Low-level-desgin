package model;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private String sellerName;
    private List<Auction> auctions;

    public Seller(String sellerName) {
        this.sellerName = sellerName;
        this.auctions = new ArrayList<>();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }
}
