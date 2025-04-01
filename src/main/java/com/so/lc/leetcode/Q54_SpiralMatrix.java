package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 14:57
 **/

public class Q54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int left = 0, right = matrix[0].length-1;
        int top = 0, down = matrix.length-1;

        while (true) {
            //  左 -> 右边界
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            // row +1
            top++;
            if (top > down) break;
            //  低->顶边界
            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            // 水平回撤
            right--;
            if (left > right) break;
            // 左边界 <- 右
            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }
            // 下移动一行
            down--;
            if (top > down) break;
            // 左->右边界
            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }
        return arr;
    }

}
