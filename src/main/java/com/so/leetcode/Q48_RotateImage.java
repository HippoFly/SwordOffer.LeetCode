package com.so.leetcode;

/**
 *
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/11 18:07
 * @see <a href="https://leetcode.cn/problems/rotate-image/">48. 旋转图像</a>
 * @tag 矩阵
 **/

public class Q48_RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        // Step 1: 上下翻转（沿水平中线对称）
        // 把最上面的一行和最下面的一行互换
        // 把第二行和倒数第二行互换……
        for (int rowTop = 0; rowTop < size / 2; rowTop++) {
            int rowBottom = size - 1 - rowTop;
            for (int column = 0; column < size; column++) {
                int temporaryValue = matrix[rowTop][column];
                matrix[rowTop][column] = matrix[rowBottom][column];
                matrix[rowBottom][column] = temporaryValue;
            }
        }

        // Step 2: 主对角线翻转（沿左上到右下的对角线对称）
        // 把矩阵的行和列交换，等于围绕主对角线“折叠”一次
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < row; column++) {
                int temporaryValue = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = temporaryValue;
            }
        }
    }


}
