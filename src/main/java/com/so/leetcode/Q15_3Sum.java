package com.so.leetcode;

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
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 输入校验
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        // 结果放在 list
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序后的数组是升序的

        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前数字大于 0，则三数之和一定大于 0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            // 跳过前面数字的重复部分
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 左指针跳重，左++
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 右指针跳重，右--
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // 指针向中间移动
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

}
