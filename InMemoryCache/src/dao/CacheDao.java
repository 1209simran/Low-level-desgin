package dao;

import enums.EvictionPolicy;
import model.Cache;

public class CacheDao {

    private static CacheDao cacheDao = null;
    private Cache cache = null;

    public static CacheDao getInstance() {
        if (cacheDao == null)
            cacheDao = new CacheDao();
        return cacheDao;
    }

    public void createCache(int size, EvictionPolicy evictionPolicy) {
        cache = new Cache(size, evictionPolicy);
    }

    public Object get(Object key) {
        if (cache != null) {
            if (!cache.getHashMap().containsKey(key))
                return null;
            Object val = cache.getHashMap().get(key);
            cache.getCacheList().remove(key);
            cache.getCacheList().addFirst(key);
            return val;
        }
        return null;
    }

    public void put(Object key, Object val) {
        if (cache != null) {
            if (cache.getCacheList().size() == cache.getSize()) {
                Object lastKey = cache.getCacheList().removeLast();
                cache.getHashMap().remove(lastKey);
            }
            cache.getCacheList().remove(key);
            cache.getCacheList().addFirst(key);
            cache.getHashMap().put(key, val);
            System.out.println("Added key: " + key + " with value: " + val + " to the cache");
            return;
        }
        System.out.println("Unable to add key: " + key + " in the cache");
    }

    public void delete(Object key) {
        if (cache != null) {
            if (cache.getHashMap().containsKey(key)) {
                cache.getCacheList().remove(key);
                cache.getHashMap().remove(key);
                System.out.println("Deleted key: " + key + " from the cache");
                return;
            }
        }
        System.out.println("Unable to delete key: " + key + " from the cache");
    }

    public void clearCache() {
        cache.clear();
        System.out.println("Cleared the cache");
    }
}
