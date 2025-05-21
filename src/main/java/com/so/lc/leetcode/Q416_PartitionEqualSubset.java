package com.so.lc.leetcode;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-21 15:42
 * @tag
 * @link <a href=""></a>
 **/
public class Q416_PartitionEqualSubset {

    /**
     *  判断是否存在一个子集，使得它的和为 totalSum / 2。
     *  如果不能被 2 整除 → 一定不可能
     *  否则，就变成了：是否能选出若干个数，使得它们的和为 target
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        // 求和
        for (int num : nums) sum += num;

        // 如果总和为奇数，不可能平分
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        // dp[i] 表示是否能组成和为 i 的子集，+1保留空集的结果
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;  // 空集可以组成 0


        // 数字集合依次取出数字，方便在二层循环中删除
        for (int num : nums) {
            // 每次从target开始递减1，判断：当前j元素，或j-target是否组成子集
            for (int j = target; j >= num; j--) {
                // dp[i] 表示是否能组成和为 i 的子集，
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
    public static void main(String[] args) {
        Q416_PartitionEqualSubset q416_partitionEqualSubset = new Q416_PartitionEqualSubset();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(q416_partitionEqualSubset.canPartition(nums));
    }
}
