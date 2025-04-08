package com.so.lc.leetcode;

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
        int n = matrix.length;
        // 水平翻转 横轴对称一般，竖轴全覆盖
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
