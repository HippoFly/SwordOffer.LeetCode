package com.so.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 16:07
 * @tag 滑动窗口
 * @see <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">字母异位词</a>
 **/
public class Q438_AnagramsInString {
    private int diffCount;

    /**
     * 滑动窗口解法
     * @param sample 样本字符串
     * @param target 模板字符串
     * @return 符合的数组
     */
    /**
     * 简化版滑动窗口解法
     *
     * @param sample 样本字符串
     * @param target 模板字符串
     * @return 符合的数组
     */
    public List<Integer> findAnagrams(String sample, String target) {


        int sampleLen = sample.length(), targetLen = target.length();
        if (sampleLen < targetLen || targetLen == 0) {
            return new ArrayList<>();
        }
        // 初始化样本哈希表
        List<Integer> answer = new ArrayList<>();
        int[] sampleHash = new int[26];
        int[] targetHash = new int[26];

        // 初始化目标哈希表
        for (int i = 0; i < targetLen; ++i) {
            ++targetHash[target.charAt(i) - 'a'];
        }

        // 滑动窗口
        for (int i = 0; i < sampleLen; ++i) {
            // 添加当前字符到窗口中
            ++sampleHash[sample.charAt(i) - 'a'];

            // 如果窗口大小超过目标字符串长度，移除最左边的字符
            if (i >= targetLen) {
                --sampleHash[sample.charAt(i - targetLen) - 'a'];
            }

            // 比较两个哈希表是否相等
            if (Arrays.equals(sampleHash, targetHash)) {
                answer.add(i - targetLen + 1);
            }
        }

        return answer;
    }


    /**
     * 更新字符计数并调整差异字符计数
     *
     * @param sampleHash 样本字符哈希表
     * @param charIndex  字符索引
     * @param increment  增量（+1 或 -1）
     * @param targetHash 目标字符哈希表
     */
    private void updateCharacterCount(int[] sampleHash, int charIndex, int increment, int[] targetHash) {
        //
        int oldCount = sampleHash[charIndex];
        sampleHash[charIndex] += increment;
        int newCount = sampleHash[charIndex];

        // 1. 如果旧的字符计数 `oldCount` 不等于目标哈希表中的值，而新的字符计数 `newCount` 等于目标哈希表中的值，则减少差异字符计数 `diffCount`。
        if (oldCount != targetHash[charIndex] && newCount == targetHash[charIndex]) {
            diffCount--;
            // 2. 如果旧的字符计数 `oldCount` 等于目标哈希表中的值，而新的字符计数 `newCount` 不等于目标哈希表中的值，则增加差异字符计数 `diffCount`。
        } else if (oldCount == targetHash[charIndex] && newCount != targetHash[charIndex]) {
            diffCount++;
        }
    }

    public static void main(String[] args) {
        Q438_AnagramsInString solution = new Q438_AnagramsInString();
        System.out.println(solution.findAnagrams("abckabc", "abc"));
    }
}

