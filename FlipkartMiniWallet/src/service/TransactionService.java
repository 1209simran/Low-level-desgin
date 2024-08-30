package service;

import comparators.AmountBasedComparator;
import comparators.TimeBasedComparator;
import dao.TransactionDao;
import enums.SortingType;
import enums.TransactionType;
import model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    private final TransactionDao  transactionDao;

    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public List<Transaction> getTransactions(String user, String filter, String sorter){
        List<Transaction> allTransactions =  transactionDao.getTransactions(user);
        List<Transaction> filteredTransactions = new ArrayList<>();

        if(allTransactions==null)
            return filteredTransactions;
        if(filter.equals(TransactionType.SEND.toString())) {
            List<Transaction> allSendTransactions = allTransactions.stream().filter(transaction ->
                transaction.getTransactionType().equals(TransactionType.SEND)).collect(Collectors.toList());
            if(sorter.equals(SortingType.AMOUNT.toString()))
            {
                allSendTransactions.sort(new AmountBasedComparator());
                filteredTransactions = allTransactions;
            }
            else if(sorter.equals(SortingType.TIME.toString()))
                {
                    allSendTransactions.sort(new TimeBasedComparator());
                    filteredTransactions = allTransactions;
                }
            }
        else{
            if(filter.equals(TransactionType.RECIEVE.toString())) {
                List<Transaction> allRecieveTransactions = allTransactions.stream().filter(transaction ->
                        transaction.getTransactionType().equals(TransactionType.SEND)).collect(Collectors.toList());
            if(sorter.equals(SortingType.AMOUNT.toString()))
            {
                allRecieveTransactions.sort(new AmountBasedComparator());
                filteredTransactions = allTransactions;
            }
            else if(sorter.equals(SortingType.TIME.toString()))
            {
                allRecieveTransactions.sort(new TimeBasedComparator());
                filteredTransactions = allTransactions;
            }
        }}
        for(Transaction t : filteredTransactions){
            System.out.println(t.getSenderName() + " -> " + t.getReceiverName() + " : " + t.getAmount() + "Rs");
        }
        return  filteredTransactions;
    }


    public void saveTransaction(String sender, String receiver, BigDecimal amount) {
        transactionDao.saveTransaction(sender,receiver,amount);
    }
}
