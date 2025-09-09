package com.so.leetcode;

import org.junit.Test;

/**
 *  跳跃游戏 II
 * 【不再输出能否，而是最小步数：跳跃到最后索引的最小步数】
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
    /**
     * 不停更新能到最远位置farthest
     * 但是仅有到边界end才会跳和运用不停更新能到最远位置farthest 这个不停更新的边界 减少跳跃次数
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int jumps = 0;       // 跳跃次数
        int farthest = 0;    // 当前能到达的最远位置
        int end = 0;         // 当前跳跃步的边界，表示这一步能覆盖的范围。

        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前位置i + 当前能跳距离=  能跳到的最远索引
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) { //如果 i == end，说明已经走到了当前跳跃步的边界，必须进行下一次跳跃：
                //更新步数
                jumps++;
                //更新边界
                end = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Q45_JumpGame2 jumpGame2 = new Q45_JumpGame2();
        System.out.println(jumpGame2.jump(new int[]{2,3,1,1,4})); //先跳一步到 3，再跳一步到 4
    }
}
