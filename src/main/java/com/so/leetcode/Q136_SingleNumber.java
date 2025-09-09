package com.so.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Q136_SingleNumber {

    /**
     * 异或解法
     * 1.
     * 任何数与 0 异或等于它本身：a ^ 0 = a
     * 2.
     * 任何数与自身异或等于 0：a ^ a = 0
     * 3.
     * 异或满足交换律和结合律：a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // 对所有数字进行异或操作
        }
        return result;
    }

    /**
     *   暴力解法
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {

        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if (temp.contains(num)) {
                temp.remove(num);
            } else {
                temp.add(num);
            }
        }
        if (temp.size() > 0) {
            Integer[] integers = temp.toArray(new Integer[0]);
            return integers[0];
        }
        return -1;
    }
}
