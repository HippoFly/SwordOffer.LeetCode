package com.so.lc.leetcode;

import java.util.*;

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
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/9 18:52
 * @tag 队列、双端队列、单调队列、滑动窗口、单调栈、堆（数据结构）
 * @see <a href="https://leetcode.cn/problems/sliding-window-maximum/">滑动窗口最大值</a>
 **/

public class Q239_SlidingWindowMaximum {

    /**
     * 滑动窗口思路：
     * 1.用一个双端队列来帮忙
     * 队列里存放的是数组元素的索引，不是值
     * 队列中的索引对应的值要保持从大到小的顺序（单调递减）
     * 2.遍历数组的每个元素
     * 先检查队首的索引是否已经滑出窗口范围，如果超出了就移除
     * 再检查当前元素是否比队尾索引对应的元素大，如果大就把队尾元素移除
     * 然后把当前元素的索引加入队尾
     * 当窗口大小达到k时，队首索引对应的元素值就是当前窗口的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        // 结果数组长度 = 窗口数（每一个元素代表一个窗口内的最大值） 至于为什么是 n-k+1 我们拿长度为 4 的数组，窗口大小为 3，窗口数是 3， 4-2必须加 1 才得到 3
        int[] result = new int[n - k + 1];
        // deque中存储的内容：
        // 存储的是索引（不是值本身）
        // 但是这些索引按照其对应的数组值大小排序（单调递减）
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. 保障窗口大小：如果 deque 内的索引数已经等于窗口长度，表现为最 First 的索引 小于等于  即将入窗的右索引 - k
            // （判断：队首索引是否已经滑出了当前窗口范围） deque.peekFirst()是最左边索引， i-k 是即将滑入的索引减去窗口长度
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst(); //移除并返回双端队列的第一个元素（队首元素）。
            }

            // 2. 维护单调性（队列记录单调递减的顺序的索引，这里如果窗口新吞元素大于队尾，移除队尾的索引直到队尾全是大于即将入窗的元素，比如全小于则全排出）
            //*： deque.peekLast()是最后进入的索引，nums[deque.peekLast()] 是其对应的值，nums[i]是当前索引对应的值如果大于队尾索引对应的值，则队尾索引对应的值就比当前索引对应的值小，则移除索引
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. 添加当前索引
            deque.offerLast(i);

            // 4. 记录结果（窗口形成后）
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7}; // 结果：
//        int[] nums = {1, 2, 3, 4, 5, 6, 7}; // 结果：
//        int[] nums = {7, 6, 5, 4, 3, 2, 1}; // 结果：
        int[] nums = {7, 6, 10,5, 4, 3, 2, 1}; // 结果：
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


}
