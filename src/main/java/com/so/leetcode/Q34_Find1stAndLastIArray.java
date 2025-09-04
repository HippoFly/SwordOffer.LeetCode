package com.so.leetcode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-17 16:10
 * @tag
 * @link <a href=""></a>
 **/
public class Q34_Find1stAndLastIArray {
    public int[] searchRange(int[] nums, int target) {
        int first = Arrays.binarySearch(nums, target);
        if (first < 0) {
            return new int[]{-1, -1};
        }

        // 向左查找第一个位置
        int start = first;
        while (start > 0 && nums[start - 1] == target) {
            start--;
        }

        // 向右查找最后一个位置
        int end = first;
        while (end < nums.length - 1 && nums[end + 1] == target) {
            end++;
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Q34_Find1stAndLastIArray solution = new Q34_Find1stAndLastIArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }

}
