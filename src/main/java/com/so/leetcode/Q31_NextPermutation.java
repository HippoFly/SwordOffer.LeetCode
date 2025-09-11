package com.so.leetcode;

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
     * 1.
     *  从后向前  找到第一个  非递增  的元素 nums[i]（即 nums[i] < nums[i+1]）。
     * 2.
     * 如果找到 i，则从后向前找到第一个  大于 nums[i]  的元素 nums[j]，并交换 nums[i]和 nums[j]。
     * 3.
     *  反转 nums[i+1:]，使其变为升序（保证是最小的下一个排列）。 【这里必须解释为何倒序，因为找的是“最小变换”，而第一步都是目标点右边-都是降序-代表很大，想减小就倒过来，让其最接近最小差距】
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;// 这里-2是因为下一步刚好记录 i

        // 1. 从后向前找第一个非递增的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. 如果找到 i，则找第一个大于 nums[i] 的元素并交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. 反转 nums[i+1:]（使其升序）
        reverse(nums, i + 1);
    }

    // 辅助函数：交换两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 辅助函数：反转数组从 start 到 end 的部分
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

}
