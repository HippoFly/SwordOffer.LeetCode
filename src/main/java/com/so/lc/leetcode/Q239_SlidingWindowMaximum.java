package com.so.lc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 描述
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/9 18:52
 * @see <a href="https://leetcode.cn/problems/sliding-window-maximum/">滑动窗口最大值</a>
 * @tag 队列、双端队列、单调队列、滑动窗口、单调栈、堆（数据结构）
 **/

public class Q239_SlidingWindowMaximum {


    //TODO
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int len = nums.length;
        // 窗口结果数组，长度必定（len-k+1）比如3个数字，长度为2的窗口，结果（3-2+1）长度
        int[] result = new int[len - k + 1];

        // 这个队列按照降序排列，移除小于当前元素的索引
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < len; i++) {
            // 移除不在窗口范围内的元素
            // 检查优先队列是否为空，若为空则直接跳过。
            //若队列不为空且队首元素的索引小于等于 i - k（即该元素已超出当前窗口范围），则将其从队列中移除。
            //重复上述过程，直到队列为空或队首元素在当前窗口范围内。
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // 将当前元素加入堆
            maxHeap.offer(new int[]{nums[i], i});

            // 当窗口满足大小时，将窗口内的最大值加入结果数组
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }





}
