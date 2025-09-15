package com.so.leetcode;

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
        // maxHere：以当前元素结尾的子数组的最大乘积； minHere：以当前元素结尾的子数组的最小乘积（负数，后期可能变最大）
        int maxHere = nums[0], minHere = nums[0];

        for (int i = 1; i < n; i++) {
            // 保存当前的最大值，因为在计算最小值时会用到
            int tempMax = maxHere;
            
            // 计算以当前元素结尾的子数组的最大乘积
            // 需要考虑三种情况并取最大值：
            // 1. nums[i] - 从当前元素重新开始（之前的乘积可能为负数或较小）
            // 2. nums[i] * maxHere - 当前元素乘以之前的连续最大乘积
            // 3. nums[i] * minHere - 当前元素乘以之前的连续最小乘积（当当前元素为负数时，负数乘以负数可能得到更大的正数）
            maxHere = Math.max(nums[i], Math.max(nums[i] * maxHere, nums[i] * minHere));
            
            // 计算以当前元素结尾的子数组的最小乘积
            // 同样需要考虑三种情况并取最小值：
            // 1. nums[i] - 从当前元素重新开始
            // 2. nums[i] * tempMax - 当前元素乘以之前的连续最大乘积（tempMax是maxHere的旧值）
            // 3. nums[i] * minHere - 当前元素乘以之前的连续最小乘积
            minHere = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * minHere));
            
            // 更新全局最大乘积
            maxProd = Math.max(maxProd, maxHere);
        }

        return maxProd;
    }

    /**
     * 演示最大乘积子数组算法的执行过程
     * @param nums 输入数组
     * @return 最大乘积
     */
    public int maxProductWithExplanation(int[] nums) {
        System.out.println("开始计算最大乘积子数组:");
        System.out.println("数组: " + java.util.Arrays.toString(nums));
        System.out.println();
        
        int n = nums.length;
        int maxProd = nums[0];
        int maxHere = nums[0], minHere = nums[0];
        
        System.out.println("初始化: maxProd = " + maxProd + ", maxHere = " + maxHere + ", minHere = " + minHere);
        System.out.println();
        
        for (int i = 1; i < n; i++) {
            System.out.println("处理元素 nums[" + i + "] = " + nums[i] + ":");
            
            int tempMax = maxHere;
            System.out.println("  保存当前maxHere到tempMax: " + tempMax);
            
            // 计算新的maxHere
            int candidate1 = nums[i];
            int candidate2 = nums[i] * maxHere;
            int candidate3 = nums[i] * minHere;
            maxHere = Math.max(candidate1, Math.max(candidate2, candidate3));
            System.out.println("  计算maxHere:");
            System.out.println("    nums[" + i + "] = " + candidate1);
            System.out.println("    nums[" + i + "] * maxHere = " + nums[i] + " * " + tempMax + " = " + candidate2);
            System.out.println("    nums[" + i + "] * minHere = " + nums[i] + " * " + minHere + " = " + candidate3);
            System.out.println("    maxHere = max(" + candidate1 + ", max(" + candidate2 + ", " + candidate3 + ")) = " + maxHere);
            
            // 计算新的minHere
            minHere = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * minHere));
            System.out.println("  计算minHere = min(" + nums[i] + ", min(" + nums[i] + " * " + tempMax + ", " + nums[i] + " * " + minHere + ")) = " + minHere);
            
            // 更新全局最大值
            int oldMaxProd = maxProd;
            maxProd = Math.max(maxProd, maxHere);
            System.out.println("  更新maxProd: max(" + oldMaxProd + ", " + maxHere + ") = " + maxProd);
            System.out.println();
        }
        
        System.out.println("最终结果: " + maxProd);
        return maxProd;
    }

    public static void main(String[] args) {
        Q152_MaxProductSubarray solution = new Q152_MaxProductSubarray();
        
        // 测试用例1: [2,3,-2,4]
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("=== 简单执行 ===");
        int result1 = solution.maxProduct(nums1);
        System.out.println("数组: [2,3,-2,4]");
        System.out.println("最大乘积子数组: " + result1); // 输出: 6 ([2,3])
        System.out.println();
        
        System.out.println("=== 详细过程演示 ===");
        int result1Explained = solution.maxProductWithExplanation(nums1);
        System.out.println();
        
        // 测试用例2: [-2,0,-1]
        int[] nums2 = {-2, 0, -1};
        int result2 = solution.maxProduct(nums2);
        System.out.println("数组: [-2,0,-1]");
        System.out.println("最大乘积子数组: " + result2); // 输出: 0
        
        // 测试用例3: [-2,3,-4]
        int[] nums3 = {-2, 3, -4};
        int result3 = solution.maxProduct(nums3);
        System.out.println("数组: [-2,3,-4]");
        System.out.println("最大乘积子数组: " + result3); // 输出: 24 (整个数组)
    }
}
