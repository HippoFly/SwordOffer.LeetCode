package com.so.leetcode;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/5 14:27
 **/

public class Q79_WordSearch {


    /**
     * 遍历
     * 1.判空
     * 2.初始
     * 3.遍历
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        // 生成标记二维数组，标记已经访问过的地点
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
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
     *
     * @param i     即将访问的数组 行坐标
     * @param j     列坐标
     * @param index 匹配第n个字符
     * @return 匹配完成
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        // 终止条件：匹配完成
        if (index == word.length()) {
            return true;
        }

        // 剪枝：
        // i越界 /
        // j越界 /
        // 已访问 /
        // 字符不匹配
        if (
                        i < 0 || i >= board.length ||
                        j < 0 || j >= board[0].length ||
                        visited[i][j] ||
                        board[i][j] != word.charAt(index)
        ) {
            return false;
        }

        // 如果到这一步，那么有之前的的未越界，未访问过，且当前索引字符匹配
        // 标记为已访问
        visited[i][j] = true;

        // 向四个方向探索
        boolean found = dfs(board, word, i + 1, j, index + 1, visited) ||
                dfs(board, word, i - 1, j, index + 1, visited) ||
                dfs(board, word, i, j + 1, index + 1, visited) ||
                dfs(board, word, i, j - 1, index + 1, visited);

        // 回溯
        visited[i][j] = false;

        return found;
    }
}
