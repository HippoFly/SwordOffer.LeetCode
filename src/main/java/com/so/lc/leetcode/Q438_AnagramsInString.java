package com.so.lc.leetcode;

import java.util.ArrayList;
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
    public List<Integer> findAnagrams(String sample, String target) {
        // 输入校验
        if (sample == null || target == null) {
            throw new IllegalArgumentException("Input strings must not be null");
        }

        int sampleLen = sample.length(), targetLen = target.length();

        // 边界条件处理
        if (sampleLen < targetLen || targetLen == 0) {
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();
        int[] sampleHash = new int[26];
        int[] targetHash = new int[26];

        // 初始化目标哈希表，统计目标字符串中每个字母的出现次数
        for (int i = 0; i < targetLen; ++i) {
            ++sampleHash[sample.charAt(i) - 'a'];
            ++targetHash[target.charAt(i) - 'a'];
        }

        // 使用差异字符计数优化性能
        diffCount = 0;
        for (int i = 0; i < 26; ++i) {
            if (sampleHash[i] != targetHash[i]) {
                diffCount++;
            }
        }

        // 判断初始窗口是否匹配
        if (diffCount == 0) {
            answer.add(0);
        }

        // 滑动窗口
        for (int i = 0; i < sampleLen - targetLen; ++i) {
            // 依次从sample左到右移动，取出单个字符，对比字符哈希
            // 左字符哈希数组索引
            int leftCharIndex = sample.charAt(i) - 'a';
            // 加上sample长度的右字符
            int rightCharIndex = sample.charAt(i + targetLen) - 'a';

            // 更新窗口左端字符  （窗口左移除1，从数组第leftCharIndex个减去左字符的1一个字符）
            updateCharacterCount(sampleHash, leftCharIndex, -1, targetHash);
            // 更新窗口右端字符  （窗口右加一，）
            updateCharacterCount(sampleHash, rightCharIndex, 1, targetHash);

            // 如果差异字符数为0，说明当前窗口匹配
            if (diffCount == 0) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    /**
     * 更新字符计数并调整差异字符计数
     * @param sampleHash 样本字符哈希表
     * @param charIndex 字符索引
     * @param increment 增量（+1 或 -1）
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

