package com.so.lc.Array;

import java.util.Arrays;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 16:45
 **/

public class Q283_MoveZeroes {
    public static void main(String[] args) {
        Q283_MoveZeroes moveZeroes = new Q283_MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
    }

    /**
     * 思路如下，不论覆盖与否，用一个非零指针从起始，另一个计数指针依次找非零，按个覆盖
     * 然后非零指针安排数字，+1
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 使用双指针法，一个指针用于遍历数组，另一个指针用于记录非零元素应该放置的位置
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 将非零元素移动到应该放置的位置
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        // 将剩余位置填充零
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }
}
