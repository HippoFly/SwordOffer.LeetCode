package com.so.lc.leetcode;
import java.util.Arrays;

/**
 * 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 *
 *
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 19:06
 * @see <a href="https://leetcode.cn/problems/subarray-sum-equals-k/">560. 和为 K 的子数组</a>
 * @tag 数组，前缀和，子串
 **/

public class Q560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // 创建一个前缀和数组，长度为 nums.length + 1，这里多出来的1是为了空子数组
        // 比如[1,2,3] K=要计算[1,2]
        int[] preSum = new int[nums.length + 1];
        // 统计符合个数
        int count = 0;

        // 计算前缀和数组
        for (int i = 0; i < nums.length; i++) {
            // preSum[i+1] 表示从 nums[0] 到 nums[i] 的元素和
            preSum[i + 1] = nums[i] + preSum[i];
        }

        // 遍历所有可能的子数组
        // 双重循环是为了遍历 被减数 和 减数
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // 计算子数组 nums[i] 到 nums[j] 的和
                // preSum[j+1] - preSum[i] 表示从 nums[i] 到 nums[j] 的元素和

                if (preSum[j + 1] - preSum[i] == k) {
                    // 如果子数组的和等于 k，则计数器加 1
                    count++;
                }
            }
        }

        // 返回和为 k 的子数组的个数
        return count;
    }

    public static void main(String[] args) {
        Q560_SubarraySumEqualsK solution = new Q560_SubarraySumEqualsK();

        // 测试案例 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = solution.subarraySum(nums1, k1);
        System.out.println("Test Case 1: nums = " + Arrays.toString(nums1) + ", k = " + k1 + ", Result = " + result1);
        // 输出: 2

        // 测试案例 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        int result2 = solution.subarraySum(nums2, k2);
        System.out.println("Test Case 2: nums = " + Arrays.toString(nums2) + ", k = " + k2 + ", Result = " + result2);
        // 输出: 2

        // 测试案例 3
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        int result3 = solution.subarraySum(nums3, k3);
        System.out.println("Test Case 3: nums = " + Arrays.toString(nums3) + ", k = " + k3 + ", Result = " + result3);
        // 输出: 3

        // 测试案例 4
        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 5;
        int result4 = solution.subarraySum(nums4, k4);
        System.out.println("Test Case 4: nums = " + Arrays.toString(nums4) + ", k = " + k4 + ", Result = " + result4);
        // 输出: 2

        // 测试案例 5
        int[] nums5 = {-1, -1, 1};
        int k5 = 0;
        int result5 = solution.subarraySum(nums5, k5);
        System.out.println("Test Case 5: nums = " + Arrays.toString(nums5) + ", k = " + k5 + ", Result = " + result5);
        // 输出: 1
    }
}
