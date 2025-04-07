package com.so.lc.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

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
   // 解法1:利用集合LinkedList的特点
    public void rotate(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        // 处理 k 大于 n 的情况
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            list.addFirst(list.removeLast());
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }


    public static void main(String[] args) {
        Q189_RotateArray rotateArray = new Q189_RotateArray();
        int[] ints = {1,2,3,4,5,6,7};

        rotateArray.rotate(ints,9);
        System.out.println(Arrays.toString(ints));
    }
}
