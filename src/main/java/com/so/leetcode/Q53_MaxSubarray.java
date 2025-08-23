package com.so.leetcode;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-07 10:41
 * @tag 贪心算法，动态规划
 * @link <a href="https://leetcode.cn/problems/maximum-subarray/">最大子数组</a>
 *
 **/
public class Q53_MaxSubarray {

    /**
     * 贪心算法
     *贪心思路的核心直觉
     * 我们遍历数组时，其实在做一个选择：
     * 当前子数组要不要继续加下去？还是重新开始一个新的子数组？
     *
     * 直觉：
     * 如果当前子数组的和已经是负数，那它只会拖累后面的结果，立刻丢掉，重新开始。
     * 如果是正数，那它会让后面更大，继续加。
     *
     *
     *
     * 解题：
     * currentSum = 当前子数组的和
     * maxSum = 遍历到目前为止的最大子数组和
     *
     * 流程：
     * 从左到右扫描
     * 每遇到新元素 x，判断：
     * 如果 currentSum < 0，丢掉它，从 x 重新开始
     * 否则加上 x
     * 每一步更新 maxSum
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];  // 全局最大和
        int currentSum = nums[0];  // 当前子数组和

        for (int i = 1; i < nums.length; i++) {
            // 要么继续之前的子数组，要么从当前元素重新开始（这里巧妙在 max（）如果 cS 是负数会导致其加上 num[i]后变小）
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大值 （仅仅在当前连续和挑战成功会更替）
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
