package com.so.leetcode;

/**
 * 74. 搜索二维矩阵
 * <p>
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 11:20
 **/

public class Q74_Search2DMatrix {

    public static void main(String[] args) {
        Q74_Search2DMatrix search2DMatrix = new Q74_Search2DMatrix();
        int[][] ints = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(ints.length);
        System.out.println(ints[0].length);
        System.out.println(search2DMatrix.searchMatrix(ints, 13));
    }

    /**
     * 0  1  2  3 (n)
     * +-----------
     * 0 ｜1  3  5  7
     * 1 ｜10 11 16 20
     * 2 ｜23 30 34 60
     * (m)
     * matrix[0][3] = 7
     * matrix[2][0] = 23
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int mCount = matrix.length;
        int nCount = matrix[0].length;
        int n = nCount - 1, m = 0;

        // 从右上角开始遍历：则判断条件是左下角极值点坐标[mCount,0]为终结循环条件
        while (n >= 0 && m < mCount) {
            // 目标大于当前坐标值，则向下移动m
            if (matrix[m][n] < target) {
                m++;
                // 目标小于当前坐标值，则向左移动n
            } else if (matrix[m][n] > target) {
                n--;
                // 目标等于当前坐标值，则返回true
            } else {
                return true;
            }
        }
        //由于坐标脱离矩阵而退出循环while
        return false;
    }
}
