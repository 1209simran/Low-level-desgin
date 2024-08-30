package service;

import dao.AuctionDao;
import dao.BuyerDao;
import dao.SellerDao;
import model.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionService {

    private final AuctionDao auctionDao;
    private final BuyerDao buyerDao;
    private final SellerDao sellerDao;

    public AuctionService(AuctionDao auctionDao, BuyerDao buyerDao, SellerDao sellerDao) {
        this.auctionDao = auctionDao;
        this.buyerDao = buyerDao;
        this.sellerDao = sellerDao;
    }

    public void createAuction(String auctionName, String sellerName, int minVal, int maxVal) {
        if (auctionDao.isAuctionExist(auctionName)) {
            System.out.println("Auction: " + auctionName + " already exist.");
            return;
        }
        Auction auction = new Auction(auctionName, minVal, maxVal, sellerName);
        auctionDao.createOrUpdateAuction(auction);
        sellerDao.addAuction(auction);
        System.out.println("Created auction " + auctionName);
    }

    public void createBid(String buyerName, String auctionName, int bidAmt) {
        Auction auction = isValidAuction(buyerName, auctionName);
        if (auction == null)
            return;
        if (!isValidBid(auction, bidAmt)) {
            System.out.println("Bid amount should be in range: " + auction.getMinVal() + " - " + auction.getMaxVal());
            return;
        }
        auction.setBuyerBidMp(buyerName, bidAmt);
        auctionDao.createOrUpdateAuction(auction);
        sellerDao.updateAuction(auction);
        buyerDao.addAuction(auction, buyerName);
        System.out.println("Created bid for " + auctionName + " by " + buyerName + " at " + bidAmt);
    }


    public void updateBid(String buyerName, String auctionName, int bidAmt) {
        Auction auction = isValidAuction(buyerName, auctionName);
        if (auction == null)
            return;
        if (!isValidBid(auction, bidAmt)) {
            System.out.println("Bid amount should be in range: " + auction.getMinVal() + " - " + auction.getMaxVal());
            return;
        }
        auction.setBuyerBidMp(buyerName, bidAmt);
        auctionDao.createOrUpdateAuction(auction);
        sellerDao.updateAuction(auction);
        buyerDao.updateAuction(auction, buyerName);
        System.out.println("Updated bid for " + auctionName + " by " + buyerName + " at " + bidAmt);
    }


    public void withdrawBid(String buyerName, String auctionName) {
        Auction auction = isValidAuction(buyerName, auctionName);
        if (auction == null)
            return;
        auction.removeBidder(buyerName);
        auctionDao.createOrUpdateAuction(auction);
        buyerDao.removeBid(buyerName, auction);
        System.out.println(buyerName + " withdraw from " + auctionName);
    }

    public void closeAuction(String auctionName) {
        if (!auctionDao.isAuctionExist(auctionName)) {
            System.out.println("Auction: " + auctionName + " doesn't exist.");
            return;
        }
        Auction auction = auctionDao.getAuction(auctionName);
        auction.setOpen(false);
        auctionDao.createOrUpdateAuction(auction);
        System.out.println("Closing " + auctionName);
        findWinner(auction);
    }

    private void findWinner(Auction auction) {
        Map<Integer, Integer> bidFreqMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : auction.getBuyerBidMp().entrySet()) {
            if (bidFreqMap.containsKey(entry.getValue()))
                bidFreqMap.put(entry.getValue(), bidFreqMap.get(entry.getValue()) + 1);
            else {
                bidFreqMap.put(entry.getValue(), 1);
            }
        }
        int maxBid = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : bidFreqMap.entrySet()) {
            if (entry.getValue() == 1 && maxBid < entry.getKey()) {
                maxBid = entry.getKey();
            }
        }
        if (maxBid == Integer.MIN_VALUE) {
            System.out.println("No winner found");
            return;
        }
        for (Map.Entry<String, Integer> entry : auction.getBuyerBidMp().entrySet()) {
            if (entry.getValue() == maxBid) {
                System.out.println("Winner is " + entry.getKey());
                break;
            }

        }
    }

    private Auction isValidAuction(String buyerName, String auctionName) {
        if (!auctionDao.isAuctionExist(auctionName)) {
            System.out.println("Auction: " + auctionName + " doesn't exist.");
            return null;
        }
        Auction auction = auctionDao.getAuction(auctionName);
        if (!auction.isOpen()) {
            System.out.println(auctionName + " is closed");
            return null;
        }
        return auction;
    }

    private boolean isValidBid(Auction auction, int bidAmt) {
        return auction.getMinVal() <= bidAmt && auction.getMaxVal() >= bidAmt;
    }
}
