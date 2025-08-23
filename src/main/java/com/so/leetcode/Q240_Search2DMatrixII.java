package com.so.leetcode;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:15
 **/

public class Q240_Search2DMatrixII {
    /**
     * 在二维矩阵中搜索目标值
     * 该方法利用矩阵每一行都按照从左到右递增的顺序排序，以及每一列都按照从上到下递增的顺序排序的特性
     * 通过从矩阵右上角开始比较，逐步缩小搜索范围，以高效地找到目标值
     *
     * @param matrix 二维矩阵，其中每个数组代表一行，且每行和每列都是升序的
     * @param target 目标值，要在矩阵中找到的值
     * @return 如果找到目标值，则返回true；否则返回false
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int length = matrix.length ;
        // 搜索的起始位置为矩阵的右上角
        int x = 0, y = matrix[0].length - 1;

        // 当前行数小于矩阵总行数且当前列数不小于0时，继续搜索
        while (x < length && y >= 0) {
            // 如果当前元素等于目标值，返回true
            if (matrix[x][y] == target) {
                return true;
            }
            // 一行的最右端（最大） 大于它，需要向左挪动
            if (matrix[x][y] > target) {
                --y;
                // 否则代表这一行都小于它，下一行
            } else {
                ++x;
            }
        }
        // 如果没有找到目标值，返回false
        return false;
    }
}
