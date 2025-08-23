package com.so.leetcode;

import com.so.common.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-14 16:55
 * @tag 二叉树，二叉树深度
 * @link <a href=""></a>
 **/
public class Q104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return maxDepth(root, depth);
    }
    int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        // 这里depth过了为null判断所以本层+1
        int leftDepth = maxDepth(root.left, depth + 1);
        int rightDepth = maxDepth(root.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }
}
