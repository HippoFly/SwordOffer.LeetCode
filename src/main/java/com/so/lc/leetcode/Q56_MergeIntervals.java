package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 17:46
 * @tag 贪心算法，排序遍历,
 **/

public class Q56_MergeIntervals {

    // 排序遍历法
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 第一步：按照区间的起始位置排序，按照生序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


        // 第二步：初始化

        // 结果列表
        List<int[]> merged = new ArrayList<>();
        // 初始化第一个区间为当前区间
        int[] currentInterval = intervals[0];
        // 先将第一个区间加入结果列表
        merged.add(currentInterval);

        // 第三步：遍历所有区间
        for (int i = 1; i < intervals.length; i++) {
            // 取出下一个区间数组
            int[] nextInterval = intervals[i];

            // 判断当前区间和下一个区间是否重叠
            if (currentInterval[1] >= nextInterval[0]) {
                // 如果重叠，更新当前区间的结束位置为两者最大值
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
                // 这里对currentInterval已经加入结果，只管吞大


                // 只到下一个for循环更新nextInterval，看是否继续吞Max


            } else {
                // 如果不重叠，将下一个区间作为新的当前区间，并加入结果列表
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        // 第四步：将结果列表转换为数组返回
        //  List转数组
        //int[][] resultArray = merged.toArray(new int[merged.size()][])
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
