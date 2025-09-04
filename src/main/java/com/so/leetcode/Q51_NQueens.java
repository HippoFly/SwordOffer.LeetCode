package com.so.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 16:14
 **/

public class Q51_NQueens {


    // 结果列表，用来存放所有解
    List<List<String>> solutions = new ArrayList<>();

    /**
     * 1. 棋盘初始化：
     * <p>
     * 创建一个 n x n 的二维棋盘，初始化为 '.'，表示每个位置上没有皇后。
     * 使用 Arrays.fill(row, '.') 来填充每一行的所有位置。
     * <p>
     * 2. 回溯法的核心：
     * <p>
     * backtrack(solutions, board, row) 是核心递归函数。
     * 递归基准：当 row == n 时，说明已经成功放置了 n 个皇后，当前解是有效的。
     * 递归过程：从第 row 行开始，尝试将皇后放置在每一列。如果合法（调用 isValid 判断），则放置皇后并递归进入下一行。
     * <p>
     * 3. 合法性检查 isValid：
     * <p>
     * 需要确保在当前 row 行和 col 列放置皇后不会与其他已经放置的皇后冲突：
     * 检查列：遍历之前的每一行，看看当前列是否已经有皇后。
     * 检查左上对角线：遍历从当前行和列向左上对角线方向的所有格子，看看是否有皇后。
     * 检查右上对角线：同理，遍历右上对角线方向。
     * <p>
     * 4. 回溯撤销：
     * <p>
     * 放置皇后后，需要尝试下一列/下一行。当发现某种情况不行时，回溯到当前行，撤销对该位置的选择（即将其恢复为 '.'）。
     * <p>
     * 5. 构建解 constructSolution：
     * <p>
     * 每当递归成功（即放置完所有皇后），将当前棋盘的状态（二维数组）转换为字符串并保存到 solutions 中。
     * 这一步是将每个解从字符数组转换成字符串列表，使得返回的结果格式符合题目要求。
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {


        // 创建 n x n 的棋盘，并初始化为 '.'
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.'); // 棋盘的每个位置初始化为 '.'
        }

        // 从第 0 行开始，开始回溯搜索
        backtrack(board, 0);
        return solutions; // 返回所有解
    }

    /**
     * 回溯
     * @param board
     * @param row 当前行索引
     */
    private void backtrack(char[][] board, int row) {
        // 终止条件：所有行都放置了皇后，找到一个解
        if (row == board.length) {
            solutions.add(constructSolution(board)); // 构建当前解并添加到结果列表
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < board.length; col++) {
            // 如果当前列放置皇后是合法的
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';  // 放置皇后
                backtrack(board, row + 1);  // 递归处理下一行
                board[row][col] = '.';  // 回溯，撤销当前选择
            }
        }
    }

    // 检查在当前行和列放置皇后是否有效
    private boolean isValid(char[][] board, int row, int col) {
        // 检查当前列是否已有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false; // 如果有皇后，返回 false
            }
        }

        // 检查左上对角线是否已有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false; // 如果有皇后，返回 false
            }
        }

        // 检查右上对角线是否已有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false; // 如果有皇后，返回 false
            }
        }

        // 如果所有检查通过，返回 true
        return true;
    }

    // 构建一个当前棋盘的解（将字符数组转换为字符串形式）
    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));  // 将字符数组转换为字符串并加入解中
        }
        return solution;
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
