package com.so.lc.leetcode;

/**
 *
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 *     说明：每次只能向下或者向右移动一步
 说明：每次只能向下或者向右移动一步
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-05 15:57
 * @tag
 * @link <a href=""></a>
 **/
public class Q64_MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 初始化 DP 数组：dp代表当前到该位置的grid数字之和
        int[][] dp = new int[m][n];
        // grid上有数字，那么dp[0][0]就是grid[0][0]
        dp[0][0] = grid[0][0];

        // 填充第一行：dp记录是结果，grid记录当前数字，由同一行dp前一个加grid的当前值
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 填充第一列：
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 填充其余位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // grid当前位置数字，要么加上前一行的dp结果，要么加上前一列得dp结果
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // 返回最终结果
        return dp[m - 1][n - 1];
    }
}
