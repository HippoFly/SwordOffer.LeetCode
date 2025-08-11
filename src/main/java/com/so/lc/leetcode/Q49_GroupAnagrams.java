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
        // 创建一个哈希表，键是排序后的字符串，值是对应的异位词列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历输入数组中的每个字符串
        for (String s : strs) {
            // 将字符串转换为字符数组，方便排序
            char[] chars = s.toCharArray();

            // 对字符数组进行排序，异位词排序后会得到相同的字符序列
            Arrays.sort(chars);

            // 将排序后的字符数组转换回字符串，作为哈希表的键
            String key = new String(chars);

            // 如果哈希表中还没有这个键，就创建一个新的列表
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // 将当前字符串添加到对应键的列表中
            map.get(key).add(s);
        }

        // 将哈希表中的所有值(即分组后的异位词列表)转换为List返回
        return new ArrayList<>(map.values());
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
            System.out.println("String: " + str + " -> Hash: " );
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
