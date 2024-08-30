package service;

import dao.SellerDao;
import model.Auction;
import model.Seller;

import java.util.List;
import java.util.Map;

public class SellerService {

    private final SellerDao sellerDao;

    public SellerService(SellerDao sellerDao) {
        this.sellerDao = sellerDao;
    }

    public void addSeller(String name) {
        if (sellerDao.isSellerExist(name)) {
            System.out.println(name + " already exist.");
            return;
        }
        Seller seller = new Seller(name);
        sellerDao.addSeller(seller);
        System.out.println("Added " + name);
    }

    public void viewBidders(String name) {
        if (!sellerDao.isSellerExist(name)) {
            System.out.println(name + " doesn't exist.");
            return;
        }
        List<Auction> auctions = sellerDao.getAuctions(name);
        if (auctions != null) {
            auctions.forEach(auction -> {
                for (Map.Entry<String, Integer> entry : auction.getBuyerBidMp().entrySet()) {
                    System.out.println("Auction: " + auction.getAuctionName());
                    System.out.println("Bidder name: " + entry.getKey());
                    System.out.println("Bid Price: " + entry.getValue());
                    System.out.println();
                }
            });
        }
    }
}
