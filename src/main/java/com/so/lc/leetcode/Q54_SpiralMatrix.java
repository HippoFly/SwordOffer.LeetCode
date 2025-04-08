package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 14:57
 * @see <a href="https://leetcode.cn/problems/spiral-matrix/">螺旋矩阵</a>
 * @tag 矩阵
 **/

public class Q54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return arr;
        }

        // 左右边界
        int leftBorder = 0, rightBorder = matrix[0].length - 1;
        // 上下边界
        int topBorder = 0, downBorder = matrix.length - 1;
        /*
        *   （0,0） ——> (0,n)
        *      ⬇️
        *    (n,0)
        * */

        while (leftBorder <= rightBorder && topBorder <= downBorder) {
            // 从左到右遍历上边界
            for (int i = leftBorder; i <= rightBorder; i++) {
                arr.add(matrix[topBorder][i]);
            }
            topBorder++;

            // 从上到下遍历右边界
            for (int i = topBorder; i <= downBorder; i++) {
                arr.add(matrix[i][rightBorder]);
            }
            rightBorder--;

            // 从右到左遍历下边界
            if (topBorder <= downBorder) {
                for (int i = rightBorder; i >= leftBorder; i--) {
                    arr.add(matrix[downBorder][i]);
                }
                downBorder--;
            }

            // 从下到上遍历左边界
            if (leftBorder <= rightBorder) {
                for (int i = downBorder; i >= topBorder; i--) {
                    arr.add(matrix[i][leftBorder]);
                }
                leftBorder++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Q54_SpiralMatrix solution = new Q54_SpiralMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result); // 输出: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }

}
