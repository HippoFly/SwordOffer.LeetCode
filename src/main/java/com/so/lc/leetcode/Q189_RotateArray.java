package com.so.lc.leetcode;

import java.util.Arrays;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 20:50
 **/

public class Q189_RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            // 以k=3, n=7
            // i, i+k, (i + k) % n
            // 0，3 , 3
            // 1，4 , 4
            // 2，5 , 5
            // 3，6 , 6
            // 4，7 , 0
            // 5，8 , 1
            // 6，9 , 2 也就是通过 %  就实现了环状
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }


    public static void main(String[] args) {
        Q189_RotateArray rotateArray = new Q189_RotateArray();
        int[] ints = {1,2,3,4,5,6,7};

        rotateArray.rotate(ints,9);
        System.out.println(Arrays.toString(ints));
    }
}
