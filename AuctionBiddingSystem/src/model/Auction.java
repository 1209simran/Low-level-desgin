package model;

import java.util.HashMap;
import java.util.Map;

public class Auction {

    private String auctionName;
    private int minVal;
    private int maxVal;
    private String sellerName;
    private boolean isOpen;
    private Map<String, Integer> buyerBidMp;

    public Auction(String auctionName, int minVal, int maxVal, String sellerName) {
        this.auctionName = auctionName;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.sellerName = sellerName;
        this.isOpen = true;
        this.buyerBidMp = new HashMap<>();
    }

    public Map<String, Integer> getBuyerBidMp() {
        return buyerBidMp;
    }

    public void setBuyerBidMp(Map<String, Integer> buyerBidMp) {
        this.buyerBidMp = buyerBidMp;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public int getMinVal() {
        return minVal;
    }

    public void setMinVal(int minVal) {
        this.minVal = minVal;
    }

    public int getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(int maxVal) {
        this.maxVal = maxVal;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setBuyerBidMp(String buyerName, int bidAmt) {
        this.getBuyerBidMp().put(buyerName, bidAmt);
    }

    public void removeBidder(String buyerName) {
        this.getBuyerBidMp().remove(buyerName);
    }
}
