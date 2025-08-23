package com.so.leetcode;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 21:44
 * @tag 桶排序
 * @see <a href="https://leetcode.cn/problems/first-missing-positive/">缺失的第一个正数</a>
 **/

public class Q41_MissingPositive {

    /**
     * 遍历数组：
     * <p>
     * 只要当前 nums[i] 在 [1, n] 范围内，并且它不在正确的位置，就交换到正确位置。
     * <p>
     * 交换时用 while 循环，因为换过来的新数也可能要交换。
     * <p>
     * 再次遍历数组：
     * <p>
     * 如果 nums[i] != i+1，返回 i+1。
     * <p>
     * 如果全都匹配，返回 n+1（说明 1~n 都齐了）
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 开一个长度 n+1 的桶（因为我们关心 1~n）
        boolean[] bucket = new boolean[n + 1];

        // 把 1~n 范围的数放进桶里（标记存在）
        for (int num : nums) {
            if (num >= 1 && num <= n) {
                bucket[num] = true;
            }
        }

        // 找第一个桶里没出现的正数
        for (int i = 1; i <= n; i++) {
            if (!bucket[i]) {
                return i;
            }
        }

        // 如果 1~n 都在，缺的是 n+1
        return n + 1;
    }


    public static void main(String[] args) {
        Q41_MissingPositive missingPositive = new Q41_MissingPositive();
        System.out.println(missingPositive.firstMissingPositive(new int[]{1, 2, 0, -1}));
    }
}
