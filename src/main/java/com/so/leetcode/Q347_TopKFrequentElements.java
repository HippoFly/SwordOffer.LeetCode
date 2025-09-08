package com.so.leetcode;

import java.util.*;

/**
 *
 * 347. 前 K 个高频元素
 *给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 18:22
 **/

public class Q347_TopKFrequentElements {

    /*
     1，使用 HashMap 统计每个元素的出现次数。
     2，将 HashMap 的条目（Map.Entry）转换为 List。
     3，对 List 按照元素出现次数进行排序。
     4，提取排序后列表中前 k 个元素的键。
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. 用最小堆维护Top K（按频率排序）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );

        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除频率最小的元素
            }
        }

        // 3. 提取结果
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }



}
