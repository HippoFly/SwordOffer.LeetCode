package com.so.lc.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 17:52
 **/

public class Q169_MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int halfLen=nums.length/2;
        Map<Integer,Integer> temp = new HashMap();
        for (int num : nums) {
            if(temp.get(num)==null){
                temp.put(num,1);
            }else {
                Integer times = temp.get(num);
                if(times>=halfLen){
                    return num;
                }else {
                    temp.put(num, ++times);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q169_MajorityElement majorityElement = new Q169_MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
    }
}
