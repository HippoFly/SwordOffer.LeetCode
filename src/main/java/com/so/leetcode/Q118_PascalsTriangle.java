package com.so.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118.帕斯卡三角形
 * 三角形每一行首尾是1，中间每一个元素是前面夹着的两个元素之和
 * 给n，返回有n行的pascal三角形
 * 1 <= numRows <= 30
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-13 13:55
 * @tag
 * @link <a href=""></a>
 **/
public class Q118_PascalsTriangle {
    /**
     * 嵌套数组模拟二维矩阵进行DP
     * 第 0 行：[1]
     * 第 1 行：[1, 1]
     * 第 2 行：[1, 2, 1]
     * 第 3 行：[1, 3, 3, 1]
     * 第 4 行：[1, 4, 6, 4, 1]
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        // 嵌套for循环，第一层是行，第二层是列
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // 边界位置
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 状态转移：左上 + 上
                    int val = dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j);
                    row.add(val);
                }
            }

            dp.add(row);
        }

        return dp;
    }

}
