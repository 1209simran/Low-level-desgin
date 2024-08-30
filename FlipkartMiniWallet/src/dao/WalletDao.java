package dao;

import model.Wallet;

import java.math.BigDecimal;
import java.util.HashMap;

public class WalletDao {
    private HashMap<String, Wallet> walletHashMap;

    public WalletDao() {
        this.walletHashMap = new HashMap<>();
    }

    public void topUp(String user, BigDecimal amount) {
        if(walletHashMap.containsKey(user)){
            Wallet userWallet = walletHashMap.get(user);
            BigDecimal currBal = userWallet.getCurrBalance();
            currBal= currBal.add(amount);
            userWallet.setCurrBalance(currBal);
            walletHashMap.put(user, userWallet);
        }
        else{
            Wallet userWallet = new Wallet();
            userWallet.setUser(user);
            userWallet.setCurrBalance(amount);
            walletHashMap.put(user, userWallet);
        }
    }

    public BigDecimal fetchBalance(String user) {
        if(walletHashMap.containsKey(user)) {
            System.out.println(user + "'s wallet has "+walletHashMap.get(user).getCurrBalance()+" Rs amount");
            return walletHashMap.get(user).getCurrBalance();
        }
        System.out.println("User "+user+" is not registered");
        return BigDecimal.valueOf(0);
    }

    public boolean sendMoney(String sender, String receiver, BigDecimal amount) {

        Wallet senderWallet = null;
        Wallet recieverWallet = null;
        if(walletHashMap.containsKey(sender))
            senderWallet = walletHashMap.get(sender);
        if(walletHashMap.containsKey(receiver))
            recieverWallet = walletHashMap.get(receiver);
        if(senderWallet!=null)
        {
            if(recieverWallet!=null)
            {
                recieverWallet.setCurrBalance(recieverWallet.getCurrBalance().add(amount));
            }
            else{
                recieverWallet.setUser(receiver);
                recieverWallet.setCurrBalance(amount);
            }
            walletHashMap.put(receiver, recieverWallet);
            senderWallet.setCurrBalance(senderWallet.getCurrBalance().subtract(amount));
            walletHashMap.put(sender, senderWallet);
            System.out.println(sender +" has transferred "+ amount + "Rs to " + receiver);
            return  true;
        }
        return false;
    }
}
