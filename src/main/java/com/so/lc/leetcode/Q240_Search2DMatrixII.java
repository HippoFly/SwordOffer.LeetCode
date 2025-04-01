package com.so.lc.leetcode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:15
 **/

public class Q240_Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length ;
        int x = 0, y = matrix[0].length - 1;
        while (x < length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            // 一行的最顶端（最大） 大于它，需要向底部挪动
            if (matrix[x][y] > target) {
                --y;

                // 一行的最顶端（最大） 小于于它，需要向更大一行挪动
            } else {
                ++x;
            }
        }
        return false;
    }
}
