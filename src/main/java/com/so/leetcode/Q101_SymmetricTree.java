package com.so.leetcode;

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
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 递归检查两个节点是否对称
     * 1. 检查两个节点是否都为空  false 终止
     * 2. 检查任意一个节点为空  false 终止
     * 3. 检查当前节点的值是否相等   true 其一
     * 4. 递归检查左子树和右子树是否对称
     *    a.左的左和右的右 true 其一
     *    b.左的右和右的左 true 其一
     * 5. 返回3个 true 判断的逻辑与
     * @param left
     * @param right
     * @return
     */
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
