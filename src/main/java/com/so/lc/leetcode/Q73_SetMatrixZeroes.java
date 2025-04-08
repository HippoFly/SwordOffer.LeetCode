package com.so.lc.leetcode;

import java.util.HashSet;
import java.util.Set;

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
     * 额外空间记录零位置(不符合要求)
     * 思路：
     * 1. 遍历矩阵，将所有0所在的行和列记录下来
     * 2. 再次遍历矩阵，如果该行或列包含0，则置为0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (row_zero.contains(i) || col_zero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 首行列标记法
     * 第一步，用标志符号记录第一行第一列是否为0
     * 第二步，再用第一行列标记内部置零
     * 第三步，根据第一行列直0
     * 第四步，对第一行列置零
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 检查第一行是否包含0
        boolean firstRowZero = false;
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 检查第一列是否包含0
        boolean firstColZero = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 标记需要置零的行和列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据标记将矩阵置零
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第一行
        if (firstRowZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // 处理第一列
        if (firstColZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
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
        solution.setZeroes2(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
