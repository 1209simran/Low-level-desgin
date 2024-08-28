package service;

import dao.TransactionDao;
import model.Transaction;

import java.util.List;

public class TransactionService {
    private final TransactionDao transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public void addTransaction(Transaction transaction) {
        transactionDao.addTransaction(transaction);
    }

    public void getTransactionByAffiliateId(String affId) {
        if (!transactionDao.isAffiliateTransactionExists(affId)) {
            System.out.println("Transactions for affId -> " + affId + " doesn't exists.");
            return;
        }
        List<Transaction> transactions = transactionDao.getTransactionByAffiliateId(affId);
        transactions.forEach(transaction -> {
            System.out.println("Transaction amount for affiliate id " + affId + " is " + transaction.getTotalAmount());
        });
    }
}
