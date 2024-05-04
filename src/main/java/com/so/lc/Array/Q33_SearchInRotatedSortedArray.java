package com.so.lc.Array;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 15:48
 **/

public class Q33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;  // 左边界索引
        int right = nums.length - 1;  // 右边界索引

        while (left <= right) {  // 循环直到左右边界相遇
            int mid = left + (right - left) / 2;  // 中间索引（避免整数溢出）

            if (nums[mid] == target) {  // 如果中间值等于目标值，直接返回中间索引
                return mid;
            } else if (nums[left] <= nums[mid]) {  // 左边有序的情况
                if (nums[left] <= target && target < nums[mid]) {  // 如果目标值在左边有序部分范围内，调整右边界
                    right = mid - 1;
                } else {  // 否则调整左边界
                    left = mid + 1;
                }
            } else {  // 右边有序的情况
                if (nums[mid] < target && target <= nums[right]) {  // 如果目标值在右边有序部分范围内，调整左边界
                    left = mid + 1;
                } else {  // 否则调整右边界
                    right = mid - 1;
                }
            }
        }

        return -1;  // 没找到目标值，返回 -1
    }

    public static void main(String[] args) {
        Q33_SearchInRotatedSortedArray sortedArray = new Q33_SearchInRotatedSortedArray();
        System.out.println(sortedArray.search(new int[]{4, 5, 6, 7, 8, 1, 2}, 0));
    }
}
