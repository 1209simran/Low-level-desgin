import dao.TransactionDao;
import dao.UserDao;
import dao.WalletDao;
import service.TransactionService;
import service.UserService;
import service.WalletService;

import java.math.BigDecimal;

public class MiniWallet {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        WalletDao walletDao = new WalletDao();
        TransactionDao transactionDao = new TransactionDao();
        UserService userSevice = new UserService(userDao);
        TransactionService transactionService = new TransactionService(transactionDao);
        WalletService walletService = new WalletService(walletDao, transactionService);


        walletService.fetchBalance("Bob");
        userSevice.registerUser("Bob");
        walletService.topUpWallet("Bob", "CC", BigDecimal.valueOf(1000));
        walletService.topUpWallet("Bob", "UPI", BigDecimal.valueOf(100));
        walletService.fetchBalance("Bob");
        userSevice.registerUser("Alice");
        walletService.topUpWallet("Alice", "CC", BigDecimal.valueOf(100));
        walletService.fetchBalance("Alice");
        walletService.sendMoney("Bob", "Alice", BigDecimal.valueOf(1250));
        walletService.sendMoney("Bob", "Alice", BigDecimal.valueOf(250));
        walletService.sendMoney("Alice", "Bob", BigDecimal.valueOf(50));
        walletService.fetchBalance("Bob");
        walletService.fetchBalance("Alice");
        transactionService.getTransactions("Bob", "SEND", "AMOUNT");
        transactionService.getTransactions("Bob", "RECIEVE", "TIME");

    }
}