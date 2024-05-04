package com.so.lc.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 14:38
 **/

public class Q73_SetMatrixZeroes {
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

}
