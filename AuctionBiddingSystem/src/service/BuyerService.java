package service;

import dao.BuyerDao;
import model.Auction;
import model.Buyer;

import java.util.List;

public class BuyerService {

    private final BuyerDao buyerDao;

    public BuyerService(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    public void addBuyer(String name) {
        if (buyerDao.isBuyerExist(name)) {
            System.out.println(name + " already exist.");
            return;
        }
        Buyer buyer = new Buyer(name);
        buyerDao.addBuyer(buyer);
        System.out.println("Added " + name);
    }

    public void viewBiddings(String name) {
        if (!buyerDao.isBuyerExist(name)) {
            System.out.println(name + " doesn't exist.");
            return;
        }
        List<Auction> auctions = buyerDao.getAuctions(name);
        if (auctions != null) {
            auctions.forEach(auction -> {
                System.out.println("Auction: " + auction.getAuctionName());
                System.out.println("Seller name: " + auction.getSellerName());
                System.out.println("Bid Price: " + auction.getBuyerBidMp().get(name));
                System.out.println();
            });
        }
    }
}
