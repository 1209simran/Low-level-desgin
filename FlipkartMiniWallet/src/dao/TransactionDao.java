package dao;

import enums.TransactionType;
import model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionDao {

    private HashMap<String,List<Transaction>> transactionListMp;

    public TransactionDao() {
        this.transactionListMp = new HashMap<>();
    }

    public List<Transaction> getTransactions(String user) {
        if(transactionListMp.containsKey(user)){
            return transactionListMp.get(user);
        }
        return null;
    }

    public void saveTransaction(String sender, String receiver, BigDecimal amount) {
        Transaction senderTransaction = new Transaction();
        Transaction recieverTransaction = new Transaction();
        senderTransaction.setSenderName(sender);
        senderTransaction.setReceiverName(receiver);
        senderTransaction.setAmount(amount);
        senderTransaction.setTransactionType(TransactionType.SEND);
        senderTransaction.setTimeOfTransaction(LocalDateTime.now());

        recieverTransaction.setSenderName(sender);
        recieverTransaction.setReceiverName(receiver);
        recieverTransaction.setAmount(amount);
        recieverTransaction.setTransactionType(TransactionType.RECIEVE);
        recieverTransaction.setTimeOfTransaction(LocalDateTime.now());

        if(transactionListMp.containsKey(sender)){
            transactionListMp.get(sender).add(senderTransaction);
        }
        else {
            List<Transaction> trans = new ArrayList<>();
            trans.add(senderTransaction);
            transactionListMp.put(sender, trans);
        }

        if(transactionListMp.containsKey(receiver)){
            transactionListMp.get(receiver).add(recieverTransaction);
        }
        else {
            List<Transaction> trans = new ArrayList<>();
            trans.add(recieverTransaction);
            transactionListMp.put(receiver, trans);
        }

    }
}
