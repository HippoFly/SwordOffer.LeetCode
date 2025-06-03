package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * <p>
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * <p>
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-03 14:43
 * @tag
 * @link <a href=""></a>
 **/
public class Q763_PartitionLabels {

    /**
     *
     * 以 "ababcbacadefegdehijhklij" 为例：
     *
     * 扫一遍，记录每个字母的最后位置，例如：
     * 'a' 最后在 8，'b' 最后在 5，'c' 最后在 7，…
     * 从左到右扫描：
     * 起点 start = 0，每次更新 end = max(end, 最后出现位置)
     * 扫到 i == end（说明当前片段包含所有出现过的字符）→ 切片
     *
     * @param s 输入的字符串
     * @return 返回一个整数列表，表示每个分区的长度
     */
    public List<Integer> partitionLabels(String s) {
        // 记录每个字符最后出现的位置
        int[] lastOccurrence = new int[26];

        // 遍历字符串，更新每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            // 制作类似26个字母的Hash表
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        // 再次遍历字符串，根据字符最后出现的位置确定每个分区的起始和结束位置
        for (int i = 0; i < s.length(); i++) {
            // 记住这个取出字符，再从hash表取出重点位置 比较
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            // 当当前位置等于当前分区的结束位置时，计算分区长度并添加到结果列表中
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

}
