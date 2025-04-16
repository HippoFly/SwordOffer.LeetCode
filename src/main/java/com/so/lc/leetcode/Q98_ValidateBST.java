package com.so.lc.leetcode;

import com.so.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 98. 验证二叉搜索树
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-04-16 09:51
 * @tag 二叉树，BST
 * @link <a href=""></a>
 **/
public class Q98_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归辅助函数，用于验证二叉搜索树
     *
     * @param root 当前节点
     * @param minVal 当前节点值的最小允许值
     * @param maxVal 当前节点值的最大允许值
     * @return 返回当前子树是否为有效的二叉搜索树
     */
    private boolean isValidBSTHelper(TreeNode root, long minVal, long maxVal) {
        // 递归终止条件：当前节点为空，返回 true
        if (root == null) {
            return true;
        }

        // 当前节点值必须在 (minVal, maxVal) 范围内
        if (root.val <= minVal || root.val >= maxVal) {
            return false;
        }

        // 递归验证左子树和右子树
        // 左子树的值必须小于当前节点值，更新 maxVal 为当前节点值
        boolean validLeft = isValidBSTHelper(root.left, minVal, root.val);
        // 右子树的值必须大于当前节点值，更新 minVal 为当前节点值
        boolean validRight = isValidBSTHelper(root.right, root.val, maxVal);

        return validLeft && validRight;
    }

    @Test
    public void testIsValidBST() {
        // 测试用例 1: 有效的二叉搜索树
        /*
              2
             / \
            1   3
         */
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        Q98_ValidateBST solution = new Q98_ValidateBST();
        assertTrue(solution.isValidBST(root1));

        // 测试用例 2: 无效的二叉搜索树
        /*
              5
             / \
            1   4
               / \
              3   6
         */
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        assertFalse(solution.isValidBST(root2));

        // 测试用例 3: 有效的二叉搜索树
        /*
              1
             / \
            0   2
         */
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(2);

        assertTrue(solution.isValidBST(root3));

        // 测试用例 4: 无效的二叉搜索树
        /*
              1
             / \
            2   3
         */
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);

        assertFalse(solution.isValidBST(root4));

        // 测试用例 5: 有效的二叉搜索树
        /*
              5
             / \
            1   7
               / \
              6   8
         */
        TreeNode root5 = new TreeNode(5);
        root5.left = new TreeNode(1);
        root5.right = new TreeNode(7);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(8);

        assertTrue(solution.isValidBST(root5));
    }
}
