package com.so.lc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 16:14
 **/

public class Q51_NQueens {

    List<List<String>> solutions;
    /**
     * queens[0]代表0行的列序数， queens[1]代表1行的列序数
     */
    int[] queens;
    int n;

    public List<List<String>> solveNQueens(int n) {
        // 用于存储每个解法的结果
        this.solutions = new ArrayList<>();
        // 用于存储当前解法中皇后的位置
        this.queens = new int[n];
        // 棋盘格局
        this.n = n;
        // 初始化 queens 数组，全部置为 -1，表示初始时没有皇后放置在棋盘上
        Arrays.fill(queens, -1);


        // 开始回溯搜索解法
        backtrack(0);
        return solutions;
    }

    // 回溯搜索解法

    /**
     * 按+1递归是行数，内部循环遍历+1是列数
     *
     * @param row 行数
     */
    private void backtrack(int row) {
        // 如果当前行超过了棋盘的大小，则说明这一分支递归完毕
        if (row == n) {
            // 将当前解法添加到结果列表中
            solutions.add(generateBoard());
            return;
        }

        // 遍历当前行的每一列，尝试放置皇后
        for (int col = 0; col < n; col++) {
            // 检查当前位置是否可以放置皇后
            if (isValid(row, col)) {
                // 在当前位置放置皇后
                queens[row] = col;
                // 继续搜索下一行
                backtrack(row+1);
                // 回溯到当前行，移除当前位置的皇后，尝试下一个位置
                queens[row] = -1;
            }
        }
    }

    // 检查当前位置是否可以放置皇后

    /**
     * @param row 当前行
     * @param col 当前列
     * @return 有效位置
     */
    private boolean isValid(int row, int col) {
        // 遍历之前已经放置(i < row,不是整个的行长度)的皇后的位置，检查是否有冲突
        for (int i = 0; i < row; i++) {
            // queens[0]代表0行的列序数， queens[1]代表1行的列序数
            //queens[i] == col：这个条件检查当前位置是否和已放置的皇后在同一列，如果在同一列则表示有冲突，返回 false。
            //Math.abs(row - i) == Math.abs(col - queens[i])：这个条件检查当前位置是否和已放置的皇后在同一条对角线上（包括主对角线和副对角线）。如果两个位置的行差等于列差，即 |row - i| == |col - queens[i]|，则表示在同一条对角线上，也表示有冲突，返回 false。
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

    // 生成棋盘的字符串表示
    private List<String> generateBoard() {
        List<String> board = new ArrayList<>();
        // 遍历每一行
        for (int row = 0; row < n; row++) {
            char[] rowString = new char[n];
            // 初始化每一行的字符串，全部置为 '.'
            Arrays.fill(rowString, '.');

            // 在当前行的皇后位置上放置 'Q'
            rowString[queens[row]] = 'Q';
            // 将当前行的字符串添加到棋盘列表中
            board.add(new String(rowString));
        }
        return board;
    }

    public static void main(String[] args) {
        Q51_NQueens solution = new Q51_NQueens();
        int n = 4;
        List<List<String>> solutions = solution.solveNQueens(n);
        System.out.println("Solutions for " + n + "-queens problem:");
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
