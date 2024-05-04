package com.so.lc.Array;

import java.util.HashSet;
import java.util.Set;

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
