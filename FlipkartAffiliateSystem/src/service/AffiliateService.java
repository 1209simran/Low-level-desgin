package service;

import dao.AffiliateDao;
import model.Affiliate;

public class AffiliateService {

    private final AffiliateDao affiliateDao;

    public AffiliateService(AffiliateDao affiliateDao) {
        this.affiliateDao = affiliateDao;
    }


    public void addAffiliate(String id, String name) {
        if (affiliateDao.isAffiliateExists(id)) {
            System.out.println("Affiliate -> " + name + " already exists");
            return;
        }
        Affiliate affiliate = new Affiliate(id, name);
        affiliateDao.addAffiliate(affiliate);
        System.out.println("Added affiliate -> " + name);
    }

    public Affiliate getAffiliateById(String id) {
        if (!affiliateDao.isAffiliateExists(id)) {
            System.out.println("Affiliate -> " + id + " doesn't exists");
            return null;
        }
        return affiliateDao.getAffiliate(id);
    }

    public void updateAffiliateCommission(String id, double commission) {
        if (!affiliateDao.isAffiliateExists(id)) {
            System.out.println("Affiliate -> " + id + " doesn't exists");
            return;
        }
        affiliateDao.updateAffiliateCommission(id, commission);
    }

    public void updateAffiliatePaidCommission(String id, double commission) {
        if (!affiliateDao.isAffiliateExists(id)) {
            System.out.println("Affiliate -> " + id + " doesn't exists");
            return;
        }
        affiliateDao.updateAffiliatePaidCommission(id, commission);
    }
}
