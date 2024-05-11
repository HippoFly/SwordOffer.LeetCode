package com.so.sword.q8;

/**
 * 第8题
 * 输入一个非递减排序数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class MinNumber8 {

    /**
     * 解法一：二分查找（寻找变化点）
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     *
     *
     * @param array
     * @return
     */
    public static int minInReversingList(int[] array) {
        // 边界考虑
        if (array == null || array.length == 0) {
            return -1;
        }
        // 只有一个 或者 没有旋转
        if (array.length == 1 || array[array.length - 1] > array[0]) {
            return array[0];
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 中点 大于 右边说明 中点右边就是反转起点
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            // 中点 小于 左边说明 中点本身就是反转起点
            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }

            // 中点大于起点说明 旋转不在此区间 新区间 改left在中点右边
            if (array[mid] > array[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 解法二：二分查找（最左下标）
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public static int minInReversingList2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * 第8.1题：若非递减排序数组中有重复元素，求最小元素
     * 时间复杂度：O(log n)，空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
