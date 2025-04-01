package com.so.lc.leetcode;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 14:27
 **/

public class Q79_WordSearch {

    //三全局变量
    char[][] board;
    boolean[][] visited;
    String word;

    /**
     * 遍历
     * 1.判空
     * 2.初始
     * 3.遍历
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // 处理输入为空的情况
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;

        // 已经遍历的数组记载
        this.visited = new boolean[row][col];
        this.board = board;
        this.word = word;

        // 遍历二维字符网格
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 对于每个单元格，进行深度优先搜索
                if (dfs( i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 递归
     * 1. 双判：结果，返回（越界4，访问，字符）
     * 2. 访问
     * 3. 布尔四方向
     * 4。不访问
     * 5. 返回
     * @param i 行坐标
     * @param j 列坐标
     * @param index 第n个字符
     * @return 匹配完成
     */
    private boolean dfs( int i, int j, int index) {
        // 检查是否匹配完整个单词
        if (index == word.length()) {
            return true;
        }

        // 边界检查和访问状态检查
        // i,j坐标 越界，
        // visited[i][j]已访问，
        // board字符不符合， 都结束这一层递归
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 标记当前单元格为已访问
        visited[i][j] = true;

        // 沿着四个方向进行深度优先搜索
        boolean exists = dfs(  i + 1, j, index + 1) ||  // 向下
                dfs(  i - 1, j, index + 1) ||  // 向上
                dfs(  i, j + 1, index + 1) ||  // 向右
                dfs(  i, j - 1, index + 1);    // 向左

        // 回溯，恢复单元格的访问状态
        visited[i][j] = false;

        return exists;
    }
}
