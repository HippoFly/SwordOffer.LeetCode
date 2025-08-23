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
    public int maxPathSum(TreeNode root) {
        // 使用一个单元素数组来保存全局最大路径和，因为Java方法中不能直接修改基本类型变量
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        // 调用辅助方法计算从根节点开始的最大路径和，并更新max数组中的值
        maxPathSum(root, max);
        // 返回计算出的最大路径和
        return max[0];
    }

    /**
     * 计算二叉树中的最大路径和
     * 路径定义：从一个节点到另一个节点的路径，路径上的每个节点最多只能经过一次
     * 最大路径和定义：路径上所有节点值的总和的最大值
     *
     * @param root 二叉树的根节点
     * @param max 用于存储最大路径和的数组，通过引用传递以便更新
     * @return 返回从当前节点出发的最大路径和（注意：这条路径必须包含当前节点，并且只能向下延伸）
     */
    public int maxPathSum(TreeNode root, int[] max) {
        // 如果节点为空，返回0，表示不选择这条路径
        if (root == null) {
            return 0;
        }

        // 递归计算左子树的最大路径和，如果为负则不选择这条路径，取0
        int left = Math.max(0, maxPathSum(root.left, max));

        // 递归计算右子树的最大路径和，如果为负则不选择这条路径，取0
        int right = Math.max(0, maxPathSum(root.right, max));

        // 更新全局最大路径和，考虑跨越根节点的路径
        max[0] = Math.max(max[0], left + right + root.val);

        // 返回从当前节点出发的最大路径和，只能选择左子树或右子树中的一条路径
        return Math.max(left, right) + root.val;
    }
}
