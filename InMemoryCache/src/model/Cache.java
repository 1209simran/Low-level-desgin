package model;

import enums.EvictionPolicy;

import java.util.HashMap;
import java.util.LinkedList;

public class Cache {

    private int size;
    private EvictionPolicy evictionPolicy;
    private LinkedList<Object> cacheList;
    private HashMap<Object, Object> hashMap;

    public Cache(int size, EvictionPolicy evictionPolicy) {
        this.size = size;
        this.evictionPolicy = evictionPolicy;
        this.cacheList = new LinkedList<>();
        this.hashMap = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public EvictionPolicy getEvictionPolicy() {
        return evictionPolicy;
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public LinkedList<Object> getCacheList() {
        return cacheList;
    }

    public void setCacheList(LinkedList<Object> cacheList) {
        this.cacheList = cacheList;
    }

    public HashMap<Object, Object> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<Object, Object> hashMap) {
        this.hashMap = hashMap;
    }

    public boolean clear() {
        cacheList = new LinkedList<>();
        hashMap = new HashMap<>();
        return true;
    }
}
