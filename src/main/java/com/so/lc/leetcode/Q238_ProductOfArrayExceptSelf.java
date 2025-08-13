package com.so.lc.leetcode;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 * <p>
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

    /**
     * 一个位置的乘积 = 它左边所有数的乘积 × 它右边所有数的乘积
     * <p>
     * 所以我们分两步：
     * <p>
     * 先算左边乘积：从左到右，让 output[i] 存储 nums[i] 左边所有数的乘积。
     * <p>
     * 再乘右边乘积：从右到左，用一个临时变量 rightProduct 记录右边的乘积，边走边更新 output[i]。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: 左边乘积
        output[0] = 1; // 第一个元素左边没有数，所以是 1
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1]; //这里 nums 从 i-1 开始，比如 1 号位左边的 0 号就想通了
        }

        // Step 2: 右边乘积并直接更新
        int rightProduct = 1; // 最右边没有数，所以是 1
        for (int i = n - 1; i >= 0; i--) {
            output[i] =  output[i] * rightProduct; // 左乘 × 右乘
            rightProduct = rightProduct * nums[i];   // 更新右边乘积
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
