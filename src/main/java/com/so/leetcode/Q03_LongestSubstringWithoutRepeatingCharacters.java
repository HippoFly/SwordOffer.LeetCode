package com.so.leetcode;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/8 17:50
 * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 * @tag 滑动窗口
 **/

public class Q03_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Q03_LongestSubstringWithoutRepeatingCharacters characters = new Q03_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(characters.lengthOfLongestSubstring("ABCDDEFGG"));
    }

    /**
     * 窗口右 开始右吞字符，不重复一直吞，左边界不动
     * 直到遇到重复字符，由窗口左开始‘吐出来’（吐到这个重复字符没有为止，最坏就是吐完）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 记录窗口内不重复字符的集合
        HashSet<Character> set = new HashSet<>();
        // 窗口的左右边界，均从0开始
        int left = 0; int right = 0;
        int maxLen = 0;

        // 窗口右开始向字符串右边移动，保证不越位
        while (right < s.length()) {
            char curChar = s.charAt(right);

            // 如果不包含当前字符，则添加到集合中，并且窗口右边界右移

            if (!set.contains(curChar)) {
                set.add(curChar);
               // 窗口最大值更新
                maxLen = Math.max(maxLen, right - left + 1);
                right++;

                // 如果包含当前字符，则窗口左边界向右移动，直到不包含当前字符为止

            } else {
                set.remove(s.charAt(left));
                left++;
            }
            // 综合以上if我们发现一旦右边指针遇到重复字符，左边界会向右移动，直到不包含当前字符为止，这个条件判断的else会多次生序
        }

        return maxLen;

    }
}
