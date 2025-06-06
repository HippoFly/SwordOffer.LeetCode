package com.so.lc.leetcode;

/**
 *
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-06 15:27
 * @tag
 * @link <a href=""></a>
 **/
public class Q05_LongestPalindromicSubstring {
    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        // 如果输入字符串 s 是 null 或者长度小于 2（即空字符串或只有一个字符），那么它本身就是回文，直接返回 s。
        if (s == null || s.length() < 2) {
            return s;
        }

        // 对于字符串中的每一个字符 s.charAt(i)，我们分别以它为中心尝试扩展出奇数长度和偶数长度的回文子串。
        //
        //expandAroundCenter(s, i, i)：以 i 为中心，向两边扩展，寻找奇数长度的回文（如 "aba"）。
        //expandAroundCenter(s, i, i + 1)：以 i 和 i+1 为中心，向两边扩展，寻找偶数长度的回文（如 "abba"）。
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度的回文
            expandAroundCenter(s, i, i);
            // 偶数长度的回文
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    /**
     * 以 s[left] 和 s[right] 为中心，向两边扩展，寻找回文子串。
     * @param s
     * @param left 左边开始起点
     * @param right 右边开始起点
     */
    private void expandAroundCenter(String s, int left, int right) {
        // 只要满足以下三个条件，就继续向两边扩展：
        //
        // left 没有越界（left >= 0）
        // right 没有越界（right < s.length()）
        // s.charAt(left) 和 s.charAt(right) 相等
        // 每次循环，left 向左移动一位，right 向右移动一位，扩大回文的范围。
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 当 while 循环结束时，left 和 right 已经超出了回文的范围。因此，有效的回文子串的区间是 [left + 1, right - 1]。


        // 回文子串的长度计算为 right - left - 1。这是因为：
        // right - left - 1 实际上是 (right - 1) - (left + 1) + 1 = right - left - 1，即回文子串的字符个数。
        int length = right - left - 1;

        //如果当前找到的回文子串长度 length 大于之前记录的 maxLength，则更新 start 和 maxLength：
        //
        //start = left + 1：新的回文子串的起始位置。
        //maxLength = length：新的最长回文子串的长度。
        if (length > maxLength) {
            start = left + 1;
            maxLength = length;
        }
    }
}
