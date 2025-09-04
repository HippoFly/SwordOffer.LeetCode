package com.so.leetcode;

/**
 * 33. 搜索旋转排序数组
 *  在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 【实际上还是找数组中某个值位置，但是特殊在这个数组被旋转过】
 *
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
        // 初始化二分查找的左右边界
        int left = 0, right = nums.length - 1;

        // 标准二分查找循环
        while (left <= right) {
            // 计算中间位置（防止整数溢出的写法）
            int mid = left + (right - left) / 2;

            // 情况1：中间值正好是目标值
            if (nums[mid] == target) {
                return mid; // 直接返回找到的索引
            }

            /*
             * 关键判断：左半部分是否有序
             * nums[left] <= nums[mid] 说明左半部分是有序的
             * 因为旋转数组的特性：旋转点会将数组分成两个有序部分
             */
            if (nums[left] <= nums[mid]) {
                /*
                 * 情况2：目标值在有序的左半部分
                 * 条件：target >= nums[left] && target < nums[mid]
                 * 解释：
                 * - target >= nums[left]: 目标值不小于左边界
                 * - target < nums[mid]: 目标值小于中间值（因为nums[mid]已经检查过不等于target）
                 */
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // 在左半部分继续搜索
                }
                /*
                 * 情况3：目标值不在有序的左半部分
                 * 说明可能在右半部分（可能无序）
                 */
                else {
                    left = mid + 1; // 在右半部分继续搜索
                }
            }
            /*
             * 情况4：左半部分无序，说明右半部分必定有序
             * 因为旋转数组的特性：两部分中必有一部分是有序的
             */
            else {
                /*
                 * 情况5：目标值在有序的右半部分
                 * 条件：target > nums[mid] && target <= nums[right]
                 * 解释：
                 * - target > nums[mid]: 目标值大于中间值（因为nums[mid]已经检查过不等于target）
                 * - target <= nums[right]: 目标值不大于右边界
                 */
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // 在右半部分继续搜索
                }
                /*
                 * 情况6：目标值不在有序的右半部分
                 * 说明可能在左半部分（无序部分）
                 */
                else {
                    right = mid - 1; // 在左半部分继续搜索
                }
            }
        }

        // 循环结束仍未找到目标值
        return -1; // 返回未找到的标记
    }
/**
 * 开始二分查找
 * │
 * ├── 情况1：nums[mid] == target → 直接返回mid
 * │
 * ├── 情况2-3：左半部分有序 (nums[left] <= nums[mid])
 * │   ├── 情况2：target在左半有序部分 → right = mid - 1
 * │   └── 情况3：target不在左半有序部分 → left = mid + 1
 * │
 * └── 情况4-6：右半部分有序 (nums[left] > nums[mid])
 *     ├── 情况5：target在右半有序部分 → left = mid + 1
 *     └── 情况6：target不在右半有序部分 → right = mid - 1
 */

}
