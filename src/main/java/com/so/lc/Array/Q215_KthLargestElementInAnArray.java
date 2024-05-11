package com.so.lc.Array;

import java.util.PriorityQueue;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 15:47
 **/

public class Q215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Q215_KthLargestElementInAnArray kthLargestElementInAnArray = new Q215_KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{1, 2, 3,4,5,66}, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1,i2)->{
            int i = i2 - i1;
            return i;
        });

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            if(i==k-1){
                return priorityQueue.poll();
            }
            priorityQueue.poll();
        }
        return 0;
    }
}
