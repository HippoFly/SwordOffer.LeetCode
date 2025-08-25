package com.so.leetcode;

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

    /**
     * 做法：
     *
     * 从根节点开始，允许区间是 (-∞, +∞)。
     *
     * 递归左子树时，更新最大值：(min, node.val)
     *
     * 递归右子树时，更新最小值：(node.val, max)
     *
     * 如果有节点不在区间内 → 直接返回 false。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // 初始时，根节点的允许范围是 (-∞, +∞)
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归检查一棵树是否是 BST
     * @param node 当前节点
     * @param min  该节点允许的最小值（必须大于 min）
     * @param max  该节点允许的最大值（必须小于 max）
     */
    private boolean validate(TreeNode node, long min, long max) {
        // 空节点天然合法
        if (node == null) return true;

        // 当前节点值必须在 (min, max) 区间内
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // 递归检查左右子树
        // 左子树最大值受当前节点限制
        // 右子树最小值受当前节点限制
        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
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
