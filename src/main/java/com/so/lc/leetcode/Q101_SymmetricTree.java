package com.so.lc.leetcode;

import com.so.common.TreeNode;

/**
 * 101. 对称二叉树
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-15 09:15
 * @tag 二叉树, 递归
 * @link <a href=""></a>
 **/
public class Q101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode left, TreeNode right) {
        // 检查两个节点是否都为空
        if (left == null && right == null) {
            return true;
        }
        // 检查其中一个节点为空
        if (left == null || right == null) {
            return false;
        }
        // 检查当前节点的值是否相等
        boolean valuesEqual = left.val == right.val;
        // 递归检查左子树和右子树是否对称
        boolean leftSubtreesSymmetric = isSymmetric(left.left, right.right);
        boolean rightSubtreesSymmetric = isSymmetric(left.right, right.left);
        // 返回所有条件的逻辑与
        return valuesEqual && leftSubtreesSymmetric && rightSubtreesSymmetric;
    }
}
