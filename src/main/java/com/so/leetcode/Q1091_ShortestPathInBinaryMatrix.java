package com.so.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 1091. 二进制矩阵中的最短路径
 * <p>
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。
 * 如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）
 * 的路径，该路径同时满足下述要求：
 * 1. 路径途经的所有单元格都的值都是 0 。
 * 2. 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * <p>
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 *
 * @author FlyHippo
 * @version 1.0
 **/

public class Q1091_ShortestPathInBinaryMatrix {

    /**
     * 使用广度优先搜索（BFS）解决二进制矩阵中的最短路径问题
     * <p>
     * 解题思路：
     * 1. 首先检查起点和终点是否为0，如果不为0则直接返回-1
     * 2. 使用BFS从起点开始搜索，每次向8个方向扩展
     * 3. 维护一个距离数组，记录从起点到每个点的最短距离
     * 4. 当到达终点时，返回距离值；如果无法到达终点，返回-1
     *
     * @param grid 二进制矩阵
     * @return 最短路径长度，如果不存在路径则返回-1
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 矩阵边界检查
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int n = grid.length;
        
        // 起点或终点被阻塞，无法形成路径
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // 特殊情况：只有一个格子且为0
        if (n == 1) {
            return 1;
        }

        // 八个方向的偏移量：上下左右和四个对角线方向
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},  // 上方三个方向
                {0, -1},           {0, 1},   // 左右两个方向
                {1, -1},  {1, 0},  {1, 1}    // 下方三个方向
        };

        // BFS队列，存储坐标信息
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        // 标记起点已访问，路径长度为1
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = grid[row][col];

            // 如果到达终点，返回距离
            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            // 向8个方向扩展
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // 检查边界条件和是否可通行
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && grid[newRow][newCol] == 0) {
                    // 标记为已访问，并记录距离
                    grid[newRow][newCol] = distance + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // 无法到达终点
        return -1;
    }

    public static void main(String[] args) {
        Q1091_ShortestPathInBinaryMatrix solution = new Q1091_ShortestPathInBinaryMatrix();

        // 测试示例1
        int[][] grid1 = {{0, 1}, {1, 0}};
        System.out.println("示例1结果: " + solution.shortestPathBinaryMatrix(grid1)); // 应该输出2

        // 测试示例2
        int[][] grid2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println("示例2结果: " + solution.shortestPathBinaryMatrix(grid2)); // 应该输出4

        // 测试示例3
        int[][] grid3 = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println("示例3结果: " + solution.shortestPathBinaryMatrix(grid3)); // 应该输出-1
    }
}