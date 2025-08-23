package com.so.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 16:45
 **/

public class Q283_MoveZeroes {
    public static void main(String[] args) {
        Q283_MoveZeroes moveZeroes = new Q283_MoveZeroes();
        int[] mZeros = {1, 2, 0, 3};
        moveZeroes.moveZeroes(mZeros);
        System.out.println(Arrays.toString(mZeros));
    }

    /**
     * 将数组中的所有零移动到末尾，同时保持非零元素的相对顺序。
     * 使用双指针法实现，一个指针用于遍历数组，另一个指针用于记录非零元素应该放置的位置。
     *
     * @param nums 输入的整数数组
     */
    public void moveZeroes(int[] nums) {
        // 输入校验：如果数组为 null 或长度为 0，直接返回
        if (nums == null || nums.length == 0) {
            return;
        }

        // 指针法
        // 记录非零元素应该放置的位置
        int nonZeroIndex = 0;

        // 第一步：遍历，将非零元素依次向前覆盖，同时【记录指针】指向覆盖后一位
        // 这个遍历中，每遇到一个非零元素，就要（先判断非 0 记录点不在本位即交换，非0记录点后移）
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 避免冗余赋值：只有当 i 和 nonZeroIndex 不相等时才进行赋值
                if (i != nonZeroIndex) {
                    nums[nonZeroIndex] = nums[i];
                }
                nonZeroIndex++;
            }
        }

        // 第二步：将剩余位置填充为零
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }

}
