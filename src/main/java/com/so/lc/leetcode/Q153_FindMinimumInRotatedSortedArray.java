package com.so.lc.leetcode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 17:34
 **/

public class Q153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left<=right){
            int mid=(left+right)/2;
            //左有序
            if(nums[mid]>=nums[left]){
                if(min>nums[left]){
                    min = nums[left];
                }
                left = mid + 1;
            }else {
                if(min>nums[mid]){
                    min = nums[mid];
                }
                right = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Q153_FindMinimumInRotatedSortedArray minimumInRotatedSortedArray = new Q153_FindMinimumInRotatedSortedArray();
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{3,1,2}));
    }
}
