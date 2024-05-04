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
}
