package com.so.lc.leetcode;

/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-06-02 10:01
 * @tag
 * @link <a href=""></a>
 **/
public class Q55_JumpGame {
    /**
     * 判断是否能够跳跃到最后一个下标。
     *
     * @param nums 非负整数数组，表示每个位置可以跳跃的最大长度
     * @return 如果能够到达最后一个下标，返回 true；否则返回 false
     */
    public boolean canJump(int[] nums) {
        // 记录当前能够到达的最远位置
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // 这一步不容易写出来：进入循环后，首先判断当前位置是否已经被覆盖在可到达范围内
            // 如果当前i在 可到达范围内
            if (i <= maxReach) {

                // 在当前i能到的时候，更新最大能到 的位置： 当前位置 + 当前位置能跳的距离
                // ，顺便在下一次比较的maxReach以及记录了前几步的 可到达范围
                maxReach = Math.max(maxReach, i + nums[i]);

                // 如果已经能够到达或超过数组末尾，直接返回 true
                if (maxReach >= nums.length - 1) {
                    return true;
                }
                // 当前i 不在可到达范围内，跳出循环
            } else {
                // 当前位置无法被到达，直接跳出循环并返回 false
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q55_JumpGame solution = new Q55_JumpGame();

        // 示例输入
        int[] nums = {2,3,1,1,4};

        // 调用方法判断是否能够跳跃到末尾
        System.out.println(solution.canJump(nums)); // 输出: true
    }
}
