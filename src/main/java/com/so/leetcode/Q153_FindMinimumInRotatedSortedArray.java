package com.so.leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 假设我们有一个数组 nums = [0, 1, 2, 4, 5, 6]，我们来演示一下它经过不同次数旋转后的结果：
 * 旋转 0 次：[0, 1, 2, 4, 5, 6]
 * 旋转 1 次：[6, 0, 1, 2, 4, 5]
 * 旋转 2 次：[5, 6, 0, 1, 2, 4]
 * 旋转 3 次：[4, 5, 6, 0, 1, 2]
 * 旋转 4 次：[2, 4, 5, 6, 0, 1]
 * 旋转 5 次：[1, 2, 4, 5, 6, 0]
 * 旋转 6 次：[0, 1, 2, 4, 5, 6] （回到原始状态）
 * 可见：这里的旋转类似于表带
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 17:34
 * 参考，解法相同 {@link Q33_SearchInRotatedSortedArray}
 **/

public class Q153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE; // 初始化最小值为最大整数

        while (left <= right) {
            int mid = (left + right) / 2;

            // 分支1：判断左半部分是否有序
            if (nums[mid] >= nums[left]) {
                // 子分支1.1：左半部分有序时，左边界可能是最小值
                if (min > nums[left]) {
                    min = nums[left]; // 更新最小值
                }
                // 子分支1.2：最小值可能在右半部分（无序部分）
                else {
                    left = mid + 1; // 搜索右半部分
                }
            }
            // 分支2：左半部分无序（说明右半部分有序）
            else {
                // 子分支2.1：中间值可能是最小值
                if (min > nums[mid]) {
                    min = nums[mid]; // 更新最小值
                }
                // 子分支2.2：最小值可能在左半部分（无序部分）
                else {
                    right = mid - 1; // 搜索左半部分
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Q153_FindMinimumInRotatedSortedArray minimumInRotatedSortedArray = new Q153_FindMinimumInRotatedSortedArray();
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{3, 1, 2}));
    }
}
