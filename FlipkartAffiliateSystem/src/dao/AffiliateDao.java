package dao;

import model.Affiliate;

import java.util.HashMap;

public class AffiliateDao {

    private static AffiliateDao affiliateDao = null;
    private HashMap<String, Affiliate> affiliates;

    public AffiliateDao() {
        this.affiliates = new HashMap<>();
    }

    public static AffiliateDao getInstance() {
        if (affiliateDao == null)
            affiliateDao = new AffiliateDao();
        return affiliateDao;
    }

    public boolean isAffiliateExists(String id) {
        return affiliates.containsKey(id);
    }

    public void addAffiliate(Affiliate affiliate) {
        affiliates.put(affiliate.getId(), affiliate);
    }

    public Affiliate getAffiliate(String id) {
        return affiliates.get(id);
    }

    public void updateAffiliateCommission(String id, double commission) {
        Affiliate affiliate = getAffiliate(id);
        affiliate.setComissionAmountTillDate(affiliate.getComissionAmountTillDate() + commission);
    }

    public void updateAffiliatePaidCommission(String id, double commission) {
        Affiliate affiliate = getAffiliate(id);
        affiliate.setComissionAmountTillDate(affiliate.getComissionPaidTillDate() + commission);
    }
}
