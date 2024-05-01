package com.so.lc.Hash;

import java.util.HashMap;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 14:55
 **/

public class Q1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if(index !=null){
                return new int[]{i,index};
            }else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
