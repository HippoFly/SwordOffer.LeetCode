package com.so.lc.leetcode;

/**
 * 35. 搜索插入位置
 * #二分查找
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 22:31
 * @tag 二分查找
 **/

public class Q35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;


        // 特殊判断：仅仅做最大越界判断，是因为需要扩容后的一位，靠二分法没法得到这一位
        // 二分仅仅能在数组内部找到目标值
        if (nums[len - 1] < target) {
            return len;
        }
        // while最后一定以两者相等退出循环
        while (left < right) {


            // 长度为偶数8，（0+7）/ 2 = 3 mid为第4个元素，
            // 长度为偶数7，（0+6）/ 2 = 3 mid为第4个元素，
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
                //我的疑惑在这，
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Q35_SearchInsertPosition insertPosition = new Q35_SearchInsertPosition();
        System.out.println(insertPosition.searchInsert(new int[]{1, 3, 6, 7}, 5));
    }
}
