package com.so.lc.Hash;

import java.util.*;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 15:05
 **/

public class Q49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String hash = getHash(s);
            // Map的key为Hash  Value为List
            if(map.containsKey(hash)) {
                List<String> strings = map.get(hash);
                strings.add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(hash, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 只区分字符组成 不区分字符排序的Hash
     * @param s
     * @return
     */
    public static String getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i : hash) {
            res.append(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(getHash("ted"));
        System.out.println(getHash("det"));
    }
}
