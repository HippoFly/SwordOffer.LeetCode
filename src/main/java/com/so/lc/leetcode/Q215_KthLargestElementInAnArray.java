package com.so.lc.leetcode;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 15:47
 **/

public class Q215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Q215_KthLargestElementInAnArray kthLargestElementInAnArray = new Q215_KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{1, 2, 3, 4, 5, 66}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                return priorityQueue.poll();
            }
            priorityQueue.poll();
        }
        return 0;
    }
}
