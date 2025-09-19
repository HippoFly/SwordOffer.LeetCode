package com.so.leetcode;

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
     *  换位思考，就是这个数组能否凑出
     *  子集的和为 总和的一半
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) sum += num;

        // 如果总和为奇数，不可能平分
        if (sum % 2 != 0) return false;

        // 总和的一半 接下来找符合的子集
        int target = sum / 2;
        // dp[i] 表示是否能组成 和为i 的子集，长度+1代表保留空集和0 的结果
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;  // 空集可以组成 0


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
