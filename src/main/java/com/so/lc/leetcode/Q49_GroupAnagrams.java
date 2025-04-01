package com.so.lc.leetcode;

import java.util.*;
import java.util.stream.Collectors;

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
            res.append("|");
            res.append(i);
        }
        return res.toString();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }



    public static void main(String[] args) {
        System.out.println(getHash("ted"));
        System.out.println(getHash("det"));
    }
}
