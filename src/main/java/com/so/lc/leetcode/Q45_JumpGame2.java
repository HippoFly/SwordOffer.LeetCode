package com.so.lc.leetcode;

/**
 *  跳跃游戏 II
 * 【不再输出能否，而是最小步数】
 *  给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-03 09:49
 * @tag
 * @link <a href=""></a>
 **/
public class Q45_JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0;       // 跳跃次数
        int farthest = 0;    // 当前能到达的最远位置
        int end = 0;         // 当前跳跃步的边界

        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前位置能跳到的最远索引
            farthest = Math.max(farthest, i + nums[i]);

            // 如果到了当前步能跳跃的 边界
            if (i == end) {
                //更新步数
                jumps++;
                //更新边界
                end = farthest;
            }
        }

        return jumps;
    }
}
