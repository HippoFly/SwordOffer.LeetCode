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
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=list.get(i).getKey();
        }
        return ints;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=pq.remove();
        }
        return ints;
    }

}
