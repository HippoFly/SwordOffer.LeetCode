package com.so.lc.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 15:28
 **/

public class Q146_LRUCache {

    LinkedHashMap<Integer, Integer> cache ;

    Integer cap = 0;
    public Q146_LRUCache(int capacity) {
        cap = capacity;
        //使用 LinkedHashMap 的构造函数，参数 (capacity, 1.0F, true) 表示按访问顺序排序。
        //覆写 removeEldestEntry 方法，当缓存大小超过容量时移除最旧的条目。

        //当 true 时，LinkedHashMap 按照最近访问顺序排列键值对，最近被访问（读取或写入）的条目会移动到链表尾部，最久未被访问的条目位于链表头部。
        //如果是 false，则按照插入顺序（insertion-order）维护链表顺序，即键值对的顺序与插入时的顺序一致。
        cache = new LinkedHashMap<Integer,Integer>(capacity,1.0F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                //参数 Map.Entry eldest 表示链表中最旧的条目（即最长时间未被访问或插入的键值对）。
                //方法返回值为布尔类型，当返回 true 时，会移除链表中最旧的条目
                return size()>capacity;
            }
        };
    }



    public int get(int key) {
        //如果key存在，则返回对应的值；如果不存在，则返回-1。
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    /**
     * 1. 为什么需要两种数据结构？
     * HashMap：存放 key → 节点 的映射，保证 get/put 查找是 O(1)。
     * 双向链表：存放缓存的实际数据，维护 使用顺序：
     * 链表头：最近使用的节点（Most Recently Used）
     * 链表尾：最久未使用的节点（Least Recently Used）
     * 当容量满时，要删除尾节点
     * 这样一组合，就能同时满足：
     *
     * O(1) 查找
     *
     * O(1) 插入、删除、移动节点
     *
     * 🔹2. 关键操作
     *
     * get(key)
     * 如果不存在，返回 -1
     * 如果存在：
     * 从 HashMap 拿到节点
     * 把该节点移动到链表头（最近使用）
     * 返回值
     *
     * put(key, value)
     * 如果 key 已存在：
     * 更新值
     * 移动到链表头
     *
     * 如果 key 不存在：
     * 新建节点，插入到链表头
     * 如果超过容量：
     *
     * 删除链表尾节点（最久未使用的）
     * 同时在 HashMap 里删除
     * @param args
     */
    public static void main(String[] args) {
        Q146_LRUCache lruCache = new Q146_LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(lruCache.get(2)); // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(lruCache.get(1)); // 返回 -1 (未找到)
        System.out.println(lruCache.get(3)); // 返回 3
        System.out.println(lruCache.get(4)); // 返回 4

    }
}
