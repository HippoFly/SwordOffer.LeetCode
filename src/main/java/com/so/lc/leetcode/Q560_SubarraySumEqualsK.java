package com.so.lc.leetcode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 19:06
 **/

public class Q560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1]=nums[i]+preSum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j+1]-preSum[i]==k) {
                    count++;
                }
            }

        }
        return count;
    }
}
