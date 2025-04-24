package com.so.lc.leetcode;

/**
 * 33. 搜索旋转排序数组
 *  在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 15:48
 **/

public class Q33_SearchInRotatedSortedArray {

    /**
     * 1，初始化左右指针 left = 0 和 right = nums.length - 1。
     * 2，在循环中计算中间位置 mid = (left + right) / 2。
     * 3，判断 nums[mid] 是否等于 target，如果是，直接返回 mid。
     * 4，如果左侧部分 [left, mid] 是有序的：
     *      a，如果 target 在 [left, mid] 范围内，则将右边界调整为 mid - 1。
     *      b，否则将左边界调整为 mid + 1。
     * 5，如果右侧部分 [mid, right] 是有序的：
     *      a，如果 target 在 [mid, right] 范围内，则将左边界调整为 mid + 1。
     *      b，否则将右边界调整为 mid - 1。
     * 6，如果循环结束仍未找到目标值，返回 -1。
     *
     * 这里可以肯定一定有一半是有序的，不会存在二分法下，两者无序的情况
     * 思考一种旋转情况，右侧有序，左侧是旋转的部分，但是target在旋转的部分
     * 那么进入（5b）， 且右边界调整为mid-1
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 保持左右指针的大前提
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果目标值等于中间值，直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 判断left到mid的数组是否是有序的

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


}
