package com.so.leetcode;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-06 16:35
 * @tag
 * @link <a href=""></a>
 **/
public class Q1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 创建一个 (m+1) x (n+1) 的二维数组
        //**dp 数组的含义**：
        //
        //dp[i][j] 表示 text1 的前 i 个字符与 text2 的前 j 个字符的最长公共子序列的长度。
        //注意：i 和 j 的范围是从 0 到 m 和 0 到 n，其中 0 表示空字符串。
        //
        //**为什么是 (m+1) x (n+1)**：
        //
        //为了方便处理边界情况，即当其中一个字符串为空时，最长公共子序列的长度为 0。
        //这样，dp[0][j] 和 dp[i][0] 都初始化为 0，无需额外赋值。
        int[][] dp = new int[m + 1][n + 1];

        //i 从 1 到 m，表示 text1 的前 i 个字符。
        for (int i = 1; i <= m; i++) {
            // j 从 1 到 n，表示 text2 的前 j 个字符。
            for (int j = 1; j <= n; j++) {
                // 在每次循环中，根据 text1 的第 i-1 个字符和 text2 的第 j-1 个字符是否相等，进行不同的处理
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 如果这两个字符相等，说明它们可以加入到当前的最长公共子序列中。
                    //因此，dp[i][j] 的值等于 dp[i-1][j-1]（即不包括这两个字符时的最长公共子序列长度）加 1。
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //如果 text1.charAt(i - 1) 和 text2.charAt(j - 1) 不相等，那么当前字符不能同时加入到最长公共子序列中。
                    //因此，dp[i][j] 的值取以下两种情况的最大值：
                    //dp[i - 1][j]：不包含 text1 的第 i 个字符，只考虑 text1 的前 i-1 个字符与 text2 的前 j 个字符的最长公共子序列长度。
                    //dp[i][j - 1]：不包含 text2 的第 j 个字符，只考虑 text1 的前 i 个字符与 text2 的前 j-1 个字符的最长公共子序列长度。
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 返回最终结果
        return dp[m][n];
    }
}
