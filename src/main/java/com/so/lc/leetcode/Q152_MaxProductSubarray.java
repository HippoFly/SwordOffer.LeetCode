package com.so.lc.leetcode;

/**
 *
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 难点：正负变换如何连续
 * 由于乘法的特点（负负得正），我们要同时跟踪：
 *
 * 最大值（当前最大乘积）
 * 最小值（当前最小乘积）
 * 因为最小负数 × 当前负数 → 可能变成最大正数！
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-20 16:56
 * @tag
 * @link <a href=""></a>
 **/
public class Q152_MaxProductSubarray {
    /**
     * 这里为了解决连续的正负切换，
     * 记录最大和最小；
     * 每次最大和最小还要比较三个元素：当前元素、当前*最大乘积、当前*最小乘积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 最大和
        int maxProd = nums[0];
        // maxHere：以当前元素结尾的子数组的最大乘积
        // minHere：以当前元素结尾的子数组的最小乘积（因为可能变最大）
        int maxHere = nums[0], minHere = nums[0];

        for (int i = 1; i < n; i++) {
            int tempMax = maxHere;
            maxHere = Math.max(nums[i], Math.max(nums[i] * maxHere, nums[i] * minHere));
            minHere = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * minHere));
            maxProd = Math.max(maxProd, maxHere);
        }

        return maxProd;
    }

}
