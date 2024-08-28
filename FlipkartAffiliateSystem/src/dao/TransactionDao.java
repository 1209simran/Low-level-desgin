package dao;

import model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionDao {
    private static TransactionDao transactionDao;
    private HashMap<String, Transaction> transactions;
    private HashMap<String, List<Transaction>> transactionsByAffiliateid;

    public TransactionDao() {
        this.transactions = new HashMap<>();
        this.transactionsByAffiliateid = new HashMap<>();
    }

    public static TransactionDao getInstance() {
        if (transactionDao == null)
            transactionDao = new TransactionDao();
        return transactionDao;
    }

    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionId(), transaction);
        List<Transaction> transactionByAff = new ArrayList<>();
        if (transactionsByAffiliateid.containsKey(transaction.getAffiliateId()))
            transactionByAff = transactionsByAffiliateid.get(transaction.getAffiliateId());
        transactionByAff.add(transaction);
        transactionsByAffiliateid.put(transaction.getAffiliateId(), transactionByAff);
    }

    public boolean isAffiliateTransactionExists(String affId) {
        return transactionsByAffiliateid.containsKey(affId);
    }

    public List<Transaction> getTransactionByAffiliateId(String affId) {
        return transactionsByAffiliateid.get(affId);
    }
}
