package com.so.leetcode;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-13 16:35
 * @tag
 * @link <a href=""></a>
 **/
public class Q279_PerfectSquares {

    /**
     * 第一步：定义状态
     *
     *  dp[i]表示「和为i的最少完全平方数数量」
     *
     * 第二步：状态转移方程
     *
     * 从`1^2, 2^2, ..., j^2`这些可以选择的平方数中尝试所有情况：
     *
     * ```java
     * dp[i] = min(dp[i - j*j] + 1)  // j*j <= i
     * ```
     *
     * 你可以理解为「从`i`减去一个平方数，剩下的最优结果 +1」
     *
     * ---
     *
     * 第三步：初始化
     *
     * ```java
     * dp[0] = 0
     * dp[1...n] = 正无穷（或者大整数）
     * ```
     *
     * 第四步：遍历顺序
     *
     * 外层`i`从`1`到`n`，内层`j*j <= i`，尝试所有小于等于`i`的平方数
     *
     * ---
     *
     * 第五步：最终结果
     *
     * 返回`dp[n]`
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 初始化为“无穷大”
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) { //遍历平方候选数字 比如对于 12 其候选数为 1^2, 2^2, 3^2, 只要 j*j <= i。
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
