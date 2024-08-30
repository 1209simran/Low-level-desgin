package dao;

import model.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionDao {

    private static AuctionDao auctionDao = null;
    private Map<String, Auction> auctions;

    public AuctionDao() {
        this.auctions = new HashMap<>();
    }

    public static AuctionDao getInstance() {
        if (auctionDao == null)
            auctionDao = new AuctionDao();
        return auctionDao;
    }

    public boolean isAuctionExist(String auctionName) {
        return auctions.containsKey(auctionName);
    }

    public void createOrUpdateAuction(Auction auction) {
        auctions.put(auction.getAuctionName(), auction);
    }

    public Auction getAuction(String auctionName) {
        return auctions.get(auctionName);
    }
}
