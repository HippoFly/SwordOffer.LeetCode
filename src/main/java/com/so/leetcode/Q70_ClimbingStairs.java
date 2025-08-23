package com.so.leetcode;

/**
 * 70. 爬楼梯
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-12 09:57
 * @tag 动态规划
 * @link <a href=""></a>
 **/
public class Q70_ClimbingStairs {
    /**
     * 计算爬到第n个台阶的方法数
     * 使用动态规划的思想，每一步可以由前一个台阶或前两个台阶跳到，因此当前台阶的方法数是前两个台阶方法数之和
     *
     * @param n 第n个台阶
     * @return 爬到第n个台阶的方法数
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1];  // dp[0...n]
        dp[0] = 1;  // 一种方式，不动
        dp[1] = 1;  // 一种方式，走一步

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // 状态转移方程
        }

        return dp[n];
    }

}
