package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 17:46
 **/

public class Q56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        // 对区间按照起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        //每次取出来对比的数组
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            // 如果当前区间的结束位置 currentInterval[1] 大于等于下一个区间的起始位置 interval[0]，说明存在重叠，
            // 合并区间 但是只改 currentInterval的结束位置
            if (currentInterval[1] >= interval[0]) {

                // 更新当前区间的结束位置
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {

                // 将当前区间加入结果列表
                merged.add(currentInterval);

                // 更新当前区间为下一个区间
                currentInterval = interval;
            }
        }

        // 加入最后一个合并后的区间
        merged.add(currentInterval);
        // List -> arr[]
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Q56_MergeIntervals solution = new Q56_MergeIntervals();
        int[][] result = solution.merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
