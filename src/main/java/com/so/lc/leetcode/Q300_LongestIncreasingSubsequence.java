package com.so.lc.leetcode;

import java.util.Arrays;

/**
 *
 * 300. 最长递增子序列
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-20 15:55
 * @tag
 * @link <a href=""></a>
 **/
public class Q300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 每个位置起点长度都是1
        int maxLen = 1;
        // 逐步递增上限
        for (int i = 1; i < n; i++) {
            // 在每个上限内遍历找递增子序列
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

}
