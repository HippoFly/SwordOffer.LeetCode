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
        // 使用 amount + 1 作为"无穷大"的值来初始化 dp 数组
        // 因为硬币的最小面值是1，所以组成 amount 最多需要 amount 个硬币
        // 因此 amount + 1 比任何可能的解都大，可以表示"无法达到"的状态
        Arrays.fill(dp, amount + 1);  
        dp[0] = 0;
        // 金额循环, 小于目标金额的每一个数目
        for (int i = 1; i <= amount; i++) {
            // 针对每一个金额，遍历金币组合，只有当前金额大于金币面值时，才进行更新
            for (int coin : coins) {
                if (i >= coin) {
                    //不停试图取小更迭，直到找到一个最小的：当前面额的硬币面额减去+1就是前一步的硬币数
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果 dp[amount] 的值仍然是初始值 (amount + 1)，说明无法组成该金额，返回 -1
        // 否则返回计算得到的最小硬币数
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 演示动态规划过程的方法，用于理解算法执行步骤
     * @param coins 硬币面额数组
     * @param amount 目标金额
     * @return 最少硬币数
     */
    public int coinChangeWithExplanation(int[] coins, int amount) {
        System.out.println("开始计算硬币找零问题:");
        System.out.println("硬币面额: " + java.util.Arrays.toString(coins));
        System.out.println("目标金额: " + amount);
        System.out.println();

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        System.out.println("初始化dp数组，dp[0] = 0，其余值为" + (amount + 1) + "(表示无穷大):");
        System.out.println("dp = " + java.util.Arrays.toString(dp));
        System.out.println();

        for (int i = 1; i <= amount; i++) {
            System.out.println("计算金额 " + i + " 的最少硬币数:");
            for (int coin : coins) {
                if (i >= coin) {
                    int oldValue = dp[i];
                    int newValue = dp[i - coin] + 1;
                    dp[i] = Math.min(dp[i], newValue);
                    System.out.println("  使用面额为 " + coin + " 的硬币: " +
                            "dp[" + i + "] = min(dp[" + i + "], dp[" + (i - coin) + "] + 1) = " +
                            "min(" + oldValue + ", " + newValue + ") = " + dp[i]);
                }
            }
            System.out.println("  金额 " + i + " 的最少硬币数: " + dp[i]);
            System.out.println();
        }

        System.out.println("最终dp数组: " + java.util.Arrays.toString(dp));
        System.out.println();

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Q322_CoinChange solution = new Q322_CoinChange();
        
        // 测试用例1: coins = [1, 2, 5], amount = 11
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("=== 完整解法 ===");
        int result1 = solution.coinChange(coins1, amount1);
        System.out.println("硬币面额: [1, 2, 5], 目标金额: 11");
        System.out.println("最少硬币数: " + result1); // 输出: 3 (5+5+1)
        System.out.println();
        
        System.out.println("=== 详细过程演示 ===");
        int result1Explained = solution.coinChangeWithExplanation(coins1, 6); // 使用较小的金额演示过程
        System.out.println("最终结果: " + result1Explained);
        System.out.println();
        
        // 测试用例2: coins = [2], amount = 3
        int[] coins2 = {2};
        int amount2 = 3;
        int result2 = solution.coinChange(coins2, amount2);
        System.out.println("硬币面额: [2], 目标金额: 3");
        System.out.println("最少硬币数: " + result2); // 输出: -1 (无法组成)
        
        // 测试用例3: coins = [1], amount = 0
        int[] coins3 = {1};
        int amount3 = 0;
        int result3 = solution.coinChange(coins3, amount3);
        System.out.println("硬币面额: [1], 目标金额: 0");
        System.out.println("最少硬币数: " + result3); // 输出: 0 (不需要硬币)
    }
}
