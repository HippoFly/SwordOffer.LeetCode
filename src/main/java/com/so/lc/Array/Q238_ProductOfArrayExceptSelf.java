package com.so.lc.Array;

import java.util.Arrays;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 17:52
 **/

public class Q238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] output = new int[n];

        // 0号初始为1
        leftProducts[0] = 1;
        // 计算每个元素左侧所有元素的乘积
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        //尾号初始为1
        rightProducts[n - 1] = 1;
        // 计算每个元素右侧所有元素的乘积
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        // 将左右两侧乘积相乘得到最终结果
        for (int i = 0; i < n; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q238_ProductOfArrayExceptSelf solution = new Q238_ProductOfArrayExceptSelf();
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result)); // 输出 [24, 12, 8, 6]
    }
}
