package com.so.leetcode;

import com.so.common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-17 14:48
 * @tag
 * @link <a href=""></a>
 **/
public class Q124_MaximumPathSum {
    /**
     * 计算二叉树中的最大路径和
     * 最大路径和的定义是：从树中任意节点出发，沿树的边向下移动，可以不经过某些节点，直到另一个节点为止，路径上所有节点值的和
     * 此方法的主要挑战在于处理路径可能跨越的子树，以及找到一种方式来记录全局最大路径和
     *
     * @param root 二叉树的根节点，作为计算最大路径和的起点
     * @return 返回计算出的最大路径和
     */
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        // 左右子树的最大贡献值（小于0的直接丢掉）
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        // 以当前节点为最高点的路径和
        int priceNewPath = root.val + left + right;

        // 更新全局最大值
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回当前节点作为一条路径的贡献值
        return root.val + Math.max(left, right);
    }
}

