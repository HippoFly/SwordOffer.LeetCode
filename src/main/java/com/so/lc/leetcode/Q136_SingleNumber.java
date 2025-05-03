package com.so.lc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class Q136_SingleNumber {
    public int singleNumber(int[] nums) {

        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            if(temp.contains(num)){
                temp.remove(num);
            }else {
                temp.add(num);
            }
        }
            if(temp.size()>0){
                Integer[] integers = temp.toArray(new Integer[0]);
                return integers[0];
            }
        return -1;
    }
}
