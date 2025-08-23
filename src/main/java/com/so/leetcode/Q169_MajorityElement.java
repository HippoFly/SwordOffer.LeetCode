package com.so.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 17:52
 **/

public class Q169_MajorityElement {
    /**
     * HashMap过半计数法
     * @param nums
     * @return
     */
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

    /**
     * 投票算法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;      // 投票计数器
        int candidate = 0;  // 候选人

        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // 如果当前没有支持者，换候选人
            }
            // 如果当前数等于候选人，投他；否则反对
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;  // 最终剩下的候选人就是多数元素
    }

    public static void main(String[] args) {
        Q169_MajorityElement majorityElement = new Q169_MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
    }
}
