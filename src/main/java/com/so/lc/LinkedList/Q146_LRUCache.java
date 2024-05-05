package com.so.lc.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 15:28
 **/

public class Q146_LRUCache {

    public static void main(String[] args) {
        Q146_LRUCache lruCache = new Q146_LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(1));
    }

    public Q146_LRUCache(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<Integer,Integer>(capacity,1.0F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
    }

    LinkedHashMap<Integer, Integer> cache ;
    Integer cap = 0;

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
