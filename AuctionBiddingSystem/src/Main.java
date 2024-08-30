import dao.AuctionDao;
import dao.BuyerDao;
import dao.SellerDao;
import service.AuctionService;
import service.BuyerService;
import service.SellerService;


public class Main {
    public static void main(String[] args) {
        BuyerDao buyerDao = BuyerDao.getInstance();
        SellerDao sellerDao = SellerDao.getInstance();
        AuctionDao auctionDao = AuctionDao.getInstance();

        BuyerService buyerService = new BuyerService(buyerDao);
        SellerService sellerService = new SellerService(sellerDao);
        AuctionService auctionService = new AuctionService(auctionDao, buyerDao, sellerDao);

        buyerService.addBuyer("Buyer1");
        buyerService.addBuyer("Buyer2");
        buyerService.addBuyer("Buyer3");
        buyerService.addBuyer("Buyer4");
        buyerService.addBuyer("Buyer5");

        sellerService.addSeller("Seller1");

        auctionService.createAuction("Auction1", "Seller1", 15, 50);
        auctionService.createAuction("Auction2", "Seller1", 45, 100);

        auctionService.createBid("Buyer1", "Auction1", 40);
        auctionService.createBid("Buyer1", "Auction2", 10);
        auctionService.createBid("Buyer2", "Auction1", 50);
        auctionService.createBid("Buyer3", "Auction1", 50);
        auctionService.createBid("Buyer4", "Auction1", 30);
        auctionService.createBid("Buyer5", "Auction1", 20);

        auctionService.updateBid("Buyer2", "Auction1", 100);
        auctionService.withdrawBid("Buyer1", "Auction1");

        buyerService.viewBiddings("Buyer1");
        sellerService.viewBidders("Seller1");

        auctionService.closeAuction("Auction1");
    }
}