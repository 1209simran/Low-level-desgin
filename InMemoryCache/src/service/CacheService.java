package service;

import dao.CacheDao;
import enums.EvictionPolicy;

public class CacheService {

    private final CacheDao cacheDao;

    public CacheService(CacheDao cacheDao) {
        this.cacheDao = cacheDao;
    }

    public void createCache(int size, String policy) {
        EvictionPolicy evictionPolicy = EvictionPolicy.valueOf(policy);
        cacheDao.createCache(size, evictionPolicy);
        System.out.println("Cache is inititalized with size " + size);
    }

    public void getObject(Object key) {
        Object val = cacheDao.get(key);
        if (val == null) {
            System.out.println("No value found for key: " + key);
            return;
        }
        System.out.println("Value for key: " + key + " is: " + val);
    }

    public void put(Object key, Object value) {
        cacheDao.put(key, value);
    }

    public void remove(Object key) {
        cacheDao.delete(key);
    }

    public void clearCache() {
        cacheDao.clearCache();
    }
}
