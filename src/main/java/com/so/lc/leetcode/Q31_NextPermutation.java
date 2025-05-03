package com.so.lc.leetcode;

/**
 * 31. 下一个排列
 * 这里顺序的大小，重要程度是 第一位 到最后一位
 * 但是寻求最靠近的 则是从后往前找，找到第一个比前一位大的，然后交换，然后从后往前找，找到第一个比前一位小的，然后交换，然后把前一位后面的都升序排列
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-03 13:38
 * @tag
 * @link <a href=""></a>
 **/
public class Q31_NextPermutation {
    /**
     * Step 1
     * 找到最后一个可以变大的位置
     * 字典中从后往前找第一个可修改字母
     * Step 2
     * 找一个刚好比当前大的数替换
     * 找一个刚好能让单词变大的字母
     * Step 3
     * 替换，让整体变大一点点
     * 改变一个字母，让单词变大
     * Step 4
     * 反转后面，使其最小
     * 把后面的字母按最小顺序排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: 从后往前找第一个 nums[i] < nums[i+1]
        // 循环结束时  i < 0 或者 nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: 从后往前找第一个 nums[j] > nums[i]
        // j  从后往前找，找到第一个 nums[j] > nums[i]
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // Step 4: 反转 i+1 到末尾，使其为最小可能的排列
        reverse(nums, i + 1, n - 1);
    }

    // 辅助函数：交换两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 辅助函数：反转数组从 start 到 end 的部分
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
