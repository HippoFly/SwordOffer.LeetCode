package com.so.lc.Array;

/**
 * 描述
 * #二分查找
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 22:31
 **/

public class Q35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left=0,right= len -1;


        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }
        // [1,3,5,6](5)为案例 left因num[1]<5而变2，然后mid=2,num[mid]得5没法小于target，
        // 让right=mid, 这退出循环
        // 最终目的是让left步进从而mid处等于target，同时左无法满足mid小于target
        // right直接压过来等于mid

        // [1,3,6,7](5)为案例 left因num[1]<5而变2，然后mid=2,num[mid]得6没法小于target=5，
        // 让right=mid, 这退出循环
        // 最终目的是让left步进从而mid处没法小于target，同时左无法满足mid小于target
        // right直接压过来等于mid， 此时由于‘/’符号去尾号的效应刚好会等于目标插处
        while (left<right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid + 1;
                //我的疑惑在这，
            }else  {
                right = mid ;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Q35_SearchInsertPosition insertPosition = new Q35_SearchInsertPosition();
        System.out.println(insertPosition.searchInsert(new int[]{1, 3,  6,7}, 5));
    }
}
