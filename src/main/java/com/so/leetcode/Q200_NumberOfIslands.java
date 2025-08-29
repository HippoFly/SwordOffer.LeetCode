package com.so.leetcode;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * @author FlyHippo
 * @version 1.0
 **/
public class Q200_NumberOfIslands {

    /**
     * 计算二维网格中岛屿的数量
     *
     * 遇到一个岛，先计数再置零（沉岛），再四周搜索，遇到一个岛，计数加1，并置零
     *
     * 使用DFS（深度优先搜索）算法，：
     * 1. 当遇到'1'时，岛屿计数加1
     * 2. 从该位置开始进行DFS，将相连的所有'1'标记为'0'（陆地变水，方便计数）
     * 3. 继续遍历直到所有位置都被访问
     *
     * @param grid 二维字符数组，'1'表示陆地，'0'表示水
     * @return 岛屿的数量
     */
    public int numIslands(char[][] grid) {
        // 判空
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // 遍历网格中的每个位置
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果当前位置是陆地，则进行DFS并将相连的陆地标记为水
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j);
                }
            }
        }

        return islandCount;
    }

    /**
     * 深度优先搜索，将相连的陆地标记为水（沉岛操作，陆地变水，方便计数）
     *
     * @param grid 二维字符数组
     * @param row  当前行索引
     * @param col  当前列索引
     */
    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 边界检查和值检查
        // 如果越界或者当前位置是水，则返回
        //1.
        //防止递归越4条界（row < 0、col < 0、row >= rows、col >= cols）。
        //2.
        //避免重复处理无效格子（grid[row][col] == '0'）。
        //3.
        //确保 DFS 只在有效的陆地（'1'）上递归搜索。
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }

        // 将当前位置标记为已访问（沉岛）
        grid[row][col] = '0';

        // 向四个方向继续搜索
        dfs(grid, row + 1, col); // 下
        dfs(grid, row - 1, col); // 上
        dfs(grid, row, col + 1); // 右
        dfs(grid, row, col - 1); // 左
    }
}