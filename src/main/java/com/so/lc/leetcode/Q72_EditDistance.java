package com.so.lc.leetcode;

/**
 *
 * 72. 编辑距离
 *
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-06 21:30
 * @tag
 * @link <a href=""></a>
 **/
public class Q72_EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 创建 dp 数组
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界情况
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 填充 dp 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]), // 删除、插入
                            dp[i - 1][j - 1] // 替换
                    );
                }
            }
        }

        return dp[m][n]; // 返回最终结果
    }

    // 主函数用于测试
    public static void main(String[] args) {
        Q72_EditDistance solution = new Q72_EditDistance();

        // 示例 1
        System.out.println(solution.minDistance("horse", "ros")); // 输出: 3

        // 示例 2
        System.out.println(solution.minDistance("intention", "execution")); // 输出: 5
    }
}
