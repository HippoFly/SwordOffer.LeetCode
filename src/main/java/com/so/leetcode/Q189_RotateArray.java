package com.so.leetcode;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 20:50
 * @tag 集合（链表）
 **/

public class Q189_RotateArray {
    public void rotate(int[] nums, int k) {
        // 边界 1：长度为 0 或 1，不需要旋转
        if (nums.length <= 1) {
            return;
        }

        // 边界 2：k 大于数组长度的情况，不需要旋转
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }

        // 第二步：反转整个数组
        reverseArray(nums, 0, n - 1);

        // 第三步：反转前 k 个元素
        reverseArray(nums, 0, k - 1);

        // 第四步：反转后 n-k 个元素
        reverseArray(nums, k, n - 1);
    }

    /**
     * 反转数组中从 left 到 right 的部分（包含 left 和 right）
     * 使用两个指针从两端向中间交换元素
     */
    private void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        Q189_RotateArray rotateArray = new Q189_RotateArray();
        int[] ints = {1,2,3,4,5,6,7};

        rotateArray.rotate(ints,9);
        System.out.println(Arrays.toString(ints));
    }
}
