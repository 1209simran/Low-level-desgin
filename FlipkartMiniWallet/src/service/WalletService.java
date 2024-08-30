package service;

import dao.TransactionDao;
import dao.provider.CreditCardDaoImpl;
import dao.provider.DebitCardDaoImpl;
import dao.provider.ProviderDao;
import dao.WalletDao;
import dao.provider.UPIDaoImpl;
import enums.ProviderType;

import java.math.BigDecimal;

public class WalletService {
    private final WalletDao walletDao;
    private final TransactionService transactionService;

    public WalletService(WalletDao walletDao, TransactionService transactionService) {
        this.walletDao = walletDao;
        this.transactionService = transactionService;
    }

    public boolean topUpWallet(String user, String providerType, BigDecimal amount){
        if(amount.compareTo(BigDecimal.valueOf(0)) <= 0)
        {
            System.out.println("Amount should be greater than 0");
            return false;
        }
        ProviderDao providerDao = null;
        if(providerType.equals(ProviderType.CC.toString()))
             providerDao = new CreditCardDaoImpl();
        else if(providerType.equals(ProviderType.DC.toString()))
            providerDao = new DebitCardDaoImpl();
        else if (providerType.equals(ProviderType.UPI.toString()))
            providerDao = new UPIDaoImpl();
        else{
            System.out.println("Provider type doesn't match. Try with different payment method");
        }
        if(providerDao!=null)
        {
            boolean checkBal = providerDao.checkBalance(user, amount);
            if(!checkBal)
            {
                System.out.println(user+ " has insufficient balance for top up");
                return false;
            }
            walletDao.topUp(user, amount);
            System.out.println(user+ "'s wallet has credit with "+amount+" Rs successfully");
        }
        return true;
    }
    public BigDecimal fetchBalance(String user){
        return walletDao.fetchBalance(user);
    }

    public boolean sendMoney(String sender, String receiver, BigDecimal amount){
        if(amount.compareTo(BigDecimal.valueOf(0)) <= 0)
        {
            System.out.println("Amount should be greater than 0");
            return false;
        }
        if(fetchBalance(sender).compareTo(amount)>0){
            boolean isMoneySent = walletDao.sendMoney(sender, receiver, amount);
            if(isMoneySent){
                transactionService.saveTransaction(sender,receiver,amount);
                return true;
            }
            return  false;
        }else{
            System.out.println(sender + " doesn't have sufficient amount to transfer "+ amount+"Rs");
            return false;
        }
    }
}
