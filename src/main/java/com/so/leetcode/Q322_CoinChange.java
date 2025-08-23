package com.so.leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * <p>
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-16 10:06
 * @tag
 * @link <a href=""></a>
 **/
public class Q322_CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // 初始化为无穷大（不可能达到）
        dp[0] = 0;
        // 金额循环, 小于目标金额的每一个数目
        for (int i = 1; i <= amount; i++) {
            // 针对每一个金额，遍历金币组合，只有当前金额大于金币面值时，才进行更新
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
