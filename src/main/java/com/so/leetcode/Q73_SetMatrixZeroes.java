package com.so.leetcode;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 14:38
 * @see <a href="https://leetcode.cn/problems/set-matrix-zeroes/">73. 矩阵置零</a>
 * @tag 矩阵
 **/

public class Q73_SetMatrixZeroes {


    /**
     * 思路：
     * 1. 创建两个布尔数组，分别记录哪些行、哪些列需要置零
     * 2. 第一次遍历：记录哪些行、哪些列需要置零
     * 3. 第二次遍历：根据标记置零
     *
     *
     *
     * 面试官可能要求减少空间占用，这个时候记得，需要额外标志位记录首行 首列 是否清零，然后首行首列自身继续对行列统计
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowHasZero = new boolean[m];
        boolean[] colHasZero = new boolean[n];

        // 第一次遍历：记录哪些行、哪些列需要置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        // 第二次遍历：根据标记置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowHasZero[i] || colHasZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        Q73_SetMatrixZeroes solution = new Q73_SetMatrixZeroes();
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solution.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
