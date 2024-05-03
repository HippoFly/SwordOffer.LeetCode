package com.so.lc.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/3 21:44
 **/

public class Q41_MissingPositive {
    public int firstMissingPositive(int[] nums) {
        int min1 =  Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> allPos = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                allPos.add(nums[i]);
                if(nums[i]<min1){
                    min1 = nums[i];
                }
            }
        }
         if(min1>1){
             return 1;
         }else {
             while (allPos.contains(min1)){
                 min1++;
             }
             return min1;
         }
    }

    /**
     * 桶排序
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int res = 0;
        int n = nums.length - 1;
        int tmp = 0;

        while(res <= n){
            if(nums[res] == res + 1){
                res++;
            }else{
                tmp = nums[res];
                if(tmp > n + 1 || tmp < res + 1 || nums[tmp - 1] == tmp){
                    nums[res] = nums[n--];
                }else{
                    nums[res] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
        }

        return res + 1;
    }



    public static void main(String[] args) {
        Q41_MissingPositive missingPositive = new Q41_MissingPositive();
        System.out.println(missingPositive.firstMissingPositive(new int[]{1, 2, 0, -1}));
    }
}
