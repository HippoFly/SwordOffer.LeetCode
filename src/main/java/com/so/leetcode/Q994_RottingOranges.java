package com.so.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 994. 腐烂的橘子
 * <p>
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * <p>
 * 每分钟，腐烂的橘子周围 4 个方向上相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。
 * 如果不可能，返回 -1。
 * <p>
 * 示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行，第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0。
 *
 * @author FlyHippo
 * @version 1.0
 **/

public class Q994_RottingOranges {

    /**
     * 暴力遍历法 解决腐烂橘子问题
     * <p>
     * 解题思路：
     * 1. 大死循环（直到矩阵不变）
     *   a，复制新矩阵
     *   b，旧矩阵遍历，判断腐烂点，新矩阵标记
     *   c，新矩阵没变化中断循环，
     *      否则换新矩阵，加分钟
     * 2，大循环结束，遍历判断残留返回-1，否则回 time
     *
     * @param grid 二维网格，表示橘子的状态
     * @return 所需的最少分钟数，如果无法全部腐烂则返回-1
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;

        while (true) {
            boolean changed = false;  // 这一分钟有没有橘子变坏
            // 新建一个复制的 grid 来保存这一分钟的变化
            int[][] newGrid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newGrid[i][j] = grid[i][j]; // 先复制一份
                }
            }

            // 遍历所有格子，看腐烂橘子能不能传染
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) { // 腐烂的橘子
                        // 上下左右传染
                        if (i > 0 && grid[i - 1][j] == 1) {
                            newGrid[i - 1][j] = 2;
                            changed = true;
                        }
                        if (i < m - 1 && grid[i + 1][j] == 1) {
                            newGrid[i + 1][j] = 2;
                            changed = true;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            newGrid[i][j - 1] = 2;
                            changed = true;
                        }
                        if (j < n - 1 && grid[i][j + 1] == 1) {
                            newGrid[i][j + 1] = 2;
                            changed = true;
                        }
                    }
                }
            }

            if (!changed) break; // 没有新变化，结束
            // 以下是发生新腐烂的步骤
            grid = newGrid;      // 更新 grid
            time++;              // 分钟 +1
        }

        // 检查是否还有新鲜橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Q994_RottingOranges solution = new Q994_RottingOranges();

        // 测试示例1
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("示例1结果: " + solution.orangesRotting(grid1)); // 应该输出4

        // 测试示例2
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println("示例2结果: " + solution.orangesRotting(grid2)); // 应该输出-1

        // 测试示例3
        int[][] grid3 = {{0, 2}};
        System.out.println("示例3结果: " + solution.orangesRotting(grid3)); // 应该输出0
    }
}