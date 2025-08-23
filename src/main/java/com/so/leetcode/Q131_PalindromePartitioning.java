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
        System.out.println(partitioning.partition("AAABB"));
    }

    private String string;
    private List<List<String>> result = new ArrayList<>();
    private List<String> currentPartition = new ArrayList<>();

    public List<List<String>> partition(String s) {
        string = s;

        backtrack(0);
        return result;
    }

    private void backtrack(int start) {
        // 所有字符都已分割完，添加当前分割方案到结果中
        if (start == string.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // 尝试所有可能的分割位置
        for (int i = start; i < string.length(); i++) {
            String subStr = string.substring(start, i + 1);

            // 如果当前子串是回文，加入当前路径
            if (isPalindrome(subStr)) {
                currentPartition.add(subStr);
                backtrack(i + 1);  // 继续递归分割后面的字符
                currentPartition.remove(currentPartition.size() - 1);  // 回溯
            }
        }
    }

    // 双指针法判断是否是回文串
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
