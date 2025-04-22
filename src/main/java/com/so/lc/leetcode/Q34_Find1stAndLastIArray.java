package com.so.lc.leetcode;

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
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    /**
     * 二分查找算法寻找目标值在数组中的第一个出现位置
     * 此方法专注于寻找目标值的起始索引，适用于数组中有重复值的情况
     *
     * @param nums   一个已排序的整数数组
     * @param target 目标值，我们要在数组中找到这个值的第一个出现位置
     * @return 返回目标值在数组中的第一个出现位置的索引；如果目标值不在数组中，则返回-1
     */
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 当找到目标值时，记录位置并向左继续查找，以确定第一个出现位置
            if (nums[mid] == target) {
                first = mid;
                // 继续向左查找
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    /**
     * 在排序数组中查找目标值的最后一个位置
     * 如果目标值不存在，则返回-1
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 目标值的最后一个位置的索引，如果不存在则返回-1
     */
    private int findLast(int[] nums, int target) {
        // 初始化左右指针
        int left = 0, right = nums.length - 1;
        // 初始化目标值的最后一个位置为-1，表示未找到
        int last = -1;
        // 当左指针不超过右指针时，执行二分查找
        while (left <= right) {
            // 计算中间位置，避免整数溢出
            int mid = left + (right - left) / 2;
            // 当找到目标值时，更新最后一个位置，并继续向右查找可能还有目标值
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // 继续向右查找
            } else if (nums[mid] < target) {
                // 如果中间值小于目标值，目标值在右侧，更新左指针
                left = mid + 1;
            } else {
                // 如果中间值大于目标值，目标值在左侧，更新右指针
                right = mid - 1;
            }
        }
        // 返回目标值的最后一个位置
        return last;
    }

    public static void main(String[] args) {
        Q34_Find1stAndLastIArray solution = new Q34_Find1stAndLastIArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }

}
