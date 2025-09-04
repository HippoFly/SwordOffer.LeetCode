package com.so.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 14:58
 **/

public class Q131_PalindromePartitioning {
    public static void main(String[] args) {
        Q131_PalindromePartitioning partitioning = new Q131_PalindromePartitioning();
        System.out.println(partitioning.partition("ABCBB"));
    }

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> currentList = new ArrayList<>();
        backtrack(s, 0, currentList);
        return result;
    }

    /**
     *
     * @param s 待切割的字符串
     * @param start 字符串的起始位置
     * @param currentList 当前分割方案
     */
    private void backtrack(String s, int start, List<String> currentList) {
        // 如果已经遍历完字符串，找到一个有效分割
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList)); // 将当前分割结果加入结果集
            return;
        }

        // 从 start 开始遍历字符串
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end); // 这里其实是从左起，截取左边的子串
            if (isPalindrome(substring)) {  // 如果是回文
                currentList.add(substring);  // 添加到当前分割方案
                backtrack(s, end, currentList);  // 继续回溯
                currentList.remove(currentList.size() - 1);  // 回溯，移除当前子串
            }
        }
    }


    /**
     * 双指针法从首尾 判断是否是回文串
     *
     * @param s 需要判断的字符串
     * @return true，是回文字符串
     */
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
