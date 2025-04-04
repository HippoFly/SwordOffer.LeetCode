package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * <p>
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * <p>
 * 输出：[]
 * <p>
 * 解释：唯一可能的三元组和不为 0 。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-04 10:46
 * @tag 数组，双指针，排序，回溯
 * @see <a href="https://leetcode.cn/problems/3sum/">三数之和</a>
 **/
public class Q15_3Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4,-2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 输入校验
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序后的数组是升序的

        for (int i = 0; i < nums.length - 2; i++) {
            // 数组是递增的，如果当前数字大于0，则后面的数字肯定大于0，结束循环
            // 这里i为了避免重复运算只进行小于等于0的部分
            if (nums[i] > 0) {
                break;
            }

            // 跳过重复的数字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1; // 左指针，从当前数字的下一个开始
            int end = nums.length - 1; // 右指针，固定最后一个数字

            // 针对每一个i取值，移动左右指针
            while (start < end) {
                // 当前i时候用来确定三个数字的和
                int sum = nums[i] + nums[start] + nums[end];
                // 符合sum 为 0
                if (sum == 0) {
                    // 添加结果，并继续移动指针
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // （确保左指针在右指针左边时）跳过重复的数字
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    // 移动指针
                    start++;
                    end--;
                    // sum 小于 0，扩大左边指针增大总和
                } else if (sum < 0) {
                    start++;
                    //sum 大于 0，缩小右边指针减小总和
                } else {
                    end--; // 减小总和
                }
            }
        }

        return result;
    }

}
