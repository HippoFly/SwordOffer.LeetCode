package com.so.lc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 *给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 21:44
 * @see <a href="https://leetcode.cn/problems/first-missing-positive/">缺失的第一个正数</a>
 * @tag 桶排序
 **/

public class Q41_MissingPositive {

    /**
     * Hash解法，但是不符合要求
     * @param nums 输入的整数数组
     * @return 返回第一个缺失的正整数
     */
    public int firstMissingPositive(int[] nums) {
        // 初始化最小值为整型最大值，最大值为整型最小值
        int min1 =  Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // 创建HashSet存储所有正整数
        Set<Integer> allPos = new HashSet<>();
        // 遍历数组，将正整数添加到HashSet中，并更新最小值
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                allPos.add(nums[i]);
                if(nums[i]<min1){
                    min1 = nums[i];
                }
            }
        }
        // 如果最小的正整数大于1，那就说明1作为最小正整数满足不在已有组合中
        if(min1>1){
            return 1;
        } else {
            // 否则，从最小的正整数开始递增，直到找到第一个不在HashSet中的数
            while (allPos.contains(min1)){
                min1++;
            }
            return min1;
        }
    }

    /**
     * 桶排序实现寻找第一个缺失的正整数
     * <p>
     * 桶排序思想：
     * 比如一个数组长度为n，那么数组中的每个数字都在[1, n]之间，且每个数字只出现一次。
     * 把已有数组中的数字放到正确的位置上，比如把1放到数组的第一个位置，2放到第二个位置，依次类推。
     * 那么，如果数组中没有某个数字，那么这个数字就是缺失的正整数。
     * <p>
     * 这里有一个特殊情况：数组中每一个数字都大于1或者n，那么直接返回1。
     * <p>
     * @param nums 输入数组
     * @return 第一个缺失的正整数
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        // 特殊情况：空数组直接返回 1
        if (n == 0) {
            return 1;
        }

        // 第一步：将每个数字放到正确的位置上
        for (int i = 0; i < n; ) {
            // 获取当前数字，这里 -1是因为数组索引从0开始，而我们观念要从1计数，比如数字1放在索引0的位置
            int correctPos = nums[i] - 1;
            //
            //nums[i] > 0：确保当前数字是正整数，因为题目要求寻找的是缺失的正整数，负数和零无需处理。
            //nums[i] <= n：确保当前数字在有效范围内（即 [1, n]），因为数组长度为 n，超出范围的数字不需要考虑。
            //nums[i] != nums[correctPos]：确保当前数字不在它应该放置的正确位置上。如果已经在正确位置，则无需交换。
            //只有当以上三个条件同时满足时，才会执行交换操作，将当前数字放到它应该在的位置。
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctPos]) {
                // 交换到正确位置
                swap(nums, i, correctPos);
            } else {
                // 如果当前数字已经在正确位置，或者无效（超出范围），则移动指针
                i++;
            }
        }

        // 第二步：检查哪个位置上的数字不匹配
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置都匹配，则返回 n + 1
        return n + 1;
    }
    /**
     * 交换数组中的两个元素所在位置
     * @param nums 数组
     * @param i 索引 i
     * @param j 索引 j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        Q41_MissingPositive missingPositive = new Q41_MissingPositive();
        System.out.println(missingPositive.firstMissingPositive(new int[]{1, 2, 0, -1}));
    }
}
