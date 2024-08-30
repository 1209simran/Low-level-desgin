package dao;

import model.Auction;
import model.Seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDao {

    private static SellerDao sellerDao = null;
    private Map<String, Seller> sellers;
    private Map<String, List<Auction>> sellerAuctionMap;

    public SellerDao() {
        this.sellers = new HashMap<>();
        this.sellerAuctionMap = new HashMap<>();
    }

    public static SellerDao getInstance() {
        if (sellerDao == null)
            sellerDao = new SellerDao();
        return sellerDao;
    }

    public boolean isSellerExist(String name) {
        return sellers.containsKey(name);
    }

    public void addSeller(Seller seller) {
        sellers.put(seller.getSellerName(), seller);
    }

    public void addAuction(Auction auction) {
        List<Auction> sellerAuctions = new ArrayList<>();
        if (sellerAuctionMap.containsKey(auction.getSellerName()))
            sellerAuctions = sellerAuctionMap.get(auction.getSellerName());
        sellerAuctions.add(auction);
        sellerAuctionMap.put(auction.getSellerName(), sellerAuctions);
    }

    public List<Auction> getAuctions(String name) {
        return sellerAuctionMap.get(name);
    }

    public void updateAuction(Auction auction) {
        List<Auction> auctions = sellerAuctionMap.get(auction.getSellerName());
        if (auctions != null)
            auctions.forEach(auction1 -> {
                if (auction1.getAuctionName().equalsIgnoreCase(auction.getAuctionName()))
                    auction1 = auction;
            });
        sellerAuctionMap.put(auction.getSellerName(), auctions);
    }
    
}
