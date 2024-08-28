import dao.*;
import service.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductDao productDao = ProductDao.getInstance();
        CategoryCommissionDao categoryCommissionDao = CategoryCommissionDao.getInstance();
        AffiliateDao affiliateDao = AffiliateDao.getInstance();
        OrderDao orderDao = OrderDao.getInstance();
        TransactionDao transactionDao = TransactionDao.getInstance();

        ProductService productService = new ProductService(productDao);
        CategoryCommissionService categoryCommissionService = new CategoryCommissionService(categoryCommissionDao);
        AffiliateService affiliateService = new AffiliateService(affiliateDao);
        TransactionService transactionService = new TransactionService(transactionDao);
        OrderService orderService = new OrderService(orderDao, categoryCommissionService, affiliateService, transactionService);

        productService.addProduct("p1", "Samsung Galaxy", "MOBILES");
        productService.addProduct("p2", "Sofa", "FURNITURE");

        categoryCommissionService.addCommission("MOBILES", "PERCENTAGE", 10.0, null, 1000.0);
        categoryCommissionService.addCommission("FURNITURE", "FLAT_RATE", null, 1000.0, null);

        affiliateService.addAffiliate("af1", "af1");

        orderService.addOrder("order1", 600.00, "p1", "MOBILES", "af1", "CREATED", "2024-05-05 11:11:11");
        orderService.updateOrder("order1", "DISPATCHED");
        orderService.updateOrder("order1", "DELIVERED");
        orderService.updateOrder("order1", "RETURN_PERIOD_EXPIRED");

        orderService.addOrder("order2", 600.00, "p2", "FURNITURE", "af1", "CREATED", "2024-05-05 11:11:11");
        orderService.updateOrder("order2", "DISPATCHED");
        orderService.updateOrder("order2", "DELIVERED");
        orderService.updateOrder("order2", "RETURN_PERIOD_EXPIRED");

        orderService.addOrder("order3", 600.00, "p3", "MOBILES", "af1", "CREATED", "2024-05-15 11:11:11");

        transactionService.getTransactionByAffiliateId("af1");
        orderService.getOrdersByAffiliateAndStatus("af1", "CREATED");


    }
}