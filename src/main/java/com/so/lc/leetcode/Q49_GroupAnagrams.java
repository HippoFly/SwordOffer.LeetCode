package com.so.lc.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是 组成字母相同排列不同的单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 15:05
 * @tag 哈希表
 * @link <a href="https://leetcode.cn/problems/group-anagrams/">LeetCode Group Anagrams</a>
 **/

public class Q49_GroupAnagrams {

    /**
     * 将一组字符串按照字谜（anagram）分组
     * 字谜是指两个或多个字符串，它们包含的字符种类和数量相同，但字符的顺序可能不同
     * 例如，"listen"和"silent"是字谜
     *
     * @param strs 输入的字符串数组
     * @return 返回一个列表的列表，其中每个内部列表都包含一组字谜字符串
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 使用HashMap来存储分组结果，
        // 其中key是字符串的哈希值，value是具有相同哈希值的字符串列表
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 对每个字符串计算一个唯一的哈希值，以便将字谜映射到相同的哈希值
            String hash = getHash(s);
            // 如果map中已经存在该哈希值作为key，则获取对应的字符串列表，并将当前字符串添加到列表中
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
     * 计算字符串的哈希值
     * 该方法通过对字符串中的每个字符进行排序来生成一个唯一的哈希值
     * 这样，所有字谜字符串将生成相同的哈希值
     *
     * @param string 输入的字符串
     * @return 返回字符串的哈希值
     */
    public static String getHash(String string) {
        int[] hashArray = new int[26];
        for (int i = 0; i < string.length(); i++) {
            hashArray[string.charAt(i) - 'a']++;
        }
        String string1 = Arrays.toString(hashArray);
        return string1;
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
        // 测试用例：包含多个字母异位词的字符串数组
        String[] testStrings = {"listen", "silent", "enlist", "google", "gooegl", "rat", "tar", "art", "evil", "vile", "live", "veil"};

        // 打印每个字符串的哈希值
        for (String str : testStrings) {
            System.out.println("String: " + str + " -> Hash: " + getHash(str));
        }

        // 使用 groupAnagrams 方法对字符串数组进行分组
        List<List<String>> groupedAnagrams = groupAnagrams(testStrings);

        // 打印分组结果
        System.out.println("Grouped Anagrams:");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
