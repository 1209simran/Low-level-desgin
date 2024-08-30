package dao;

import model.Auction;
import model.Buyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyerDao {

    private static BuyerDao buyerDao = null;
    private Map<String, Buyer> buyerList;
    private Map<String, List<Auction>> buyerAuctionMap;

    public BuyerDao() {
        this.buyerList = new HashMap<>();
        this.buyerAuctionMap = new HashMap<>();
    }

    public static BuyerDao getInstance() {
        if (buyerDao == null)
            buyerDao = new BuyerDao();
        return buyerDao;
    }

    public boolean isBuyerExist(String name) {
        return buyerList.containsKey(name);
    }

    public void addBuyer(Buyer buyer) {
        buyerList.put(buyer.getBuyerName(), buyer);
    }

    public void addAuction(Auction auction, String buyerName) {
        List<Auction> buyerAuctions = new ArrayList<>();
        if (buyerAuctionMap.containsKey(buyerName))
            buyerAuctions = buyerAuctionMap.get(buyerName);
        buyerAuctions.add(auction);
        buyerAuctionMap.put(buyerName, buyerAuctions);
    }

    public List<Auction> getAuctions(String name) {
        return buyerAuctionMap.get(name);
    }

    public void removeBid(String buyerName, Auction auction) {
        List<Auction> buyerAuctions = buyerAuctionMap.get(buyerName);
        buyerAuctions.removeIf(auction1 -> auction1.getAuctionName().equalsIgnoreCase(auction.getAuctionName()));
        if (buyerAuctions.isEmpty())
            buyerAuctionMap.remove(buyerName);
        else
            buyerAuctionMap.put(buyerName, buyerAuctions);

    }

    public void updateAuction(Auction auction, String buyerName) {
        List<Auction> auctions = buyerAuctionMap.get(buyerName);
        if (auctions != null)
            auctions.forEach(auction1 -> {
                if (auction1.getAuctionName().equalsIgnoreCase(auction.getAuctionName()))
                    auction1 = auction;
            });
        buyerAuctionMap.put(buyerName, auctions);
    }

}
