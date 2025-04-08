package com.so.lc.leetcode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 17:52
 * @tag 常数表
 **/

public class Q238_ProductOfArrayExceptSelf {
    // 解法1:利用LinkedList的特性调用APi解决
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // 计算每个元素左侧所有元素的乘积并存储在 output 中
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // 计算右侧乘积并直接更新 output
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q238_ProductOfArrayExceptSelf solution = new Q238_ProductOfArrayExceptSelf();
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
        // 输出 [24, 12, 8, 6]
    }
}
