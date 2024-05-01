package com.so.lc.Heap;

import java.util.*;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 18:22
 **/

public class Q347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> remMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer existTimes = remMap.get(nums[i]);
            if(!remMap.containsKey(nums[i])){
                remMap.put(nums[i], 1);
            }else {
                remMap.put(nums[i], ++existTimes);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(remMap.entrySet());

        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=list.get(i).getKey();
        }
        return ints;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
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
