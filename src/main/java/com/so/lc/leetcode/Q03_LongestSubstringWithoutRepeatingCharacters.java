package com.so.lc.leetcode;

import java.util.HashSet;

/**
 * 描述
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/8 17:50
 **/

public class Q03_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Q03_LongestSubstringWithoutRepeatingCharacters characters = new Q03_LongestSubstringWithoutRepeatingCharacters();
        characters.lengthOfLongestSubstring("ABCDDEFGG");
    }

    /**
     * 窗口右 开始右吞字符，不重复一直吞，左边界不动
     * 直到遇到重复字符，由窗口左开始‘吐出来’（吐到这个重复字符没有为止，最坏就是吐完）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                // 比如left=1, right=3 实际上长度是 1,2,3所以求长度+1
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
                //这里已经包含右边界字符，既不加进去，右边界也不再挪
                // 而左边界还需要右挪
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;

    }
}
